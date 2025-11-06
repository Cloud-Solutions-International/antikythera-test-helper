package sa.com.cloudsolutions.antikythera.testhelper.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Car extends Vehicle {
    private Integer numberOfDoors;
    private String transmission;
    private Boolean convertible;

    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(Integer numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public Boolean getConvertible() {
        return convertible;
    }

    public void setConvertible(Boolean convertible) {
        this.convertible = convertible;
    }
}
