package sa.com.cloudsolutions.antikythera.testhelper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sa.com.cloudsolutions.antikythera.testhelper.model.FakeEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface FakeRepository extends JpaRepository<FakeEntity, Integer>, JpaSpecificationExecutor<FakeEntity> {
    List<FakeEntity> findAllByName(String name);
    Optional<Integer> findByListAndSet(List<Integer> a, Set<Integer> b);

    @Modifying
    @Query("update FakeEntity f set f.name = '' where f.id = :id")
    void deleteByNothing(@Param("id") long id);

    Integer countItems(Integer a, Integer b);
}
