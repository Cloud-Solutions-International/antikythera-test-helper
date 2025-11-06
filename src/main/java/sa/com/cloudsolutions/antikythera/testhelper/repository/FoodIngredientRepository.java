package sa.com.cloudsolutions.antikythera.testhelper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface FoodIngredientRepository<FoodIngredient> extends JpaRepository<FoodIngredient, Long> {

    /**
     * Finds the first FoodIngredient matching EITHER of two complex criteria:
     * 1. vendorId AND warehouseId AND ingredientId AND isApprovedIngredient IS NULL
     * OR
     * 2. vendorId AND warehouseId AND ingredientMasterDataReferenceId
     *
     * @param vendorId1 Value for the first VendorId in the first OR clause
     * @param warehouseId1 Value for the first WarehouseId in the first OR clause
     * @param ingredientId Value for IngredientId
     * @param vendorId2 Value for the second VendorId in the second OR clause
     * @param warehouseId2 Value for the second WarehouseId in the second OR clause
     * @param ingredientMasterDataReferenceId Value for IngredientMasterDataReferenceId
     * @return An Optional containing the first matching FoodIngredient, or empty if none is found.
     */
    Optional<FoodIngredient> findFirstByVendorIdAndWarehouseIdAndIngredientIdAndIsApprovedIngredientIsNullOrVendorIdAndWarehouseIdAndIngredientMasterDataReferenceId(
            Long vendorId1,
            Long warehouseId1,
            Long ingredientId,
            Long vendorId2,
            Long warehouseId2,
            Long ingredientMasterDataReferenceId
    );
}
