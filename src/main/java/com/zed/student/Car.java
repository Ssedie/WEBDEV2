package com.zed.student;

public class Car {
    int id;
    String make;
    int year;
    int licensePlateNumber;
    String color;
    String bodyType;
    String engineType;
    String transmission;

    public Car(int id, String make, int year, int licensePlateNumber, String color, String bodyType, String engineType, String transmission) {
        this.id = id;
        this.make = make;
        this.year = year;
        this.licensePlateNumber = licensePlateNumber;
        this.color = color;
        this.bodyType = bodyType;
        this.engineType = engineType;
        this.transmission = transmission;
    }

    public Car(){}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getLicensePlateNumber() {
        return licensePlateNumber;
    }
    public void setLicensePlateNumber(int licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getBodyType() {
        return bodyType;
    }
    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }
    public String getEngineType() {
        return engineType;
    }
    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
    public String getTransmission() {
        return transmission;
    }
    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

}
