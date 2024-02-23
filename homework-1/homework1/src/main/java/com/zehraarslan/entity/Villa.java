package com.zehraarslan.entity;

import java.math.BigDecimal;

public class Villa extends BaseEntity{
    public Villa(int roomCount, int livingRoomCount, BigDecimal price, int area, int age, String location) {
        super(roomCount, livingRoomCount, price, area, age, location);
    }
}
