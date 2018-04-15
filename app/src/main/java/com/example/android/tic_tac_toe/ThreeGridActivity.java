/*Copyright 2018 The Android Open Project
        * Licensed under the Apache License, Version 2.0 (the "Licence");
        * You may not use this file except in compliance with the License.
        * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
        * Unless required by applicable law or agreed to in writing, software
        * distributed under the Licence is distributed on an "AS IS" BASIS,
        * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        * See the Licence for the specific language governing permissions and
        * limitations under the Licence*/

package com.example.android.tic_tac_toe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.tic_tac_toe.R;


//constructs a new class showing game between two players for 3 x 3
public class ThreeGridActivity extends AppCompatActivity implements View.OnClickListener{

    boolean PLAYER_X = true;

    int count = 0;
    Button box1;
    Button box2;
    Button box3;
    Button box4;
    Button box5;
    Button box6;
    Button box7;
    Button box8;
    Button box9;
    Button reset;
    TextView status;

    int[][] boardStatus = new int[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_grid);

        box1 = (Button) findViewById(R.id.box1);
        box2 = (Button) findViewById(R.id.box2);
        box3 = (Button) findViewById(R.id.box3);
        box4 = (Button) findViewById(R.id.box4);
        box5 = (Button) findViewById(R.id.box5);
        box6 = (Button) findViewById(R.id.box6);
        box7 = (Button) findViewById(R.id.box7);
        box8 = (Button) findViewById(R.id.box8);
        box9 = (Button) findViewById(R.id.box9);
        reset = (Button) findViewById(R.id.reset);
        status = (TextView) findViewById(R.id.status);

        reset.setOnClickListener(this);
        box1.setOnClickListener(this);
        box2.setOnClickListener(this);
        box3.setOnClickListener(this);
        box4.setOnClickListener(this);
        box5.setOnClickListener(this);
        box6.setOnClickListener(this);
        box7.setOnClickListener(this);
        box8.setOnClickListener(this);
        box9.setOnClickListener(this);

        initializeBoardStatus();

    }

    @Override
    public void onClick(View view) {

        boolean resetButtonPressed = false;

        switch (view.getId()){
            case R.id.box1:
                if(PLAYER_X){
                    box1.setText("X");
                    boardStatus[0][0] = 1;
                }
                else{
                    box1.setText("0");
                    boardStatus[0][0] = 0;
                }
                box1.setEnabled(false);
                break;

            case R.id.box2:
                if(PLAYER_X){
                    box2.setText("X");
                    boardStatus[0][1] = 1;
                }
                else{
                    box2.setText("0");
                    boardStatus[0][1] = 0;
                }
                box2.setEnabled(false);
                break;

            case R.id.box3:
                if(PLAYER_X){
                    box3.setText("X");
                    boardStatus[0][2] = 1;
                }
                else{
                    box3.setText("0");
                    boardStatus[0][2] = 0;
                }
                box3.setEnabled(false);
                break;

            case R.id.box4:
                if(PLAYER_X){
                    box4.setText("X");
                    boardStatus[1][0] = 1;
                }
                else{
                    box4.setText("0");
                    boardStatus[1][0] = 0;
                }
                box4.setEnabled(false);
                break;

            case R.id.box5:
                if(PLAYER_X){
                    box5.setText("X");
                    boardStatus[1][1] = 1;
                }
                else{
                    box5.setText("0");
                    boardStatus[1][1] = 0;
                }
                box5.setEnabled(false);
                break;

            case R.id.box6:
                if(PLAYER_X){
                    box6.setText("X");
                    boardStatus[1][2] = 1;
                }
                else{
                    box6.setText("0");
                    boardStatus[1][2] = 0;
                }
                box6.setEnabled(false);
                break;

            case R.id.box7:
                if(PLAYER_X){
                    box7.setText("X");
                    boardStatus[2][0] = 1;
                }
                else{
                    box7.setText("0");
                    boardStatus[2][0] = 0;
                }
                box7.setEnabled(false);
                break;

            case R.id.box8:
                if(PLAYER_X){
                    box8.setText("X");
                    boardStatus[2][1] = 1;
                }
                else{
                    box8.setText("0");
                    boardStatus[2][1] = 0;
                }
                box8.setEnabled(false);
                break;

            case R.id.box9:
                if(PLAYER_X){
                    box9.setText("X");
                    boardStatus[2][2] = 1;
                }
                else{
                    box9.setText("0");
                    boardStatus[2][2] = 0;
                }
                box9.setEnabled(false);
                break;

            case R.id.reset:
                resetButtonPressed = true;
                break;

            default:
                break;

        }

        if(resetButtonPressed){
            resetBoard();
        }
        else{
            count ++;
            PLAYER_X = !PLAYER_X;

            if(PLAYER_X){
                setInfo("Player X turn");
            }
            else {
                setInfo("Player 0 turn");
            }

            if(count==9){
                result("Draw!!!");
            }

            checkWinner();
        }
    }

    //checks when a player wins or loose depending on position
    private void checkWinner(){

        //Horizontal --- rows
        for(int i=0; i<3; i++){
            if(boardStatus[i][0] == boardStatus[i][1] && boardStatus[i][0] == boardStatus[i][2]){
                if (boardStatus[i][0]==1){
                    result("You Won Player X!");
                    break;
                }
                else if (boardStatus[i][0]==0) {
                    result("You Won Player 0!");
                    break;
                }
            }
        }

        //Vertical --- columns
        for(int i=0; i<3; i++){
            if(boardStatus[0][i] == boardStatus[1][i] && boardStatus[0][i] == boardStatus[2][i]){
                if (boardStatus[0][i]==1){
                    result("You Won Player X!");
                    break;
                }
                else if (boardStatus[0][i]==0) {
                    result("You Won Player 0!");
                    break;
                }
            }
        }

        //First diagonal
        if(boardStatus[0][0] == boardStatus[1][1] && boardStatus[0][0] == boardStatus[2][2]){
            if (boardStatus[0][0]==1){
                result("You Won Player X!");
            }
            else if (boardStatus[0][0]==0) {
                result("You Won Player 0!");
            }
        }

        //Second diagonal
        if(boardStatus[0][2] == boardStatus[1][1] && boardStatus[0][2] == boardStatus[2][0]){
            if (boardStatus[0][2]==1){
                result("You Won Player X!");
            }
            else if (boardStatus[0][2]==0) {
                result("You Won Player 0!");
            }
        }
    }

    //stops the players from continuing playing on the board
    // once the game is over, and allows it once the board is reset
    private void enableAllBoxes(boolean value){
        box1.setEnabled(value);
        box2.setEnabled(value);
        box3.setEnabled(value);
        box4.setEnabled(value);
        box5.setEnabled(value);
        box6.setEnabled(value);
        box7.setEnabled(value);
        box8.setEnabled(value);
        box9.setEnabled(value);
    }

    //outputs status when a player wins or loose
    private void result(String winner){
        setInfo(winner);
        enableAllBoxes(false);
    }

    // This method resets the board
    private void resetBoard(){
        box1.setText("");
        box2.setText("");
        box3.setText("");
        box4.setText("");
        box5.setText("");
        box6.setText("");
        box7.setText("");
        box8.setText("");
        box9.setText("");

        enableAllBoxes(true);

        PLAYER_X = true;
        count = 0;

        initializeBoardStatus();

        setInfo("Play");

    }

    //adds text of win or draw to the status textview
    private void setInfo(String text){
        status.setText(text);
    }

    //changes the board to initial state once it's reset
    private void initializeBoardStatus(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                boardStatus[i][j] = -1;
            }
        }

    }


}

