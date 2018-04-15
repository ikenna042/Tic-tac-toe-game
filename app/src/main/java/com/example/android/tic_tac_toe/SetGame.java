package com.example.android.tic_tac_toe;

import java.util.ArrayList;
import java.util.List;

public class SetGame {
    public final int empty = 0;
    public final int cross = 1;
    public final int nut = 2;

    public final int PLAYING = 0;
    public final int cross_won = 1;
    public final int nut_won = 2;
    public final int draw = 3;

    // game board and status
    public static final int ROWS = 3, COLS = 3;
    public static int[][] board = new int[ROWS][COLS];

    playAloneActivity playAloneActivity;

    public SetGame(playAloneActivity playAloneActivity) {
        this.playAloneActivity = playAloneActivity;
    }

    public void resetBoard() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                board[i][j] = 0;
            }
        }
    }

    // Getting best move for computer. Return int[2] of {row, col}
    public int[] move() {
        int[] result = minimax(2, nut); // depth, max turn
        return new int[] {result[1], result[2]};   // row, col
    }

    public int[] minimax(int depth, int player){
        List<int[]> nextMoves = generateMoves();

        // mySeed(nut) is maximizing; while oppSeed(cross) is minimizing
        int bestScore = (player == nut) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int currentScore;
        int bestRow = -1;
        int bestCol = -1;

        if (nextMoves.isEmpty() || depth == 0){
            bestScore = evaluate();
        } else {
            for (int[] move : nextMoves){
                board[move[0]][move[1]] = player;
                if (player == nut) { // nut is Maximizing Player
                    currentScore = minimax(depth - 1, cross)[0];
                    if (currentScore > bestScore) {
                        bestScore = currentScore;
                        bestRow = move[0];
                        bestCol = move[1];
                    }
                } else { // cross is Minimizing Player
                    currentScore = minimax(depth - 1, nut)[0];
                    if (currentScore < bestScore) {
                        bestScore = currentScore;
                        bestRow = move[0];
                        bestCol = move[1];
                    }
                }
                // Undo move
                board[move[0]][move[1]] = empty;
            }
        }
        return new int[] {bestScore, bestRow, bestCol};
    }

    private int evaluate() {
        int score = 0;
        // Evaluate score for each of the 8 lines (3 rows, 3 columns, 2 diagonals)
        score += evaluateLine(0, 0, 0, 1, 0, 2);  // row 0
        score += evaluateLine(1, 0, 1, 1, 1, 2);  // row 1
        score += evaluateLine(2, 0, 2, 1, 2, 2);  // row 2
        score += evaluateLine(0, 0, 1, 0, 2, 0);  // col 0
        score += evaluateLine(0, 1, 1, 1, 2, 1);  // col 1
        score += evaluateLine(0, 2, 1, 2, 2, 2);  // col 2
        score += evaluateLine(0, 0, 1, 1, 2, 2);  // diagonal
        score += evaluateLine(0, 2, 1, 1, 2, 0);  // alternate diagonal
        return score;
    }


    private int evaluateLine(int row1, int col1, int row2, int col2, int row3, int col3) {
        int score = 0;

        // First cell
        if (board[row1][col1] == nut) {
            score = 1;
        } else if (board[row1][col1] == cross) {
            score = -1;
        }

        // Second cell
        if (board[row2][col2] == nut) {
            if (score == 1) {   // cell1 is mySeed
                score = 10;
            } else if (score == -1) {  // cell1 is oppSeed
                return 0;
            } else {  // cell1 is empty
                score = 1;
            }
        } else if (board[row2][col2] == cross) {
            if (score == -1) { // cell1 is oppSeed
                score = -10;
            } else if (score == 1) { // cell1 is mySeed
                return 0;
            } else {  // cell1 is empty
                score = -1;
            }
        }

        // Third cell
        if (board[row3][col3] == nut) {
            if (score > 0) {  // cell1 and/or cell2 is mySeed
                score *= 10;
            } else if (score < 0) {  // cell1 and/or cell2 is oppSeed
                return 0;
            } else {  // cell1 and cell2 are empty
                score = 1;
            }
        } else if (board[row3][col3] == cross) {
            if (score < 0) {  // cell1 and/or cell2 is oppSeed
                score *= 10;
            } else if (score > 1) {  // cell1 and/or cell2 is mySeed
                return 0;
            } else {  // cell1 and cell2 are empty
                score = -1;
            }
        }
        return score;
    }

    private List<int[]> generateMoves() {
        List<int[]> nextMoves = new ArrayList<int[]>(); // allocate List

        int State = CheckGameState();
        // If gameover, i.e., no next move
        if (State == 1 || // X won
                State == 2 || // O won
                State == 3)   // draw
        {
            return nextMoves;   // return empty list
        }

        // Search for empty cells and add to the List
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                if (board[row][col] == empty) {
                    nextMoves.add(new int[] {row, col});
                }
            }
        }
        return nextMoves;
    }

    //check the board to play
    public void placeAMove(int x, int y, int player) {
        board[x][y] = player;   //player = 1 for X, 2 for O
    }


    public int CheckGameState() {

        // Check Rows - Horizontal Lines
        for (int i = 0; i< ROWS; i++){
            if (board[i][0] == cross &&
                    board[i][1] == cross &&
                    board[i][2] == cross){
                return cross_won;
            }
            if (board[i][0] == nut &&
                    board[i][1] == nut &&
                    board[i][2] == nut){
                return nut_won;
            }
        }

        // Check Columns - Vertical Lines
        for (int i = 0; i< COLS; i++){
            if (board[0][i] == cross &&
                    board[1][i] == cross &&
                    board[2][i] == cross){
                return cross_won;
            }
            if (board[0][i] == nut &&
                    board[1][i] == nut &&
                    board[2][i] == nut){
                return nut_won;
            }
        }

        // Check Diagonal
        if (board[0][0] == cross &&
                board[1][1] == cross &&
                board[2][2] == cross){
            return cross_won;
        }
        if (board[0][0] == nut &&
                board[1][1] == nut &&
                board[2][2] == nut){
            return nut_won;
        }


        // Check Reverse-Diagonal
        if (board[0][2] == cross &&
                board[1][1] == cross &&
                board[2][0] == cross){
            return cross_won;
        }
        if (board[0][2] == nut &&
                board[1][1] == nut &&
                board[2][0] == nut){
            return nut_won;
        }

        // Check for Tie
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] != cross && board[i][j] != nut){
                    return PLAYING;
                }
            }
        }

        return draw;
    }

}