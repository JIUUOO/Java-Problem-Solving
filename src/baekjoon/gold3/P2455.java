package baekjoon.gold3;

import java.util.Scanner;

public class P2455 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        Train train = new Train();

        for (int i = 0; i < 4; i++) {
            train.getOut(keyboard.nextInt());
            train.getOn(keyboard.nextInt());
        }

        System.out.println(train.getMaxNum());
    }
}

class Train {
    private int num;
    private int maxNum;

    public Train() {
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