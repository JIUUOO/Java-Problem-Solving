package baekjoon.bronze2;

import java.util.Scanner;

public class P1942 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            String[] start = keyboard.next().split(":");
            Digital startDgt = new Digital(Integer.parseInt(start[0]), Integer.parseInt(start[1]), Integer.parseInt(start[2]));

            String[] end = keyboard.next().split(":");
            Digital endDgt = new Digital(Integer.parseInt(end[0]), Integer.parseInt(end[1]), Integer.parseInt(end[2]));

            System.out.println(startDgt.countMutiplesOf3(endDgt));
        }
    }
}

class Digital {
    int hh;
    int mm;
    int ss;

    public Digital(int hh, int mm, int ss) {
        this.hh = hh;
        this.mm = mm;
        this.ss = ss;
    }

    public int getDigitalFormat() {
        return (this.hh * 10000) + (this.mm * 100) + (this.ss);
    }

    public boolean isDividedByThree(int digit) {
        return (digit % 3 == 0);
    }

    public boolean isEquivalent(int hh, int mm, int ss) {
        return (this.hh == hh) && (this.mm == mm) && (this.ss == ss);
    }

    public int getDigitalIncreasedBy1() {
        if (ss + 1 >= 60) {
            ss = 0;

            if (mm + 1 >= 60) {
                mm = 0;

                if (hh + 1 >= 24) {
                    hh = 0;
                } else {
                    hh++;
                }
            } else {
                mm++;
            }

        } else {
            ss++;
        }

        return this.getDigitalFormat();
    }

    public int countMutiplesOf3(Digital dgt) {
        int cnt = 0;

        // inclusive
        if (isDividedByThree(this.getDigitalFormat())) {
            cnt++;
        }

        while (true) {
            if (this.isEquivalent(dgt.hh, dgt.mm, dgt.ss)) {
                break;
            }

            if (isDividedByThree(this.getDigitalIncreasedBy1())) {
                cnt++;
            }
        }
        return cnt;
    }
}

