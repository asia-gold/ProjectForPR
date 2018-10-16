package com.asia.projectForPR.ProjectForPR.Dog;

/*Properties of a dog:
        name - 1-100 symbols.
        date of birth - must be before NOW, optional
        height, weight - must be greater than 0*/

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Dog {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Date dateOfBirth;
    private int height;
    private double weight;

    public Dog() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        //TODO: 1-100 symbols
        if (name.length() < 1) {
            throw new IllegalArgumentException("Name length should be at least 1.");
        }
        if (name.length() > 100) {
            throw new IllegalArgumentException("Name length should be less then 100.");
        }
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        //TODO: should be before now and optional
        this.dateOfBirth = dateOfBirth;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height should be greater then 0.");
        }
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight should be greater then 0.");
        }
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Dog dog = (Dog) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(this.name, dog.name)
                .append(this.dateOfBirth, dog.dateOfBirth)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(name)
                .append(dateOfBirth)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("name", name)
                .append("date of birth", dateOfBirth)
                .append("height", height)
                .append("weight", weight)
                .toString();
    }
}

