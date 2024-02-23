package com.zehraarslan.entity;

import java.math.BigDecimal;

public abstract class BaseEntity {
    protected int roomCount;

    protected int livingRoomCount;
    protected BigDecimal price;
    protected int area;
    protected int age;
    protected String location;

    public BaseEntity(int roomCount, int livingRoomCount, BigDecimal price, int area, int age, String location) {
        this.roomCount = roomCount;
        this.livingRoomCount = livingRoomCount;
        this.price = price;
        this.area = area;
        this.age = age;
        this.location = location;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public int getLivingRoomCount() {
        return livingRoomCount;
    }

    public void setLivingRoomCount(int livingRoomCount) {
        this.livingRoomCount = livingRoomCount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "{ roomCount=" + roomCount +
                ", livingRoomCount=" + livingRoomCount +
                ", price=" + price +
                ", area=" + area +
                ", age=" + age +
                ", location='" + location +
                " }";
    }
}
