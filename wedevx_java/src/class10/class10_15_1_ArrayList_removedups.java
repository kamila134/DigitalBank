package class10;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class class10_15_1_ArrayList_removedups {
    public static void main(String[] args) {
        int[] arr = {15, 25, 12, 45, 18, 30, 15, 18, 15, 25, 15, 12, 45, 45, 15, 30, 25, 18, 15, 18, 25, 15, 45, 45, 45, 15, 25, 25, 30, 30, 18, 18, 18, 45, 25, 25, 30, 50, 55, 60, 65, 70};
        ArrayList<Integer> res = new ArrayList<>();
        for (int n : arr) {
            res.add(n);
        } System.out.println(removeDuplicates(res));
    }


    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            boolean dup = false;
            for (int j = i+1; j < nums.size() - 1; j++) {
                if (nums.get(i) == nums.get(j)) {
                    System.out.println("== num: " + nums.get(i));
                    nums.remove(j);
                    dup = true;
                }
            } if (dup) {

                int d = nums.get(i);
                System.out.println("** d: " + d);
                nums.remove(i);
                nums.remove(Integer.valueOf(d));
                i = 0;
            }
        } return nums;
    }
}
