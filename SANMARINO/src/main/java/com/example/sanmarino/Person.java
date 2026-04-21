package com.example.sanmarino;

import javafx.beans.property.*;

public class Person {
    private SimpleIntegerProperty personTransactID;
    private SimpleIntegerProperty personFormID;
    private SimpleDoubleProperty personTransactAmount;
    private SimpleIntegerProperty personTransactType;

    public Person(Integer personTransactID, Integer personFormID, Double personTransactAmount, Integer personTransactType) {
        this.personTransactID = new SimpleIntegerProperty(personTransactID) ;
        this.personFormID = new SimpleIntegerProperty(personFormID);
        this.personTransactAmount = new SimpleDoubleProperty(personTransactAmount) ;
        this.personTransactType = new SimpleIntegerProperty(personTransactType);
    }

    public Integer getPersonTransactID() {
        return personTransactID.get();
    }

    public void setPersonTransactID(Integer personTransactID) {
        this.personTransactID =new SimpleIntegerProperty(personTransactID);
    }

    public Integer getPersonFormID() {
        return personFormID.get();
    }

    public void setPersonFormID(Integer personFormID) {
        this.personFormID = new SimpleIntegerProperty(personFormID);
    }

    public Double getPersonTransactAmount() {
        return personTransactAmount.get();
    }

    public void setPersonTransactAmount(Double personTransactAmount) {
        this.personTransactAmount = new SimpleDoubleProperty(personTransactAmount);
    }



    public Integer getPersonTransactType() {
        return personTransactType.get();
    }

    public void setPersonTransactType(Integer personTransactType) {
        this.personTransactType = new SimpleIntegerProperty(personTransactType);
    }
}
