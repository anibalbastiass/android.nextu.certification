package com.nextu.anibalbastias.app.entity;

import com.nextu.anibalbastias.app.util.StringUtils;

/**
 *
 * @author anibalbastias
 */
public class PersonEntity {
    String id;
    String firstName;
    String lastName;

    public PersonEntity(String firstName, String lastName) {
        this.id = StringUtils.getRandomString();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person: " + 
                "id = " + id + 
                ", firstName = " + firstName + 
                ", lastName = " + lastName + '\n';
    }
}
