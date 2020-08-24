package com.keep.java.week4;

import java.util.HashSet;

/**
 * 模拟行走机器人
 */
public class RobotSim {
    public int robotSim(int[] commands, int[][] obstacles) {
        int ans = 0;
        //定义方向
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        HashSet<String> obsSet = new HashSet<>();//路障 用hashset记录便于查找
        for (int[] ob : obstacles) {
            obsSet.add(ob[0] + "$" + ob[1]);
        }
        int dx = 0, dy = 0, di = 0;
        for (int command : commands) {
            if (command > 0) {
                int step = command;
                while (step > 0) {
                    int dxn = dx + directions[di][0];
                    int dyn = dy + directions[di][1];
                    if (obsSet.contains(dxn + "$" + dyn)) {
                        break;
                    }
                    dx = dxn;
                    dy = dyn;
                    step--;
                    ans = Math.max(ans, dx * dx + dy * dy);
                }

            } else {
                di = (command == -1) ? (di + 1) % 4 : (di + 3) % 4;

            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] commands = new int[]{4, -1, 4, -2, 4};
        int[][] obstacles = {{2, 4}};
        System.out.println(new RobotSim().robotSim(commands, obstacles));
    }

}
