public class two_sum {
    public static int[] twoSum(int[] nums, int target) {
        int i = 0;
        while (i < nums.length - 1) {
            int j = i + 1;
            while (j < nums.length) {
                if (nums[i] + nums[j] == target) {
                    int sol[] = { i, j };
                    return sol;
                } else {
                    j++;
                }
            }
            i++;
        }
        return null;
    }

    public static void main(String args[]) {
        int nums_1[] = { 2, 7, 11, 15 };
        int result_nums_1[] = twoSum(nums_1, 9);
        for (int x : result_nums_1) {
            System.out.println(x);
        }
    }
}
