package Matrix.src;

public class FlipAndInvertImage {
    public int[][] flipAndInvertImage(int[][] image) {
        int row = image.length; //3
        int col = image.length; //3
        int[][] result = new int[row][col]; //[3][3]

        // Step 1 : revert
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                result[i][j] = image[i][col-j-1];
            }
        }
        // Step 2: invert
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                result[i][j] = result[i][j] == 1 ? 0 : 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        FlipAndInvertImage f = new FlipAndInvertImage();
        int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
        int[][] res = f.flipAndInvertImage(image);
        for(int i=0; i<res.length;i++) {
            for(int j=0; j<res.length; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }
}
