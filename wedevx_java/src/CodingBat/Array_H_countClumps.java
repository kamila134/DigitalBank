package CodingBat;

public class Array_H_countClumps {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 4, 4};
        int sum = 0;

        for (int i = 0; i < nums.length-1; i++) {
            int j = i;
            int a = 0;

            while (nums[j] == nums[j+1]) {
                a = 1;
                if (j == nums.length-2) {
                    break;
                }
                j++;
            }
            i = j;
            sum+=a;
        } System.out.println(sum);
    }
}
