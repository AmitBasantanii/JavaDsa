import java.util.Arrays;

public class remove_duplicates {
        public static int findDuplicate(int[] nums) {
            // Sort the array
            Arrays.sort(nums);

            // Check for consecutive elements that are the same
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) {
                    return nums[i];
                }
            }
            return -1;  // If no duplicate is found
        }

        public static void main(String[] args) {
            int[] myArray = {1, 3, 4, 2, 5, 3, 4};
            int duplicate = findDuplicate(myArray);
            System.out.println("Duplicate number is: " + duplicate);
        }
}
