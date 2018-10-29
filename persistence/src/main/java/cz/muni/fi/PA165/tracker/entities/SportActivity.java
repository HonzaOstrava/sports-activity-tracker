package cz.muni.fi.PA165.tracker.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * This class represents a sports activity.
 * @author Dominik-Bujna
 */

@Entity
@Table(name = "SportActivity")
public class SportActivity {


    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @NotNull
    @Column(length = 30, nullable = false)
    private String activityName;

    @NotNull
    private double burnedCaloriesPerHour;

    @NotNull
    private double weightCoefficient;




    @NotNull
    public String getActivityName() {
        return activityName;
    }


    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    @NotNull
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBurnedCaloriesPerHour() {
        return burnedCaloriesPerHour;
    }

    public void setBurnedCaloriesPerHour(double burnedCaloriesPerHour) {
        this.burnedCaloriesPerHour = burnedCaloriesPerHour;
    }

    public double getWeightCoefficient() {
        return weightCoefficient;
    }

    public void setWeightCoefficient(double coefficient) {
        this.weightCoefficient = coefficient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SportActivity toCompare = (SportActivity) o;
        return this.activityName == toCompare.getActivityName();
    }

    //TODO: possible changes
    @Override
    public int hashCode() {
        return Objects.hash(this.activityName);
    }



}
