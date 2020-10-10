package com.keep.java.week9;

import java.util.*;

public class Racecar {
    class CarInfo {
        int pos;
        int speed;

        public CarInfo(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }
    }


    public int racecar(int target) {
        Set<String> visited = new HashSet<>();
        String v = 0 + "/" + 1;
        visited.add(v);
        Queue<CarInfo> queue = new LinkedList<>();
        queue.add(new CarInfo(0, 1));
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                CarInfo carInfo = queue.poll();
                if (carInfo.pos == target) return level;
                String s1 = carInfo.pos + carInfo.speed + "/" + (carInfo.speed * 2);
                String s2 = carInfo.pos + "/" + (carInfo.speed > 0 ? -1 : 1);
                if (Math.abs(carInfo.pos + carInfo.speed - target) < target && !visited.contains(s1)) {
                    visited.add(s1);
                    queue.add(new CarInfo(carInfo.pos + carInfo.speed, carInfo.speed * 2));
                }
                if (Math.abs(carInfo.pos - target) < target && !visited.contains(s2)) {
                    visited.add(s2);
                    queue.add(new CarInfo(carInfo.pos, carInfo.speed > 0 ? -1 : 1));
                }
            }
            level++;

        }

        return -1;
    }


    public static void main(String[] args) {
        System.out.println(new Racecar().racecar(3));
    }
}
