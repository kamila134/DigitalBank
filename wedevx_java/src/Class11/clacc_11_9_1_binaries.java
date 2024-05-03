package Class11;
import java.util.Map;
import java.util.TreeMap;

public class clacc_11_9_1_binaries {
    public static void main(String[] args) {
        String input = "1100";
        Map<Integer,Boolean> resultMap = new TreeMap<>();
        boolean isOne = false;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '0') {
                if (isOne) {
                    resultMap.clear();
                }
                isOne = false;
                resultMap.put(i,isOne);
            } else {
                if (!isOne) {
                    resultMap.clear();
                }
                isOne = true;
                resultMap.put(i,isOne);
            }
        } System.out.println(resultMap);
    }
}
