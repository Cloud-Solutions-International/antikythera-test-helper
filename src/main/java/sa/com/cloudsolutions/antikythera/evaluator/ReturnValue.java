package sa.com.cloudsolutions.antikythera.evaluator;

import java.io.Serializable;

@SuppressWarnings("unused")
public class ReturnValue implements Serializable {
    private int number = 10;

    public void printName() {
        System.out.println(getName());
    }

    public String getName() {
        return "John";
    }

    public void printNumberField() {
        System.out.println(getNumber());
    }

    public int getNumber() {
        return number;
    }

    public int returnConditionally() {
        if (number == 10) {
            return 10;
        } else if (number == 20){
            return 20;
        }
        System.out.println("THIS SHOULD NOT BE PRINTED");

        return 11;
    }

    public int deepReturn() {
        if (number == 10) {
            number += 2;
            if(number == 12) {
                number--;
                --number;
                ++number;
                number++;
                if(number == 12) {
                    return number;
                }
                System.out.println("A");
            }
            System.out.println("B");
        }
        System.out.println("C");
        return 10;
    }

    static String toUpper(String a) {
        return a.toUpperCase();
    }

    static String toLower(String a) {
        return a.toUpperCase();
    }

    static int first(int a, int b) {
        return a + b;
    }

    public static void deepEnums() {
        System.out.println(toLower(toUpper(MultiFieldEnum.KARLA.getName())) + first(MultiFieldEnum.KARLA.getId(), 1));
    }


    public static void deepOCE(Integer a1, Double a2) {
        System.out.print(
                String.format("%s %d %g", new Person(
                MultiFieldEnum.KARLA.getId(),
                MultiFieldEnum.KARLA.getName(), "", "","" ) ,
                        a1 , a2));
    }
    public static void deepCalls() {
        System.out.println(toLower(toUpper("upper")) + first(1, 1));
    }

    public static void main(String[] args) {
        deepOCE(1, 2.0);
    }
}


