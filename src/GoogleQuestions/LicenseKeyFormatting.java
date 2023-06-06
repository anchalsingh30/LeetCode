package GoogleQuestions;

import java.util.List;

public class LicenseKeyFormatting {
    public String licenseKeyFormat(String s, int k) {
        // It is used for dynamic string manipulation, such as building strings from many smaller strings
        // or appending new characters to an existing string.
        if(s == null || s.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String s1 = s.toUpperCase();//8
        int count = 0;

        for(int i = s1.length()-1; i >= 0; i--) {
            char c = s1.charAt(i); //J,-,3,-,G,5,-,2
            if (c != '-') {
                if (count == k) {
                    sb.append("-");
                    count = 0;//count reset to 0,0
                    sb.append(c); //-G-2
                } else {
                    sb.append(c); //sb= J3-G5-2
                }
                count++; //1,2,1,2,1
            }
        }
        return sb.reverse().toString(); // 2-5G-3J
    }
    public static void main(String[] args) {
        LicenseKeyFormatting l = new LicenseKeyFormatting();
        String s = "2-5g-3-J"; // "5F3Z-2e-9-w"
        int k = 2;
        System.out.println(l.licenseKeyFormat(s, k));

    }
}
