package baekjoon.bronze2;

import java.util.Scanner;

public class P1942 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        String regex = "[,:]";
        String[] a1 = keyboard.next().split(regex);
        Digital dgt1 = new Digital(Integer.parseInt(a1[0]), Integer.parseInt(a1[1]), Integer.parseInt(a1[2]));

        String[] a2 = keyboard.next().split(regex);
        Digital dgt2 = new Digital(Integer.parseInt(a2[0]), Integer.parseInt(a2[1]), Integer.parseInt(a2[2]));

        String[] a3 = keyboard.next().split(regex);
        Digital dgt3 = new Digital(Integer.parseInt(a3[0]), Integer.parseInt(a3[1]), Integer.parseInt(a3[2]));

        String[] a4 = keyboard.next().split(regex);
        Digital dgt4 = new Digital(Integer.parseInt(a4[0]), Integer.parseInt(a4[1]), Integer.parseInt(a4[2]));

        String[] a5 = keyboard.next().split(regex);
        Digital dgt5 = new Digital(Integer.parseInt(a5[0]), Integer.parseInt(a5[1]), Integer.parseInt(a5[2]));

        String[] a6 = keyboard.next().split(regex);
        Digital dgt6 = new Digital(Integer.parseInt(a6[0]), Integer.parseInt(a6[1]), Integer.parseInt(a6[2]));


        System.out.println(dgt1.countTarBySection(dgt2));
        System.out.println(dgt3.countTarBySection(dgt4));
        System.out.println(dgt5.countTarBySection(dgt6));


        //00:59:58 01:01:24

//        Digital dgt1 = new Digital(00, 59, 58);
//        Digital dgt2 = new Digital(1, 1, 24);

        // 22:47:03 01:03:24

//        Digital dgt1 = new Digital(22, 47, 3);
//        Digital dgt2 = new Digital(1, 3, 24);

        // 00:00:09 00:03:37

//        Digital dgt1 = new Digital(0, 0, 9);
//        Digital dgt2 = new Digital(0, 3, 37);

//        System.out.println(dgt1.countTarBySection(dgt2));

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
        return (hh * 10000) + (mm * 100) + (ss);
    }

    public int[] getSeparateFormat(int whole) {
        int[] arr = new int[3];
        arr[0] = (int) (whole / 10000);
        arr[1] = (whole - (arr[0] * 10000)) / 100;
        arr[2] = whole % 100;
        return arr;
    }

    //whole number
    public boolean isDividedByThree(int whole) {
        return (whole % 3 == 0);
    }

//    public boolean isValidDigitalFormat(int hh, int mm, int ss) {
//
//    }

    public boolean isEquivalent(int hh, int mm, int ss) {
        return (this.hh == hh) && (this.mm == mm) && (this.ss == ss);
    }

    public int getDigitalIncreasedBy1(Digital dgt) {
        if (ss + 1 >= 60) {
            dgt.ss = 0;

            if (dgt.mm + 1 >= 60) {
                dgt.mm = 0;

                if (dgt.hh + 1 >= 24) {
                    dgt.hh = 0;
                } else {
                    dgt.hh++;
                }
            } else {
                dgt.mm++;
            }

        } else {
            dgt.ss++;
        }

        return dgt.hh * 10000 + dgt.mm * 100 + dgt.ss;
    }

    public int[] getSection(Digital dgt) {
        int[] res = new int[10000000];

        for (int i = 0; i < 10000000; i++) {
            res[i] = -1;
        }

        res[0] = this.getDigitalFormat(); // inclusive
        int i = 1;

        while (true) {
            if (this.isEquivalent(dgt.hh, dgt.mm, dgt.ss)) {
                break;
            }

            res[i] = this.getDigitalIncreasedBy1(this);

//            System.out.println(res[i]);
            i++;
        }

        return res;
    }

    public int countTarBySection(Digital dgt) {
        int cnt = 0;
        int[] tar = this.getSection(dgt);

        for (int i = 0; i < tar.length; i++) {
            if (this.isDividedByThree(tar[i])) {
//                System.out.println("tar: " + tar[i]);
                cnt++;
            }
        }

        return cnt;
    }
}

