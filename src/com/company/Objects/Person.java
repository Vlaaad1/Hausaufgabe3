package com.company.Objects;

import java.util.Objects;

/**
 * Date: 29.10.2021
 */
public class Person {
    private String firstName;
    private String lastName;

    /**
     * Konstruktor der Klasse
     * @param firstName Vorname des Persons
     * @param lastName Vorname des Persons
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    /**
     * @return String mit Vorname und Nachname des Persons
     */
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    /**
     *
     * @param o Objekt das verglichen werden soll
     * @return boolean Wert durch Vergleich der Namen zweier Persons
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}