import java.util.Arrays;

public class single_number {
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2) {
            if (nums[i] == nums[i + 1]) {
                i = i + 2;
            } else {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    public static void main(String args[]) {
        int nums[] = { 4, 1, 2, 1, 2 };
        System.out.println(singleNumber(nums));
    }
}
