package sa.com.cloudsolutions.antikythera.testhelper.evaluator;

@SuppressWarnings("java:S106")
public enum Status {
    OPEN("OPEN"),CLOSED("CLOSED");
    private String status;

    Status(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }

    public String getStatus() {
        return status;
    }

    public static void cmp1(Status s) {
        if (s.equals(OPEN)) {
            System.out.print("OPEN!");
        }
        else {
            System.out.print("CLOSED!");
        }
    }

    public static void cmp5(Status s) {
        if (OPEN.equals(s)) {
            System.out.print("OPEN!");
        }
        else {
            System.out.print("CLOSED!");
        }
    }


    public static void cmp2(Status s) {
        if (s == OPEN) {
            System.out.print("OPEN!");
        }
        else {
            System.out.print("CLOSED!");
        }
    }

    public static void cmp3(Status s) {
        if (s != OPEN) {
            System.out.print("CLOSED!");
        }
        else {
            System.out.print("OPEN!");
        }
    }

    public static void cmp4(Status s) {
        if (OPEN == s) {
            System.out.print("OPEN!");
        }
        else {
            System.out.print("CLOSED!");
        }
    }

    public static void printStatus() {
        System.out.println(Status.OPEN);
    }

    public static void main(String[] args) {
        cmp1(Status.OPEN);
    }

}
