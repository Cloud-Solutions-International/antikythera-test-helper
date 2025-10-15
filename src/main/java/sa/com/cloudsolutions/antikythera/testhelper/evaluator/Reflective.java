package sa.com.cloudsolutions.antikythera.testhelper.evaluator;

public class Reflective {
    private static void createPerson1() throws ReflectiveOperationException{
        Class<?> personClass = Class.forName("sa.com.cloudsolutions.antikythera.testhelper.evaluator.Person");
        Object person = personClass.getDeclaredConstructor(String.class).newInstance("Horatio");
        System.out.println("Person created: " + person);
    }

    private static void createPerson2() throws ReflectiveOperationException{
        Class<?> personClass = Class.forName("sa.com.cloudsolutions.antikythera.testhelper.evaluator.Person");
        Object person = personClass.getDeclaredConstructor(
                int.class, String.class, String.class, String.class, String.class
        ).newInstance(1, "Horatio", "Colombo","12345","horatio@atropos.com");
        Person p = (Person) person;
        System.out.println("Person created: " + p.getName() + " " + p.getAddress());
    }

    /**
     * Assign values to certain fields in the Person class through reflection.
     * Demonstrates setting private fields such as address, phone, email and age.
     */
    @SuppressWarnings({"java:S3011", "java:S106"})
    private static void assignPersonFields() throws ReflectiveOperationException {
        Class<?> personClass = Class.forName("sa.com.cloudsolutions.antikythera.testhelper.evaluator.Person");
        // Create a Person with just the name constructor
        Object person = personClass.getDeclaredConstructor(String.class).newInstance("Horatio");

        // address
        java.lang.reflect.Field address = personClass.getDeclaredField("address");
        address.setAccessible(true);
        address.set(person, "Colombo");

        // phone
        java.lang.reflect.Field phone = personClass.getDeclaredField("phone");
        phone.setAccessible(true);
        phone.set(person, "12345");

        // email
        java.lang.reflect.Field email = personClass.getDeclaredField("email");
        email.setAccessible(true);
        email.set(person, "horatio@atropos.com");

        // age (no public getter/setter in Person, set via reflection)
        try {
            java.lang.reflect.Field age = personClass.getDeclaredField("age");
            age.setAccessible(true);
            age.setInt(person, 35);
        } catch (NoSuchFieldException ignore) {
            // In case the field is renamed/removed, we simply skip setting it.
        }

        Person p = (Person) person;
        System.out.println("Updated via reflection: " + p.getName() + ": " + p.getAddress() + ": " + p.getPhone() + ": " + p.getEmail());
    }

    public static void main(String[] args) throws ReflectiveOperationException {
        Reflective.createPerson2();
        Reflective.assignPersonFields();
    }
}
