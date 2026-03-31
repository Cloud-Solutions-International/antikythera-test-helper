package sa.com.cloudsolutions.antikythera.testhelper.typewrapper;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.io.Serializable;
import java.util.RandomAccess;

/**
 * Test fixture for cross-boundary type resolution (source types extending/implementing JAR types).
 * Used by TypeWrapper migration Phase 0 tests.
 *
 * Key test scenarios:
 * - Source class extending JAR class (AbstractList)
 * - Source class implementing JAR interface (Serializable, RandomAccess)
 * - Source class implementing multiple JAR interfaces
 * - Generic inheritance from JAR types
 */
public class CrossBoundaryTypes {

    /**
     * Source class extending JAR abstract class (java.util.AbstractList).
     * Tests: isAssignableFrom(List, CustomList) should be true
     */
    public static class CustomList<E> extends AbstractList<E> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 1L;
        private final Object[] elements;
        private int size;

        public CustomList(int capacity) {
            elements = new Object[capacity];
            size = 0;
        }

        @Override
        @SuppressWarnings("unchecked")
        public E get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            return (E) elements[index];
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public E set(int index, E element) {
            @SuppressWarnings("unchecked")
            E old = (E) elements[index];
            elements[index] = element;
            return old;
        }

        @Override
        public void add(int index, E element) {
            elements[index] = element;
            size++;
        }
    }

    /**
     * Source class implementing JAR interface directly.
     * Tests: isAssignableFrom(Comparable, ComparableEntity) should be true
     */
    public static class ComparableEntity implements Comparable<ComparableEntity> {
        private final int id;
        private final String name;

        public ComparableEntity(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public int compareTo(ComparableEntity other) {
            return Integer.compare(this.id, other.id);
        }

        public int getId() { return id; }
        public String getName() { return name; }
    }

    /**
     * Source class implementing multiple JAR interfaces.
     * Tests multiple interface inheritance checking.
     */
    public static class MultiInterfaceImpl implements Serializable, Cloneable, Comparable<MultiInterfaceImpl> {
        private static final long serialVersionUID = 1L;
        private int value;

        public MultiInterfaceImpl(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(MultiInterfaceImpl other) {
            return Integer.compare(this.value, other.value);
        }

        @Override
        public MultiInterfaceImpl clone() {
            try {
                return (MultiInterfaceImpl) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }

        public int getValue() { return value; }
    }

    /**
     * Source interface extending JAR interface.
     */
    public interface ExtendedCollection<E> extends Collection<E> {
        E getFirst();
        E getLast();
    }

    /**
     * Source class implementing source interface that extends JAR interface.
     * Tests: isAssignableFrom(Collection, ExtendedCollectionImpl) should be true
     */
    public static class ExtendedCollectionImpl<E> implements ExtendedCollection<E> {
        private final List<E> delegate = new ArrayList<>();

        @Override
        public E getFirst() {
            return delegate.isEmpty() ? null : delegate.get(0);
        }

        @Override
        public E getLast() {
            return delegate.isEmpty() ? null : delegate.get(delegate.size() - 1);
        }

        @Override
        public int size() { return delegate.size(); }

        @Override
        public boolean isEmpty() { return delegate.isEmpty(); }

        @Override
        public boolean contains(Object o) { return delegate.contains(o); }

        @Override
        public Iterator<E> iterator() { return delegate.iterator(); }

        @Override
        public Object[] toArray() { return delegate.toArray(); }

        @Override
        public <T> T[] toArray(T[] a) { return delegate.toArray(a); }

        @Override
        public boolean add(E e) { return delegate.add(e); }

        @Override
        public boolean remove(Object o) { return delegate.remove(o); }

        @Override
        public boolean containsAll(Collection<?> c) { return delegate.containsAll(c); }

        @Override
        public boolean addAll(Collection<? extends E> c) { return delegate.addAll(c); }

        @Override
        public boolean removeAll(Collection<?> c) { return delegate.removeAll(c); }

        @Override
        public boolean retainAll(Collection<?> c) { return delegate.retainAll(c); }

        @Override
        public void clear() { delegate.clear(); }
    }

    /**
     * Deep inheritance chain: Source -> Source -> JAR
     */
    public static abstract class AbstractCustomList<E> extends AbstractList<E> {
        public abstract E getDefault();
    }

    public static class ConcreteCustomList extends AbstractCustomList<String> {
        private final List<String> items = new ArrayList<>();

        @Override
        public String getDefault() {
            return "";
        }

        @Override
        public String get(int index) {
            return items.get(index);
        }

        @Override
        public int size() {
            return items.size();
        }
    }
}
