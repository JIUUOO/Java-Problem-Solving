import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        String regex = "[:]";
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


        System.out.println(dgt1.countMultiplesOf3InSection(dgt2));
        System.out.println(dgt3.countMultiplesOf3InSection(dgt4));
        System.out.println(dgt5.countMultiplesOf3InSection(dgt6));
    }

}

class Digital {
    private int hh;
    private int mm;
    private int ss;
    int digit;

    // Constructor
    public Digital(int hh, int mm, int ss) {
        this.hh = hh;
        this.mm = mm;
        this.ss = ss;
        this.digit = this.getDigitalFormat();
    }

    // Returns as an integer
    public int getDigitalFormat() {
        return (hh * 10000) + (mm * 100) + (ss);
    }

    // Returns true if two clocks are equivalent
    public boolean isEquivalent(int hh, int mm, int ss) {
        return (this.hh == hh) && (this.mm == mm) && (this.ss == ss);
    }

    // Pluses 1 at second then returns as digit integer value in terms of valid format
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

    // Returns section between as integer array, which means array is digit format
    public int[] getSection(Digital dgt) {
        Array res = new Array();

        res.insert(this.digit); // inclusive
        int i = 1;

        while (true) {
            if (this.isEquivalent(dgt.hh, dgt.mm, dgt.ss)) {
                break;
            }

            res.insert(this.getDigitalIncreasedBy1(this));

            i++;
        }

        return res.arr;
    }

    // Returns true if a parameter is multiply of three
    static boolean isMultipliesOfThree(int num) {
        return (num % 3 == 0);
    }

    // Returns the number of multiplies of 3 according to the section
    public int countMultiplesOf3InSection(Digital dgt) {
        int cnt = 0;
        int[] section = this.getSection(dgt);

        for (int i = 0; i < section.length; i++) {
            if (isMultipliesOfThree(section[i])) {
                cnt++;
            }
        }

        return cnt;
    }
}

class Array {
    int[] arr;
    int count;

    public Array() {
        arr = new int[0];
        count = 0;
    }

    public void insert(int el) {
        // Make a new array where size is 'count' increased by 1
        int[] newArr = new int[count + 1];

        // Copy existing elements first
        if (count > 0) { // Prevent assigning when arr is initialized
            for (int i = 0; i < count; i++) {
                newArr[i] = arr[i];
            }
        }

        // Assign new element
        newArr[count++] = el; // The last index of new Arr

        // Then newArr becomes our new array
        arr = newArr;
    }
}