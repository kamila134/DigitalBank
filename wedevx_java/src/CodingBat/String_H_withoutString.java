package CodingBat;

public class String_H_withoutString {
    public static void main(String[] args) {
        String_H_withoutString object = new String_H_withoutString();
        String result = object.withoutString("MkjtMkx", "Mk");
        System.out.println(result);
    }

    public String withoutString(String base, String remove) {
        String lower = remove.toLowerCase();
        String upper = remove.toUpperCase();
        StringBuilder sb = new StringBuilder(base);
        int l = remove.length();

        while (sb.indexOf(upper) >=0 || sb.indexOf(lower) >= 0 || sb.indexOf(remove) >= 0){
            if (sb.indexOf(upper) >=0) {
                sb.delete(sb.indexOf(upper), sb.indexOf(upper)+l);
            } else if (sb.indexOf(lower) >= 0) {
                sb.delete(sb.indexOf(lower), sb.indexOf(lower)+l);
            } else {
                sb.delete(sb.indexOf(remove), sb.indexOf(remove)+l);
            }
        }
        return sb.toString();
    }
}
