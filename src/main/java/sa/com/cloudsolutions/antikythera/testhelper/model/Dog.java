package sa.com.cloudsolutions.antikythera.testhelper.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("DOG")
public class Dog extends Animal {
    private String breed;
    private Boolean trained;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Boolean getTrained() {
        return trained;
    }

    public void setTrained(Boolean trained) {
        this.trained = trained;
    }
}
