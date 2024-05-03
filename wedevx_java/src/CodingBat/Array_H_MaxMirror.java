package CodingBat;

import java.util.Scanner;

//We'll say that a "mirror" section in an array is a group of contiguous elements
// such that somewhere in the array, the same group appears in reverse order. For example, the largest
// mirror section in {1, 2, 3, 8, 9, 3, 2, 1} is length 3 (the {1, 2, 3} part).
// Return the size of the largest mirror section found in the given array.

public class Array_H_MaxMirror {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = {21, 22, 9, 8, 7, 6, 23, 24, 6, 7, 8, 9, 25, 7, 8, 9}; // example array
        int res = 0;
        int max = 0;
        if (nums.length == 1) {
            System.out.println(1);
        }
        for (int i = 0; i < nums.length; i++) {

            for (int j = nums.length-1; j > i; j--) {
                int b = i;
                int e = j;
                while (nums[e] == nums[b]) {
                    e--;
                    res++;
                    if (e == b) {
                        res++;
                        break;
                    }
                    b++;

                    if (e == b) {
                        res= res*2 + 1;
                        break;
                    }
                }
                if (res > 0) {
                    max = Math.max(res, max);
                    res = 0;
                    e = j;
                }
            }
        } System.out.println(max);

        }
    }

