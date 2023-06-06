package GoogleQuestions;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmails {
    public int numUniqueEmails(String[] emails) {
        if(emails.length == 0) return 0;

        Set<String> set = new HashSet<>();

        for(String email : emails) {
            //split a string based on @
            int atIndex = email.indexOf("@"); //15,21,15
            int plusIndex = email.indexOf("+"); //10,11,9

            String str1 = "";
            if(plusIndex >= 0) {
                str1 = email.substring(0, plusIndex); // test.email, test.e.mail, testemail
            } else {
                 str1 = email.substring(0, atIndex); // test.email // a,b,c
            }
            str1 = str1.replace(".", "") + email.substring(atIndex); //testemail@leetcode.com,testemail@leetcode.com,testemail@leetcode.com,testemail@lee.tcode.com// leetcode.com
            if(!set.contains(str1)) {
                set.add(str1); //testemail@leetcode.com,testemail@lee.tcode.com
            }// a@leetcode.com,b@leetcode.com, c@leetcode.com
        }
        return set.size(); //2 // 3
    }
    public static void main(String[] args) {
        UniqueEmails u = new UniqueEmails();
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}; // a@leetcode.com","b@leetcode.com","c@leetcode.com"
        System.out.println(u.numUniqueEmails(emails));//2
    }
}
