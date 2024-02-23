package com.zehraarslan.service;

import com.zehraarslan.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HousingService {
    private List<BaseEntity> houses;

    public HousingService(List<BaseEntity> houses) {
        this.houses = houses;
    }

    public <T extends BaseEntity>  BigDecimal getTotalPrice(Class<T> houseType) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (BaseEntity house : houses) {
            if (houseType.isInstance(house)) {
                totalPrice = totalPrice.add(house.getPrice());
            }
        }
        return totalPrice;
    }

    public <T extends BaseEntity>  double getAverageArea(Class<T> houseType) {
        int totalArea = 0;
        int houseCount = 0;
        for (BaseEntity house : houses) {
            if (houseType.isInstance(house)) {
                totalArea += house.getArea();
                houseCount++;
            }
        }
        return  houseCount > 0 ? (double) totalArea / houseCount : 0;
    }

    public <T extends BaseEntity> List<T>  filterHousesByRoomAndLivingRoomCount(Class<T> houseType, int roomCount, int livingRoomCount) {
        List<T> filteredHouses = new ArrayList<>();

        if (houseType == null || houses == null) {
            return filteredHouses;
        }

        for (BaseEntity house : houses) {
            if (houseType.isInstance(house)) {
                if ( house.getRoomCount() == roomCount && house.getLivingRoomCount() == livingRoomCount) {
                    filteredHouses.add((T) house);
                }
            }
        }
        return filteredHouses;
    }
}
