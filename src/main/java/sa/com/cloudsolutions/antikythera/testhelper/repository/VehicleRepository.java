package sa.com.cloudsolutions.antikythera.testhelper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sa.com.cloudsolutions.antikythera.testhelper.model.Vehicle;
import sa.com.cloudsolutions.antikythera.testhelper.model.Car;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    
    // Simple query on subclass - should add implicit inheritance JOINs
    List<Car> findByTransmission(String transmission);
    
    // Query on subclass with parent properties
    @Query("SELECT c FROM Car c WHERE c.manufacturer = :manufacturer AND c.numberOfDoors = :doors")
    List<Car> findCarsByManufacturerAndDoors(@Param("manufacturer") String manufacturer, @Param("doors") Integer doors);
    
    // Query with TYPE() function for JOINED inheritance
    @Query("SELECT v FROM Vehicle v WHERE TYPE(v) = Car")
    List<Vehicle> findAllCars();
    
    // Query on parent class - no inheritance JOINs needed
    @Query("SELECT v FROM Vehicle v WHERE v.year > :year")
    List<Vehicle> findByYearGreaterThan(@Param("year") Integer year);
    
    // Query on subclass with multiple conditions
    @Query("SELECT c FROM Car c WHERE c.convertible = true AND c.color = :color AND c.year >= :minYear")
    List<Car> findConvertiblesByColorAndYear(@Param("color") String color, @Param("minYear") Integer minYear);
}
