package com.zehraarslan.entity;

import java.math.BigDecimal;

public class House extends BaseEntity {
    public House(int roomCount, int livingRoomCount, BigDecimal price, int area, int age, String location) {
        super(roomCount, livingRoomCount, price, area, age, location);
    }
}
