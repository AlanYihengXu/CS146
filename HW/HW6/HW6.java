package HW.HW6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HW6 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new LinkedList<List<Integer>>();
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i+1; j < nums.length; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) {
                    continue; 
                }
                if (nums[i] + nums[j] + nums[nums.length-1] < 0) {
                    continue;
                }
                int lower = j+1;
                int higher = nums.length-1;
                while (lower <= higher) {
                    int middle = (lower + higher) / 2;
                    if (nums[i] + nums[j] + nums[middle] == 0) {
                        List<Integer> triplet = new LinkedList<Integer>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[middle]);
                        output.add(triplet);
                        break;
                    }
                    if (nums[i] + nums[j] + nums[middle] < 0) {
                        lower = middle+1;    
                    } else {
                        higher = middle-1;
                    }
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        HW6 tester = new HW6();
        int[] test1 = {0, 1, 1};
        System.out.println(tester.threeSum(test1));
        int[] test2 = {-5, 0, 5, 10, -10, 0};
        System.out.println(tester.threeSum(test2));
        int[] test3 = {5, -3, -2, 0, 3};
        System.out.println(tester.threeSum(test3));
    }
}
