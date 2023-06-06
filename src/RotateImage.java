public class RotateImage {
    public void rotate(int[][] matrix) {

        int n = matrix.length;
        // start 4 ways swapping
        for(int i = 0; i < (n+1)/2; i++) {
            for(int j = 0; j < n/2; j++) {
                //temp = bottom left
                int temp = matrix[n-j-1][i];
                //bottom left - bottom right
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                //bottom right = top right
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                //top right = top left
                matrix[j][n-i-1] = matrix[i][j];
                //top left = temp/bottom left
                matrix[i][j] = temp;
            }
        }
    }
    public static void main(String[] args) {
        RotateImage r = new RotateImage();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        r.rotate(matrix);
    }
}
//TC O(n) SC O(1)