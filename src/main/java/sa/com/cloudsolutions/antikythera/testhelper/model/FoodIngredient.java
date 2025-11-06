package sa.com.cloudsolutions.antikythera.testhelper.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class FoodIngredient {

    // Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Fields used in the repository query
    @Column(name = "vendor_id")
    private Long vendorId;

    @Column(name = "warehouse_id")
    private Long warehouseId;

    @Column(name = "ingredient_id")
    private Long ingredientId;

    // This field corresponds to 'IsApprovedIngredientIsNull'
    // It is typically a Boolean or Wrapper Boolean (Boolean) to allow for NULL values in the database
    @Column(name = "is_approved_ingredient")
    private Boolean isApprovedIngredient;

    @Column(name = "ingredient_master_data_reference_id")
    private Long ingredientMasterDataReferenceId;
}
