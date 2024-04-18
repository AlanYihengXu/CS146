package Labs.Lab1;

import java.util.Arrays;

public class Lab1 {
    public static int[] findIndices(int[] nums, int target) {
        int[] output = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j] == target) {
                    output[0] = i;
                    output[1] = j;
                    return output;
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 8, 13};
        int target = 11;
        System.out.println(Arrays.toString(findIndices(nums, target)));
    }
}
