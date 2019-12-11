package xyz.vjudge.contest347221;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ProblemATest {
    @Test
    void binarySearch(){
        int[] nums = {1, 3, 5, 7, 8};
        System.out.println(ProblemA.lowerBound(nums,0,4,8));
    }
}