/*
 * Decompiled with CFR 0.152.
 */
package sa.com.cloudsolutions.antikythera.testhelper.evaluator;

import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import sa.com.cloudsolutions.antikythera.testhelper.evaluator.VisitType;
import sa.com.cloudsolutions.antikythera.testhelper.model.FakeEntity;

public class ReferralSpecification {
    private ReferralSpecification() {
        throw new IllegalStateException("Utility class");
    }

    public static Specification<FakeEntity> findByFilters(List<Long> patientIds, Long recordId, Long templateId, Long hospitalId, Long groupId) {
        return (Specification & Serializable)(root, criteriaQuery, criteriaBuilder) -> {
            ArrayList<Predicate> filters = new ArrayList<Predicate>();
            if (patientIds != null && !patientIds.isEmpty()) {
                filters.add(root.get("patientId").in((Collection)patientIds));
            }
            if (recordId != null) {
                filters.add(criteriaBuilder.equal((Expression)root.get("recordId"), (Object)recordId));
            }
            if (templateId != null) {
                filters.add(criteriaBuilder.equal((Expression)root.get("templateId"), (Object)templateId));
            }
            if (hospitalId != null && hospitalId != 0L) {
                filters.add(criteriaBuilder.equal((Expression)root.get("hospitalId"), (Object)hospitalId));
            }
            if (groupId != null) {
                filters.add(criteriaBuilder.equal((Expression)root.get("groupId"), (Object)groupId));
            }
            criteriaQuery.distinct(true);
            return criteriaBuilder.and(filters.toArray(new Predicate[0]));
        };
    }

    public static Specification<FakeEntity> findByEncounter(Long admissionId, Long recordId, VisitType visitType, Long hospitalId, Long groupId) {
        return (Specification & Serializable)(root, criteriaQuery, criteriaBuilder) -> {
            ArrayList<Predicate> filters = new ArrayList<Predicate>();
            if (recordId != null) {
                filters.add(criteriaBuilder.equal((Expression)root.get("recordId"), (Object)recordId));
            }
            if (visitType != VisitType.OUT_PATIENT && admissionId != null) {
                filters.add(criteriaBuilder.equal((Expression)root.get("admissionId"), (Object)admissionId));
            }
            if (hospitalId != null && hospitalId != 0L) {
                filters.add(criteriaBuilder.equal((Expression)root.get("hospitalId"), (Object)hospitalId));
            }
            if (groupId != null) {
                filters.add(criteriaBuilder.equal((Expression)root.get("groupId"), (Object)groupId));
            }
            criteriaQuery.distinct(true);
            return criteriaBuilder.and(filters.toArray(new Predicate[0]));
        };
    }
}
