package sa.com.cloudsolutions.antikythera.testhelper.evaluator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tea {
    private String origin;
    private int quantity;
    private boolean isOrganic;
    private Boolean isBop;
    private Boolean ceylon;
    private boolean green;

    @SuppressWarnings("java:S106")
    public void run() {
        setOrigin("Great Western");
        setQuantity(100);
        setOrganic(true);
        setIsBop(true);
        setCeylon(true);
        setGreen(false);

        System.out.println("Tea Origin: " + getOrigin());
        System.out.println("Tea Quantity: " + getQuantity());
        System.out.println("Is Organic: " + isOrganic());
        System.out.println("Is BOP: " + getIsBop());
        System.out.println("Is Ceylon: " + getCeylon());
        System.out.println("Is Green: " + isGreen());
    }
    public static void main(String[] args) {
        Tea tea = new Tea();
        tea.run();
    }
}
