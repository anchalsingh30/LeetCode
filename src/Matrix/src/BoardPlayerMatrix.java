package Matrix.src;

public class BoardPlayerMatrix {
    public static class Board {
        //initialize variables
        int[][] board;
        String Orientation;

        public Board() {
            this.board = new int[3][3];
            this.Orientation = "NEWS";
        }

        public void printBoard() {
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board.length; col++) {
                    if (row == 0 && col == 1 ) {
                        System.out.print("v"); // player facing south
                    } else if( row == 1 && col == 0) {
                        System.out.print("<"); // player facing east
                    } else if( row == 1 && col == 2) {
                        System.out.print(">"); // player facing west
                    } else if( row == 2 && col == 1) {
                        System.out.print("^"); // player facing north
                    }
                    else {
                        System.out.print("-");
                    }
                }
                System.out.println();
            }

        }
    }
    public static void main(String[] args) {
//        BoardPlayerMatrix b = new BoardPlayerMatrix();
        Board board = new Board();
        board.printBoard();

        /*
        print: 3*3 board with player facing south like below
        Orientation: South -> "v", North-> "^", East-> "<", West-> ">"
        at i[0][0]-> (-) and i[1][0]-> (v) and i[2][0]-> (-)  //v represents player facing south
        i[0][1]-> (-) and i[1][1]-> (-) and i[2][1]-> (-)
        i[0][2]-> (-) and i[2][2]-> (-) and i[2][2]-> (-)
        -v-
        ---
        ---
         */

    }
}
