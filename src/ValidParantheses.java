import java.util.Queue;
import java.util.Stack;

public class ValidParantheses {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) {
            return false;
        }
        //stack -> (,),[,],{,}
        //}
        //{
        //]
        //[
        //)
        //(
        // traverse stack -> }{][)(
        //take stack and store all chars
        //pop top char, then pop the next char, now compare if its the chars are open and close '{' == '}' matching
        // and at the end check if stack is empty then its true
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c== '[' || c == '{') {
                stack.push(c); // stack -> '(' = peek // '[' = peek // '{' = peek
            }
            else if( c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop(); // stack -> pop '(' //
            }else if( c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop(); // stack -> pop '[' //
            }else if( c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop(); // stack -> pop '}'
            }
            else return false;
        }
        if(stack.isEmpty()) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        ValidParantheses v = new ValidParantheses();
        String s = "()[]{}"; // "()" "{]"
        System.out.println(v.isValid(s));
    }
}
// TC O(n)
// SC