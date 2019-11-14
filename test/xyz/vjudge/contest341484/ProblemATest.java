package xyz.vjudge.contest341484;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ProblemATest {

    public static void main(String[] args) {
        inputCheck();
    }
    @Test
    @Disabled
    static void inputCheck() {
        String type;
        int doctorNum, priority;
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int N = in.nextInt();
            for (int i = 0; i < N; i++) {
                type = in.next();
                System.out.println(type);
                if (type.equals("IN")) {
                    doctorNum = in.nextInt();
                    System.out.println(doctorNum);
                    priority = in.nextInt();
                    System.out.println(priority);
                } else {
                    doctorNum = in.nextInt();
                    System.out.println(doctorNum);
                }
            }
        }
    }

}