import java.util.Arrays;

public class pairs_sum {
    public static void main(String... args) {
        pairs_sum main = new pairs_sum();
        int[] intArray = {2, 7, 13, 15};
        int[] result = main.twoSum(intArray, 20);
        System.out.println(Arrays.toString(result));
    }

    // Two Sum method
    public int[] twoSum (int[] nums, int target) {
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No solution found !! ");
    }
}
