package baekjoon.bronze1;

import java.util.Scanner;

public class P1292 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        Sequence sequence = new Sequence(keyboard.nextInt(), keyboard.nextInt());

        System.out.println(sequence.calcRes());
    }
}

class Sequence {
    int a;
    int b;
    int[] arr;

    public Sequence(int a, int b) {
        this.a = a;
        this.b = b;
        this.setSequence();
    }

    private void setSequence() {
        int[] arr = new int[b];
        int index = 0;

        for (int el = 0; ; el++) {
            for (int j = 0; j < el + 1; j++) {
//                System.out.println(el + 1);
                if (index + 1 > b) {
                    this.arr = arr;
                    return;
                }
                arr[index++] = el + 1;
            }
        }
    }

    public void printSequence() {
        for (int i = 0; i < this.arr.length; i++) {
            System.out.println(this.arr[i]);
        }
    }

    // Get sum by given section
    public int calcRes() {
        int sum = 0;
        for (int i = this.a - 1; i < this.b; i++) {
            sum += arr[i];
        }

        return sum;
    }

}
