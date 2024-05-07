package baekjoon.gold3;
import java.util.Scanner;

public class P1085 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int x = keyboard.nextInt();
        int y = keyboard.nextInt();
        int w = keyboard.nextInt();
        int h = keyboard.nextInt();

        int[] arr = {x, y, w-x, h-y};
        int min = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println(min);
    }
}
