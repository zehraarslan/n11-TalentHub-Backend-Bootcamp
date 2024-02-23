package com.zehraarslan;

import com.zehraarslan.entity.BaseEntity;
import com.zehraarslan.entity.House;
import com.zehraarslan.entity.SummerHouse;
import com.zehraarslan.entity.Villa;
import com.zehraarslan.service.HousingService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        House house1 = new House(1, 1, new BigDecimal("150000"), 95, 1, "Ankara");
        House house2 = new House(2, 1, new BigDecimal("180000"), 110, 2, "İstanbul");
        House house3 = new House(4, 3, new BigDecimal("240000"), 100, 8, "İzmir");

        Villa villa1 = new Villa(4, 3, new BigDecimal("300000"), 250, 0,"Bodrum");
        Villa villa2 = new Villa(6, 4, new BigDecimal("800000"), 400, 5,"Antalya");
        Villa villa3 = new Villa(4, 3, new BigDecimal("700000"), 400, 5,"İstanbul");

        SummerHouse summerHouse1 = new SummerHouse(1, 2, new BigDecimal("100000"), 150, 1,"Çeşme");
        SummerHouse summerHouse2 = new SummerHouse(3, 1, new BigDecimal("120000"), 175, 5,"Fethiye");
        SummerHouse summerHouse3 = new SummerHouse(4, 3, new BigDecimal("115555"), 105, 2,"Alsancak");

        List<BaseEntity> houses = new ArrayList<>();
        houses.add(house1);
        houses.add(house2);
        houses.add(house3);
        houses.add(villa1);
        houses.add(villa2);
        houses.add(villa3);
        houses.add(summerHouse1);
        houses.add(summerHouse2);
        houses.add(summerHouse3);

        HousingService housingService = new HousingService(houses);

        System.out.println("Total price");
        System.out.println("Total price of houses: " + housingService.getTotalPrice(House.class));
        System.out.println("Total price of villas: " + housingService.getTotalPrice(Villa.class));
        System.out.println("Total price of summer houses: " + housingService.getTotalPrice(SummerHouse.class));
        System.out.println("Total price of all houses: " + housingService.getTotalPrice(BaseEntity.class));
        System.out.println("-----------------------------------------------------------------");

        System.out.println("Average Area");
        System.out.println("Average area of houses: " + housingService.getAverageArea(House.class));
        System.out.println("Average area of villas: " + housingService.getAverageArea(Villa.class));
        System.out.println("Average area of summer houses: " + housingService.getAverageArea(SummerHouse.class));
        System.out.println("Average area of summer houses: " + housingService.getAverageArea(BaseEntity.class));
        System.out.println("-----------------------------------------------------------------");



        int roomCount = 4;
        int livingRoomCount = 3;
        List<House> filteredHouses = housingService.filterHousesByRoomAndLivingRoomCount(House.class, roomCount, livingRoomCount);
        System.out.println("Houses with " + roomCount + " rooms and " + livingRoomCount + " living rooms:");
        for (BaseEntity house : filteredHouses) {
            System.out.println(house);
        }
        System.out.println("-----------------------------------------------------------------");


        List<Villa> filteredVillas = housingService.filterHousesByRoomAndLivingRoomCount(Villa.class, roomCount, livingRoomCount);
        System.out.println("Villas with " + roomCount + " rooms and " + livingRoomCount + " living rooms:");
        for (BaseEntity house : filteredVillas) {
            System.out.println(house);
        }
        System.out.println("-----------------------------------------------------------------");


        List<SummerHouse> filteredSummerHouses = housingService.filterHousesByRoomAndLivingRoomCount(SummerHouse.class, roomCount, livingRoomCount);
        System.out.println("Summer Houses with " + roomCount + " rooms and " + livingRoomCount + " living rooms:");
        for (BaseEntity house : filteredSummerHouses) {
            System.out.println(house);
        }
        System.out.println("-----------------------------------------------------------------");


        List<BaseEntity> filteredAllHousing = housingService.filterHousesByRoomAndLivingRoomCount(BaseEntity.class, roomCount, livingRoomCount);

        System.out.println("All Houses with " + roomCount + " rooms and " + livingRoomCount + " living rooms:");
        for (BaseEntity house : filteredAllHousing) {
            System.out.println(house);
        }
        System.out.println("-----------------------------------------------------------------");

    }
}