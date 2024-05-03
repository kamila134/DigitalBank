package Class11;

import java.util.Arrays;

public class mentorship_session {
    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        int index = 0;


        for (int i = 1; i < nums.length; i++) {
            if (nums[index] + nums[i] == target) {
                int[] result = {index,i};
                String str = Arrays.toString(result);
                System.out.println(str);
            } else {
                index++;
            }
    }
    }

}
