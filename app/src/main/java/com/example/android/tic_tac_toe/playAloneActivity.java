package com.example.android.tic_tac_toe;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.tic_tac_toe.R;

import java.util.Random;

//constructs a new class showing game between human and computer
public class playAloneActivity extends AppCompatActivity {

    Button boardStatus[][];
    Button newGame;
    TextView status;

    int HUMAN = 1;
    int COMPUTER = 2;
    Random random;

    int First = 0;
    int count = 0;
    boolean isGameOver = false;
    private SetGame setGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_grid);

        boardStatus = new Button[3][3];
        boardStatus[0][0] = (Button) findViewById(R.id.box1);
        boardStatus[0][1] = (Button) findViewById(R.id.box2);
        boardStatus[0][2] = (Button) findViewById(R.id.box3);
        boardStatus[1][0] = (Button) findViewById(R.id.box4);
        boardStatus[1][1] = (Button) findViewById(R.id.box5);
        boardStatus[1][2] = (Button) findViewById(R.id.box6);
        boardStatus[2][0] = (Button) findViewById(R.id.box7);
        boardStatus[2][1] = (Button) findViewById(R.id.box8);
        boardStatus[2][2] = (Button) findViewById(R.id.box9);
        status = (TextView) findViewById(R.id.status);
        newGame = (Button) findViewById(R.id.reset);

        random = new Random();

        final CharSequence[] items = {"Computer", "Player"};

        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setCancelable(false);
        alertDialog.setTitle("Who Plays first?");
        alertDialog.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item] == "Computer") {
                    First = 1; // Computer
                } else if (items[item] == "Player") {
                    First = 2; // Player
                }
                dialog.dismiss();

                setGame = new SetGame(playAloneActivity.this);

                if (First == 1) {
                    startNewGame(true); // True For Computer
                }
                if (First == 2) {
                    startNewGame(false); // False For Player
                }

            }
        });
        alertDialog.show();

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count % 2 == 0) {
                    startNewGame(false);
                    count++;
                } else {
                    startNewGame(true);
                    count++;
                }
            }
        });

    }

    //a new game starts when board resets
    private void startNewGame(boolean playFirst) {
        MyResetBoard();

        if (playFirst) {
            // Computer plays First
            setMove(random.nextInt(3), random.nextInt(3), COMPUTER);
        }
        isGameOver = false;
    }

    //reset the board, ready for new game
    private void MyResetBoard() {
        setGame.resetBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardStatus[i][j].setText("");
                boardStatus[i][j].setOnClickListener(new ButtonClickListener(i, j));
            }
        }
        setInfo("Try Again!!!");
    }

    private class ButtonClickListener implements View.OnClickListener {

        int x, y;

        public ButtonClickListener(int i, int j) {
            this.x = i;
            this.y = j;
        }

        @Override
        public void onClick(View v) {
            if (!isGameOver && boardStatus[x][y].getText()=="") { // If the game is not over
                if (boardStatus[x][y].isEnabled()) {
                    setMove(x, y, HUMAN); // Human makes a move CROSS


                    int winner = setGame.CheckGameState();

                    if (winner == setGame.PLAYING) { // If still playing
                        int[] result = setGame.move();
                        setMove(result[0], result[1], COMPUTER);
                    }
                    else if (winner == setGame.draw) { // If draw
                        isGameOver = true;
                        result("Draw!!!");

                    } else if (winner == setGame.cross_won) { // X Won
                        isGameOver = true;
                        //human cant win

                    } else if (winner == setGame.nut_won) { // O Won
                        isGameOver = true;
                        result("Computer Won!");
                    }
                }
            }


        }
    }



    //checks when a player wins or loose
    private void result(String winner){
        setInfo(winner);
    }

    //adds text of win or draw to the status textview
    private void setInfo(String text){
        status.setText(text);
    }

    //this is where players take turn to play either X or 0
    public void setMove(int x, int y, int player) {
        setGame.placeAMove(x, y, player);
        if (player == 1) {
            boardStatus[x][y].setText("X");
        } else {
            boardStatus[x][y].setText("0");
        }
    }
}

