package sa.com.cloudsolutions.antikythera.testhelper.evaluator;

import java.util.ArrayList;

@SuppressWarnings("java:S106")
public class Locals {
    public static void main(String[] args) {
        Locals l = new Locals();
        l.doStuff();
        l.arrayAccess();
        l.mce();
        l.people();
        l.cleanEmail();
    }

    @SuppressWarnings("java:S1199")
    private void doStuff() {
        int c = 100;
        {
            int a = 10;
            int b = 20;
            System.out.println(a + "," + b + "," + c);
            c = 200;
        }
        int a = 20;
        int b = 30;
        System.out.println(a +"," + b + "," + c);
    }

    private void mce() {
        String s = new ArrayList<String>().toString();
        System.out.print(s);
    }

    private void arrayAccess() {
        String[] a = {"Hello", "World"};
        System.out.println(a[0].toUpperCase() + a[1].toUpperCase() + 9.1);
    }

    private void people() {
        IPerson[] a = {new Person("Bertie"), new Person("Biggles")};
        System.out.println(a[0].getName() + " and " + a[1].getName());
    }

    private void cleanEmail() {
        Person p = new Person("Baggins");
        p.setCleanEmail("BAGGINS@shire.COM");
        System.out.println(p.getEmail());
    }

}
