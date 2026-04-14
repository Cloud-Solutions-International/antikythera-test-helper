/*
 * Decompiled with CFR 0.152.
 */
package sa.com.cloudsolutions.antikythera.testhelper.evaluator;

import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import java.io.Serializable;
import java.util.Objects;
import org.springframework.data.jpa.domain.Specification;
import sa.com.cloudsolutions.antikythera.testhelper.model.FakeEntity;

public final class AppointmentSpecification {
    private static final String FIELD_ADMISSION_ID = "admissionId";
    private static final String FIELD_HOSPITAL_ID = "hospitalId";
    private static final String FIELD_GROUP_ID = "groupId";
    private static final String FIELD_IS_ACTIVE = "isActive";

    private AppointmentSpecification() {
        throw new IllegalStateException("Utility class");
    }

    public static Specification<FakeEntity> findByAdmissionId(Long admissionId, Long hospitalId, Long groupId, Boolean active) {
        Objects.requireNonNull(admissionId, "admissionId must not be null");
        Objects.requireNonNull(hospitalId, "hospitalId must not be null");
        Objects.requireNonNull(groupId, "groupId must not be null");
        return (Specification & Serializable)(root, query, cb) -> {
            if (active != null) {
                return cb.and(new Predicate[]{cb.equal((Expression)root.get(FIELD_ADMISSION_ID), (Object)admissionId), cb.equal((Expression)root.get(FIELD_HOSPITAL_ID), (Object)hospitalId), cb.equal((Expression)root.get(FIELD_GROUP_ID), (Object)groupId), cb.equal((Expression)root.get(FIELD_IS_ACTIVE), (Object)active)});
            }
            return cb.and(new Predicate[]{cb.equal((Expression)root.get(FIELD_ADMISSION_ID), (Object)admissionId), cb.equal((Expression)root.get(FIELD_HOSPITAL_ID), (Object)hospitalId), cb.equal((Expression)root.get(FIELD_GROUP_ID), (Object)groupId)});
        };
    }
}
