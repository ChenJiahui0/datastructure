package com.cjh.leetcode;

import java.util.ArrayList;
import java.util.List;

// 观察者接口
interface HouseObserver {
    void notify(House house);
}

// 房源类
class House {
    private int rooms;
    private int halls;
    private double rent;

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getHalls() {
        return halls;
    }

    public void setHalls(int halls) {
        this.halls = halls;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    @Override
    public String toString() {
        return "House [rooms=" + rooms + ", halls=" + halls + ", rent=" + rent + "]";
    }
}

// 租房策略接口
interface RentingStrategy {
    boolean isAcceptable(House house);
}

// 租房者类，实现观察者接口
class Renter implements HouseObserver {
    private String name;
    private RentingStrategy strategy;

    public Renter(String name, RentingStrategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    @Override
    public void notify(House house) {
        if (strategy.isAcceptable(house)) {
            System.out.println(name + " 被通知了房源: " + house);
        }
    }
}

// 中介类，维护房源列表和观察者列表
class Agent {
    private List<House> houses = new ArrayList<>();
    private List<HouseObserver> observers = new ArrayList<>();

    // 添加房源的方法
    public void addHouse(House house) {
        houses.add(house);
        notifyObservers(house);
    }

    // 注册观察者（租房者）的方法
    public void registerObserver(HouseObserver observer) {
        observers.add(observer);
    }

    // 通知所有观察者的方法
    private void notifyObservers(House house) {
        for (HouseObserver observer : observers) {
            observer.notify(house);
        }
    }
}

public class HouseHunting {
    public static void main(String[] args) {
        Agent agent = new Agent();

        // 创建租房者实例并注册到中介
        Renter ming = new Renter("小明", house -> house.getRooms() == 3 && house.getHalls() == 2 && house.getRent() <= 6000);
        Renter li = new Renter("小李", house -> house.getRent() <= 1500);
        agent.registerObserver(ming);
        agent.registerObserver(li);

        // 添加房源
        House house1 = new House();
        House house2 = new House();
        agent.addHouse(house1);
        agent.addHouse(house2);
    }
}
