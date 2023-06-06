package Matrix.src;

public class MaximumWealth {
    public int maximumWealth(int[][] acc) {
        // if all 0 ele are return 0
        if(acc == null || acc.length == 0) {
            return -1;
        }
        int maxSum = 0;
        for(int[] i : acc) { // i:[1,2,3] // i:[3,2,1]
            int sum = 0;
            for (int j : i) { // 1 iter j [1,2,3] // 2nd iter j[3,2,1]
                sum = sum + j; //sum=6 //sum=6
            }
            maxSum = Math.max(sum, maxSum); // maxSum=6// maxSum=6
        }
        return maxSum; //6
    }

    public static void main(String[] args) {
        MaximumWealth m = new MaximumWealth();
        int[][] accounts = {{1,2,3},{3,2,1}}; // {{1,5}, {7,3},{3,5}}
//        m.maximumWealth(accounts);
        System.out.println(m.maximumWealth(accounts));
    }
}

//TC O(M*N) = for each customer M, need to iterate all over N banks
//SC O(1)