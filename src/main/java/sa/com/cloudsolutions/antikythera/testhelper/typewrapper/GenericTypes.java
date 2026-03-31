package sa.com.cloudsolutions.antikythera.testhelper.typewrapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.BiFunction;

/**
 * Test fixture for generic type resolution and ordering contract testing.
 * Used by TypeWrapper migration Phase 0 tests.
 *
 * Key test scenarios:
 * - Simple generics: List<String>
 * - Nested generics: Map<String, List<Integer>>
 * - Multiple type parameters: BiFunction<String, Integer, Boolean>
 * - Wildcard types: List<?>, Map<String, ? extends Number>
 * - Bounded types: <T extends Comparable<T>>
 */
public class GenericTypes<T extends Comparable<T>> {

    // Simple generic field
    private List<String> stringList;

    // Nested generic field
    private Map<String, List<Integer>> nestedMap;

    // Multiple type parameters
    private BiFunction<String, Integer, Boolean> biFunction;

    // Wildcard - unbounded
    private List<?> unboundedWildcard;

    // Wildcard - upper bounded
    private Map<String, ? extends Number> upperBoundedWildcard;

    // Wildcard - lower bounded
    private List<? super Integer> lowerBoundedWildcard;

    // Type parameter usage
    private List<T> typeParamList;

    // Optional wrapping
    private Optional<List<String>> optionalList;

    // Method with generic return type
    public List<String> getStringList() {
        return stringList;
    }

    // Method with nested generics
    public Map<String, List<Integer>> getNestedMap() {
        return nestedMap;
    }

    // Method with multiple type params
    public <K, V> Map<K, V> createMap(K key, V value) {
        return Map.of(key, value);
    }

    // Method returning type parameter
    public T getFirst(List<T> items) {
        return items.isEmpty() ? null : items.get(0);
    }

    // Method with wildcard parameter
    public void processWildcard(List<? extends Number> numbers) {
        for (Number n : numbers) {
            System.out.println(n);
        }
    }

    // Method with function parameter
    public <R> R transform(T input, Function<T, R> transformer) {
        return transformer.apply(input);
    }

    // Generic method with multiple bounds
    public <U extends Comparable<U> & CharSequence> int compareSequences(U a, U b) {
        return a.compareTo(b);
    }

    // Setters for testing
    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public void setNestedMap(Map<String, List<Integer>> nestedMap) {
        this.nestedMap = nestedMap;
    }

    public void setBiFunction(BiFunction<String, Integer, Boolean> biFunction) {
        this.biFunction = biFunction;
    }

    public void setUnboundedWildcard(List<?> unboundedWildcard) {
        this.unboundedWildcard = unboundedWildcard;
    }

    public void setUpperBoundedWildcard(Map<String, ? extends Number> upperBoundedWildcard) {
        this.upperBoundedWildcard = upperBoundedWildcard;
    }

    public void setLowerBoundedWildcard(List<? super Integer> lowerBoundedWildcard) {
        this.lowerBoundedWildcard = lowerBoundedWildcard;
    }

    public void setTypeParamList(List<T> typeParamList) {
        this.typeParamList = typeParamList;
    }

    public void setOptionalList(Optional<List<String>> optionalList) {
        this.optionalList = optionalList;
    }
}
