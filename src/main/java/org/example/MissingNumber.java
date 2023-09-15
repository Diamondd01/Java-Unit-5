package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Set;

public class MissingNumber {
    public static int missingNumber(int[] nums, int maxNum) {

        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (int i = 1; i <= maxNum; i += 1) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;
    }

    public static int missingNumberSort(int[] nums, int maxNum) {
        Arrays.sort(nums);

        for (int i = 1; i < maxNum; i += 1) {
            if (i != nums[i - 1]) {
                return i;
            }
        }

        if (nums.length == maxNum && nums[maxNum - 1] == maxNum) {
            return 0;
        }

        return maxNum;
    }
    public int missingSeven(int[] nums, int n) {
        int sum = (n * (n + 1)) / 2;
        int arraySum = 0;

        for (int num : nums) {
            arraySum += num;
        }

        return sum - arraySum;
    }

    public static int missingNumberSum(int[] nums, int maxNum) {
        int expectedSum = 0;
        for (int i = 1; i <= maxNum; i += 1) {
            expectedSum += i;
        }

        int actualSum = Arrays.stream(nums).sum();

        return expectedSum - actualSum;
    }


    public static void main(String[] args) {
        int[] missingMax = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] missingNone = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] missingSeven = {1, 2, 3, 4, 5, 6, 8, 9, 10};

    }
}
// It calculates the missing number using the mathematical sum formula,
// but it doesn't use any additional memory-intensive data structures.
