package GoogleQuestions;

import java.util.HashMap;

public class LoggerRateLimiter {

    HashMap<String, Integer> messageMap;

    LoggerRateLimiter() {
        this.messageMap = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(timestamp == 0 || message.length() == 0) {
            return false;
        }
        if(!messageMap.containsKey(message) || timestamp - messageMap.get(message) >= 10){
            messageMap.put(message,timestamp);
            return true;
        }
        return false;

        /*if (messageMap.containsKey(message)) {
            int waitTime = messageMap.get(message);
            if(timestamp - waitTime >= 10) {
                messageMap.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        } else {
            messageMap.put(message, timestamp);
            return true;
        }
        */

    }

    public static void main(String[] args) {
        LoggerRateLimiter l = new LoggerRateLimiter();
        String message1 = "Hello";
        String message2 = "World";
        String message3 = "Hello";

        // Example timestamps
        int timestamp1 = 1;
        int timestamp2 = 5;
        int timestamp3 = 12;

        // Check if messages should be printed
        System.out.println(l.shouldPrintMessage(timestamp1, message1)); // true
        System.out.println(l.shouldPrintMessage(timestamp2, message2)); // true
        System.out.println(l.shouldPrintMessage(timestamp3, message3)); // false

    }
}
