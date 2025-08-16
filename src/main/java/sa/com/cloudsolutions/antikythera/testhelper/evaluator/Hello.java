package sa.com.cloudsolutions.antikythera.testhelper.evaluator;

/**
 * Note Cloneable to help test the InterfaceSolver
 */
@SuppressWarnings({"unused","java:S106"})
public class Hello implements  Cloneable{
    Integer field = 10;

    public void helloWorld() {
        System.out.println("Hello, Antikythera");
    }

    public void helloName(String name) {
        System.out.println("Hello, " + name);
    }

    public void helloUpper(String name) {
        String upper = name.toUpperCase();
        System.out.println("Hello, " + upper);
    }

    public void longChain() {
        String a = field.toString().replace("10","This IS A FIELD").toUpperCase().toString().toLowerCase().substring(1);
        System.out.println(a);
    }
    public void helloChained(String name) {
        String a = name.toUpperCase().substring(1);
        System.out.println("Hello, " + a);
    }

    public void helloEnum1() {
        System.out.println(Status.OPEN.getStatus());
    }
    public void helloEnum2() {
        System.out.println(Status.CLOSED.getStatus());
    }

    public void helloEnum3() {
        System.out.println(MultiFieldEnum.KARLA.getId() + " " + MultiFieldEnum.KARLA.getName());
    }

    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.longChain();
        hello.helloEnum3();
    }

    @Override
    public Hello clone() throws CloneNotSupportedException {
        return (Hello) super.clone();
    }
}
