package GoogleQuestions;

public class DecodeXOR {
    public int[] decodeXOR(int[] encoded, int first) {
        int[] decoded = new int[encoded.length + 1];
        decoded[0] = first;//1
        for (int i = 0; i < encoded.length; i++) {
            decoded[i+1] = encoded[i] ^ decoded[i]; //1^1=0, 0^2=2, 3^2=1
        }
        return decoded; //[1,0,2,1]
    }
    public static void main(String[] args) {
        DecodeXOR d = new DecodeXOR();
        int[] encode = {1,2,3};
        int first = 1;
        int[] xor = d.decodeXOR(encode, first);
        for(int i :  xor) {
            System.out.println(i);
        }
    }
}
