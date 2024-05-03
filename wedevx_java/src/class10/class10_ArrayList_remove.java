package class10;
import java.util.ArrayList;
public class class10_ArrayList_remove {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(0);
        nums.add(8);
        nums.add(-7);
        nums.add(-10);
        nums.add(-10);
        nums.add(-20);
        nums.add(0);
        System.out.println(removeNegativeNumbers(nums));

    //10 0 8 -7 -10 10 -20 0
    }
    public static ArrayList<Integer> removeNegativeNumbers (ArrayList<Integer> nums) {
        int g = 0;
        for (int i = 0; i < nums.size(); i++) {
            System.out.println(i);
            if (nums.get(g) < 0) {

                nums.remove(g);

            } g = i;
            System.out.println("final g " + g + " final i = "  + i);

        } return nums;
    }
}
