package sa.com.cloudsolutions.antikythera.testhelper.evaluator;

public class Reflective {
    private static void createPerson1() throws ReflectiveOperationException{
        Class<?> personClass = Class.forName("sa.com.cloudsolutions.antikythera.evaluator.Person");
        Object person = personClass.getDeclaredConstructor(String.class).newInstance("Horatio");
        System.out.println("Person created: " + person);
    }

    private static void createPerson2() throws ReflectiveOperationException{
        Class<?> personClass = Class.forName("sa.com.cloudsolutions.antikythera.evaluator.Person");
        Object person = personClass.getDeclaredConstructor(
                int.class, String.class, String.class, String.class, String.class
        ).newInstance(1, "Horatio", "Colombo","12345","horatio@atropos.com");
        Person p = (Person) person;
        System.out.println("Person created: " + p.getName() + " " + p.getAddress());
    }

    public static void main(String[] args) throws ReflectiveOperationException {
        Reflective.createPerson2();
    }
}
