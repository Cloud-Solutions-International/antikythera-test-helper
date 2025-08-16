package sa.com.cloudsolutions.antikythera.testhelper.evaluator;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class FakeSpecification implements Specification<FakeEntity> {
    @Override
    @SuppressWarnings("unused")
    public Predicate toPredicate(Root<FakeEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
