package sa.com.cloudsolutions.antikythera.testhelper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sa.com.cloudsolutions.antikythera.testhelper.model.Animal;
import sa.com.cloudsolutions.antikythera.testhelper.model.Dog;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    
    // Simple query on subclass - should add implicit discriminator filtering
    List<Dog> findByBreed(String breed);
    
    // Query with TYPE() function - equality
    @Query("SELECT a FROM Animal a WHERE TYPE(a) = Dog")
    List<Animal> findAllDogs();
    
    // Query with TYPE() function - IN operator
    @Query("SELECT a FROM Animal a WHERE TYPE(a) IN (Dog, Cat)")
    List<Animal> findAllDogsAndCats();
    
    // Query with TYPE() function and other conditions
    @Query("SELECT a FROM Animal a WHERE TYPE(a) = Dog AND a.age > :age")
    List<Animal> findOldDogs(@Param("age") Integer age);
    
    // Query with TYPE() function - inequality
    @Query("SELECT a FROM Animal a WHERE TYPE(a) != Cat")
    List<Animal> findNonCats();
    
    // Query on specific subclass with conditions
    @Query("SELECT d FROM Dog d WHERE d.trained = true AND d.age < :maxAge")
    List<Dog> findYoungTrainedDogs(@Param("maxAge") Integer maxAge);
    
    // Query on subclass with property from parent
    @Query("SELECT d FROM Dog d WHERE d.name LIKE :pattern AND d.breed = :breed")
    List<Dog> findDogsByNameAndBreed(@Param("pattern") String pattern, @Param("breed") String breed);
    
    // Query on parent class - should not add discriminator filtering
    @Query("SELECT a FROM Animal a WHERE a.color = :color")
    List<Animal> findByColor(@Param("color") String color);
    
    // Complex query with multiple TYPE() conditions
    @Query("SELECT a FROM Animal a WHERE (TYPE(a) = Dog AND a.age > 5) OR (TYPE(a) = Cat AND a.age < 3)")
    List<Animal> findOldDogsOrYoungCats();

}
