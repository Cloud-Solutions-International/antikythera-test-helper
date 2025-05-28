package sa.com.cloudsolutions.antikythera.evaluator;

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

    public static void main(String[] args) {
        Tea tea = new Tea();
        tea.setOrigin("Great Western");
        tea.setQuantity(100);
        tea.setOrganic(true);
        tea.setIsBop(true);
        tea.setCeylon(true);
        tea.setGreen(false);

        System.out.println("Tea Origin: " + tea.getOrigin());
        System.out.println("Tea Quantity: " + tea.getQuantity());
        System.out.println("Is Organic: " + tea.isOrganic());
        System.out.println("Is BOP: " + tea.getIsBop());
        System.out.println("Is Ceylon: " + tea.getCeylon());
        System.out.println("Is Green: " + tea.isGreen());
    }
}
