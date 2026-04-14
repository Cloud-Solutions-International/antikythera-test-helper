/*
 * Decompiled with CFR 0.152.
 */
package sa.com.cloudsolutions.antikythera.testhelper.evaluator;

import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import sa.com.cloudsolutions.antikythera.testhelper.evaluator.FakeSearchModel;
import sa.com.cloudsolutions.antikythera.testhelper.model.FakeEntity;

public class RecordSearchSpecification {
    private RecordSearchSpecification() {
        throw new IllegalStateException("Utility class");
    }

    public static Specification<FakeEntity> searchRecords(FakeSearchModel model) {
        return (Specification & Serializable)(root, criteriaQuery, criteriaBuilder) -> {
            ArrayList<Predicate> filters = new ArrayList<Predicate>();
            RecordSearchSpecification.refactoredA((Root<FakeEntity>)root, filters, model);
            RecordSearchSpecification.refactoredB((Root<FakeEntity>)root, filters, model);
            if (model.getLocationList() != null) {
                filters.add(root.get("location").in((Collection)model.getLocationList()));
            }
            if (model.getHospitalId() != null) {
                filters.add(root.get("hospitalId").in(new Object[]{model.getHospitalId()}));
            }
            if (model.getHospitalGroupId() != null) {
                filters.add(root.get("hospitalGroupId").in(new Object[]{model.getHospitalGroupId()}));
            }
            if (model.getIsPreviousProblem() != null) {
                filters.add(root.get("isPreviousProblem").in(new Object[]{model.getIsPreviousProblem()}));
            }
            criteriaQuery.distinct(true);
            return criteriaBuilder.and(filters.toArray(new Predicate[0]));
        };
    }

    private static void refactoredA(Root<FakeEntity> root, List<Predicate> filters, FakeSearchModel model) {
        if (model.getPatientId() != null) {
            filters.add(root.get("patientId").in(new Object[]{model.getPatientId()}));
        }
        if (model.getDoctorId() != null) {
            filters.add(root.get("doctorId").in(new Object[]{model.getDoctorId()}));
        }
        if (model.getRecordId() != null) {
            filters.add(root.get("recordId").in(new Object[]{model.getRecordId()}));
        }
        if (model.getParentId() != null) {
            filters.add(root.get("parentId").in(new Object[]{model.getParentId()}));
        }
        if (model.getEpisodeId() != null) {
            filters.add(root.get("episodeId").in(new Object[]{model.getEpisodeId()}));
        }
        if (model.getItemId() != null) {
            filters.add(root.get("itemId").in(new Object[]{model.getItemId()}));
        }
        if (model.getClinicId() != null) {
            filters.add(root.get("clinicId").in(new Object[]{model.getClinicId()}));
        }
        if (model.getIsActive() != null) {
            filters.add(root.get("isActive").in(new Object[]{model.getIsActive()}));
        }
        if (model.getIsResolved() != null) {
            filters.add(root.get("isResolved").in(new Object[]{model.getIsResolved()}));
        }
    }

    private static void refactoredB(Root<FakeEntity> root, List<Predicate> filters, FakeSearchModel model) {
        if (model.getCreatedBy() != null) {
            filters.add(root.get("createdBy").in(new Object[]{model.getCreatedBy()}));
        }
        if (model.getModifiedBy() != null) {
            filters.add(root.get("modifiedBy").in(new Object[]{model.getModifiedBy()}));
        }
        if (model.getLoginUserId() != null) {
            filters.add(root.get("loginUserId").in(new Object[]{model.getLoginUserId()}));
        }
        if (model.getModuleList() != null) {
            filters.add(root.get("module").in((Collection)model.getModuleList()));
        }
        if (model.getParentLocationList() != null) {
            filters.add(root.get("parentLocation").in((Collection)model.getParentLocationList()));
        }
    }
}
