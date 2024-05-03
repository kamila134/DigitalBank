package Class11;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Arrays;

public class class_11_4_Map_Phonebook {
    public static void main(String[] args) {
        String names = "Alice Bob Charlie";
        String phoneNumbers = "1234567890 9876543210 5555555555 996221221 987654323456";
        String[] arrNames = names.split(" ");
        String[] arrPhones = phoneNumbers.split(" ");
        List<String> listNames = new ArrayList<>(Arrays.asList(arrNames));
        List<String> listPhones = new ArrayList<>(Arrays.asList(arrPhones));
        //removing duplicates from both Strings:
        Set<String> setNames = new LinkedHashSet<>(listNames);
        Set<String> setPhones = new LinkedHashSet<>(listPhones);
        Map<String,String> finalMap = new LinkedHashMap<>();

        boolean isTrue = true;
        int sizeSetNames = setNames.size();
        for (String name: setNames) {
            if (setPhones.isEmpty()) {
                isTrue = false;
                finalMap.put(name,"-1");
            }
            else if (isTrue) {

                for (String phone: setPhones) {
                    if (sizeSetNames > 1) {
                        finalMap.put(name,phone);
                        setPhones.remove(phone);
                        System.out.println(name + " " + phone + " size: " + sizeSetNames);
                        break;
                        }
                        int num = 1;
                        String unk = "unknown" + num;
                        num++;
                        finalMap.put(unk,phone);


                } sizeSetNames--;
                continue;
            }
        } System.out.println(finalMap);
    }
}
