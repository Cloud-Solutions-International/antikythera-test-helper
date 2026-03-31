package sa.com.cloudsolutions.antikythera.testhelper.evaluator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Test fixture for Evaluator's scope chain refactoring (evaluateScopeStep and ScopeStepResult).
 * Tests various scope chain patterns including field access, method calls, array access, and object creation.
 */
@SuppressWarnings("java:S106")
public class ScopeChainTester {

    private Person person;
    private List<Person> people;
    private Map<String, Person> personMap;
    private String[] names;

    public ScopeChainTester() {
        person = new Person("John");
        people = new ArrayList<>();
        people.add(person);
        personMap = new HashMap<>();
        personMap.put("key", person);
        names = new String[]{"Alice", "Bob"};
    }

    /**
     * Test field access scope step.
     */
    public String accessPersonName() {
        return person.getName();
    }

    /**
     * Test method call scope step.
     */
    public String getFirstPersonName() {
        return people.get(0).getName();
    }

    /**
     * Test chained method calls in scope.
     */
    public String chainedMethodCalls() {
        return person.getName().toUpperCase().substring(0, 1);
    }

    /**
     * Test array access scope step.
     */
    public String getFirstName() {
        return names[0];
    }

    /**
     * Test map access scope step.
     */
    public String getPersonFromMap() {
        return personMap.get("key").getName();
    }

    /**
     * Test object creation in scope chain.
     */
    public Person createNewPerson() {
        return new Person("New");
    }

    /**
     * Test this expression scope step.
     */
    public ScopeChainTester getSelf() {
        return this;
    }

    /**
     * Test type expression scope step (static reference).
     */
    public Class<Person> getPersonClass() {
        return Person.class;
    }

    /**
     * Complex scope chain with multiple steps.
     */
    public String complexScopeChain() {
        return this.person.getName().substring(0, 1).toLowerCase();
    }

    /**
     * Scope chain with field access followed by method call.
     */
    public int getNameLength() {
        return person.getName().length();
    }

    /**
     * Scope chain that returns early (tests ScopeStepResult.stop).
     */
    public String conditionalScope() {
        if (person == null) {
            return "null";
        }
        return person.getName();
    }
}
