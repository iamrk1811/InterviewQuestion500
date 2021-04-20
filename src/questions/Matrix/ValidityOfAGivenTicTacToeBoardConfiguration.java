package questions.Matrix;

public class ValidityOfAGivenTicTacToeBoardConfiguration {
//    Q - https://www.geeksforgeeks.org/validity-of-a-given-tic-tac-toe-board-configuration/#:~:text=Armed%20with%20above%20conditions%20i.e.,%2DTac%2DToe%20board%20position.&text=Another%20way%20to%20find%20the,a%20given%20board%20is%20invalid.
    int[][] winingPosition = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
    };

    public boolean solve(char[] board) {
        int xCount = 0, oCount = 0;
        for (char ch : board) {
            if (ch == 'X') xCount++;
            else oCount++;
        }

        if (xCount == oCount || xCount == oCount + 1) {
            if (isWin(board, 'O')) {
                if (isWin(board, 'X'))
                    return false;
                return xCount == oCount;
            }
            if (isWin(board, 'X') && xCount != oCount + 1) {
                return false;
            }
            return true;
        }

        return false;
    }

    private boolean isWin(char[] board, char c) {
        for (int i = 0; i < 8; i++) {
            if (board[winingPosition[i][0]] == c &&
            board[winingPosition[i][1]] == c &&
            board[winingPosition[i][2]] == c) return true;
        }
        return false;
    }
}
