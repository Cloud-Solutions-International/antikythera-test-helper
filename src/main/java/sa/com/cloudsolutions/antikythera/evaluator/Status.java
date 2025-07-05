package sa.com.cloudsolutions.antikythera.evaluator;

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

    public static void cmp1(Status s) {
        if (s.equals(OPEN)) {
            System.out.println("OPEN!");
        }
        else {
            System.out.println("CLOSED!");
        }
    }

    public static void cmp2(Status s) {
        if (s == OPEN) {
            System.out.println("OPEN!");
        }
        else {
            System.out.println("CLOSED!");
        }
    }

    public static void printStatus() {
        System.out.println(Status.OPEN);
    }

    public static void main(String[] args) {
        cmp1(Status.OPEN);
    }

}
