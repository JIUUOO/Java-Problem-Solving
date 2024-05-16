package baekjoon.bronze3;

import java.util.Scanner;

public class P2875 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int n = keyboard.nextInt();
        int m = keyboard.nextInt();
        int k = keyboard.nextInt();

        Personnel personnel = new Personnel(n, m, k);


        System.out.println(personnel.numOfTeam());
//        System.out.println(personnel.n);
//        System.out.println(personnel.m);
    }
}

class Personnel {
    int n;
    int m;
    int k;

    public Personnel(int n, int m, int k) {
        this.n = n;
        this.m = m;
        this.k = k;
    }

    public boolean setMakeTeam() {
        int nSubtracted = n - 2;
        int mSubtracted = m - 1;

        // valid condition
        if ((nSubtracted >= 0 && mSubtracted >= 0) && nSubtracted + mSubtracted >= k) {
            n -= 2;
            m -= 1;
            return true;
        }
        return false;
    }

    public int numOfTeam() {
        int cnt = 0;
        while (this.setMakeTeam()) {
            cnt++;
        }
        return cnt;
    }
}
