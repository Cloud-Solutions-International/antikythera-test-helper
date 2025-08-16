package sa.com.cloudsolutions.antikythera.testhelper.evaluator;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;


public class CrazySpecification<T> {
    @SuppressWarnings("unused")
    public Specification<T> searchOrderDetails(FakeSearchModel orderSearchModel) {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return null;
            }
        };
    }
}
