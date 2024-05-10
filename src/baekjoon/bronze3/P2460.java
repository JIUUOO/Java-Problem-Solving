package baekjoon.bronze3;

import java.util.Scanner;

public class P2460 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        Train2 train = new Train2();

        for (int i = 0; i < 10; i++) {
            train.getOut(keyboard.nextInt());
            train.getOn(keyboard.nextInt());
        }

        System.out.println(train.getMaxNum());
    }
}

class Train2 {
    private int num;
    private int maxNum;

    public Train2() {
        num = 0;
        maxNum = -1; // initialize to -1 to initialize for once
    }

    public void getOn(int num) {
        this.num += num;
        this.calcMaxNum();
    }

    public void getOut(int num) {
        this.num -= num;
        this.calcMaxNum();
    }

    public void calcMaxNum() {
        if (maxNum > -1 && num > maxNum) {
            maxNum = num;
        } else if (maxNum == -1) {
            maxNum = num;
        }
    }

    public int getMaxNum() {
        return this.maxNum;
    }
}