package sa.com.cloudsolutions.antikythera.evaluator;

@SuppressWarnings({"java:S106", "unused"})
public class TryCatch {
    TryCatch() {

    }

    public static void main(String[] args) {
        TryCatch tc = new TryCatch();
        tc.tryNPE();
        tc.nested();
        System.out.println("Return value of callNPEmethod: " + tc.callNPEmethod());

    }

    public void nested() {
        try {
            try {
                String s = null;
                s.length();
                System.out.println("This bit of code should not be executed");

            } catch (NullPointerException e) {
                System.out.println("Caught an exception");
            } finally {
                System.out.println("The first finally block");
            }

            String t = null;
            t.length();
            System.out.println("This bit of code should not be executed");

        } catch (NullPointerException e) {
            System.out.println("Caught another exception");
        } finally {
            System.out.println("The second finally block");
        }
    }

    public void throwTantrum(int a) {
        if(a == 1) {
            throw new RuntimeException("Throwing a tantrum");
        }
        else {
            System.out.println("No tantrum thrown");
        }
        System.out.println("Bye");
    }

    public void justThrow() throws CustomException {
        throw new CustomException();
    }

    public void tryNPE() {
        try {
            String s = null;
            s.length();
            System.out.println("This bit of code should not be executed");
        } catch (NullPointerException e) {
            System.out.println("Caught an exception");
        } finally {
            System.out.println("Finally block");
        }
    }

    public String hasNPE() {
        String s = null;
        if (s.equals("")) {
            return "This will not be executed";
        }
        return "This will not be executed either";
    }

    public Integer callNPEmethod() {
        try {
            hasNPE();
            return 1;
        } catch (NullPointerException e) {
            System.out.println("Caught an exception in callNPEmethod");
        } finally {
            System.out.println("Finally block in callNPEmethod");
        }
        return 2;
    }

    public static class CustomException extends Exception {

    }
}
