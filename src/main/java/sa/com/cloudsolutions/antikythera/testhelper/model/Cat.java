package sa.com.cloudsolutions.antikythera.testhelper.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("CAT")
public class Cat extends Animal {
    private Boolean indoor;
    private Integer livesRemaining;

    public Boolean getIndoor() {
        return indoor;
    }

    public void setIndoor(Boolean indoor) {
        this.indoor = indoor;
    }

    public Integer getLivesRemaining() {
        return livesRemaining;
    }

    public void setLivesRemaining(Integer livesRemaining) {
        this.livesRemaining = livesRemaining;
    }
}
