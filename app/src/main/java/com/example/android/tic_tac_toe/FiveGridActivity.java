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

//constructs a new class showing game between two players for 5 x 5
public class FiveGridActivity extends AppCompatActivity implements View.OnClickListener{

    boolean PLAYER_X = true;

    int count = 0;   /* count no of turns */

    Button box1;
    Button box2;
    Button box3;
    Button box4;
    Button box5;
    Button box6;
    Button box7;
    Button box8;
    Button box9;
    Button box10;
    Button box11;
    Button box12;
    Button box13;
    Button box14;
    Button box15;
    Button box16;
    Button box17;
    Button box18;
    Button box19;
    Button box20;
    Button box21;
    Button box22;
    Button box23;
    Button box24;
    Button box25;
    Button reset;
    TextView status;

    int[][] boardStatus = new int[5][5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.five_grid);

        box1 = (Button) findViewById(R.id.box1);
        box2 = (Button) findViewById(R.id.box2);
        box3 = (Button) findViewById(R.id.box3);
        box4 = (Button) findViewById(R.id.box4);
        box5 = (Button) findViewById(R.id.box5);
        box6 = (Button) findViewById(R.id.box6);
        box7 = (Button) findViewById(R.id.box7);
        box8 = (Button) findViewById(R.id.box8);
        box9 = (Button) findViewById(R.id.box9);
        box10 = (Button) findViewById(R.id.box10);
        box11 = (Button) findViewById(R.id.box11);
        box12 = (Button) findViewById(R.id.box12);
        box13 = (Button) findViewById(R.id.box13);
        box14 = (Button) findViewById(R.id.box14);
        box15 = (Button) findViewById(R.id.box15);
        box16 = (Button) findViewById(R.id.box16);
        box17 = (Button) findViewById(R.id.box17);
        box18 = (Button) findViewById(R.id.box18);
        box19 = (Button) findViewById(R.id.box19);
        box20 = (Button) findViewById(R.id.box20);
        box21 = (Button) findViewById(R.id.box21);
        box22 = (Button) findViewById(R.id.box22);
        box23 = (Button) findViewById(R.id.box23);
        box24 = (Button) findViewById(R.id.box24);
        box25 = (Button) findViewById(R.id.box25);
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
        box10.setOnClickListener(this);
        box11.setOnClickListener(this);
        box12.setOnClickListener(this);
        box13.setOnClickListener(this);
        box14.setOnClickListener(this);
        box15.setOnClickListener(this);
        box16.setOnClickListener(this);
        box17.setOnClickListener(this);
        box18.setOnClickListener(this);
        box19.setOnClickListener(this);
        box20.setOnClickListener(this);
        box21.setOnClickListener(this);
        box22.setOnClickListener(this);
        box23.setOnClickListener(this);
        box24.setOnClickListener(this);
        box25.setOnClickListener(this);

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
                    boardStatus[0][3] = 1;
                }
                else{
                    box4.setText("0");
                    boardStatus[0][3] = 0;
                }
                box4.setEnabled(false);
                break;

            case R.id.box5:
                if(PLAYER_X){
                    box5.setText("X");
                    boardStatus[0][4] = 1;
                }
                else{
                    box5.setText("0");
                    boardStatus[0][4] = 0;
                }
                box5.setEnabled(false);
                break;

            case R.id.box6:
                if(PLAYER_X){
                    box6.setText("X");
                    boardStatus[1][0] = 1;
                }
                else{
                    box6.setText("0");
                    boardStatus[1][0] = 0;
                }
                box6.setEnabled(false);
                break;

            case R.id.box7:
                if(PLAYER_X){
                    box7.setText("X");
                    boardStatus[1][1] = 1;
                }
                else{
                    box7.setText("0");
                    boardStatus[1][1] = 0;
                }
                box7.setEnabled(false);
                break;

            case R.id.box8:
                if(PLAYER_X){
                    box8.setText("X");
                    boardStatus[1][2] = 1;
                }
                else{
                    box8.setText("0");
                    boardStatus[1][2] = 0;
                }
                box8.setEnabled(false);
                break;

            case R.id.box9:
                if(PLAYER_X){
                    box9.setText("X");
                    boardStatus[1][3] = 1;
                }
                else{
                    box9.setText("0");
                    boardStatus[1][3] = 0;
                }
                box9.setEnabled(false);
                break;

            case R.id.box10:
                if(PLAYER_X){
                    box10.setText("X");
                    boardStatus[1][4] = 1;
                }
                else{
                    box10.setText("0");
                    boardStatus[1][4] = 0;
                }
                box10.setEnabled(false);
                break;

            case R.id.box11:
                if(PLAYER_X){
                    box11.setText("X");
                    boardStatus[2][0] = 1;
                }
                else{
                    box11.setText("0");
                    boardStatus[2][0] = 0;
                }
                box11.setEnabled(false);
                break;

            case R.id.box12:
                if(PLAYER_X){
                    box12.setText("X");
                    boardStatus[2][1] = 1;
                }
                else{
                    box12.setText("0");
                    boardStatus[2][1] = 0;
                }
                box12.setEnabled(false);
                break;

            case R.id.box13:
                if(PLAYER_X){
                    box13.setText("X");
                    boardStatus[2][2] = 1;
                }
                else{
                    box13.setText("0");
                    boardStatus[2][2] = 0;
                }
                box13.setEnabled(false);
                break;

            case R.id.box14:
                if(PLAYER_X){
                    box14.setText("X");
                    boardStatus[2][3] = 1;
                }
                else{
                    box14.setText("0");
                    boardStatus[2][3] = 0;
                }
                box14.setEnabled(false);
                break;

            case R.id.box15:
                if(PLAYER_X){
                    box15.setText("X");
                    boardStatus[2][4] = 1;
                }
                else{
                    box15.setText("0");
                    boardStatus[2][4] = 0;
                }
                box15.setEnabled(false);
                break;

            case R.id.box16:
                if(PLAYER_X){
                    box16.setText("X");
                    boardStatus[3][0] = 1;
                }
                else{
                    box16.setText("0");
                    boardStatus[3][0] = 0;
                }
                box16.setEnabled(false);
                break;

            case R.id.box17:
                if(PLAYER_X){
                    box17.setText("X");
                    boardStatus[3][1] = 1;
                }
                else{
                    box17.setText("0");
                    boardStatus[3][1] = 0;
                }
                box17.setEnabled(false);
                break;

            case R.id.box18:
                if(PLAYER_X){
                    box18.setText("X");
                    boardStatus[3][2] = 1;
                }
                else{
                    box18.setText("0");
                    boardStatus[3][2] = 0;
                }
                box18.setEnabled(false);
                break;

            case R.id.box19:
                if(PLAYER_X){
                    box19.setText("X");
                    boardStatus[3][3] = 1;
                }
                else{
                    box19.setText("0");
                    boardStatus[3][3] = 0;
                }
                box19.setEnabled(false);
                break;

            case R.id.box20:
                if(PLAYER_X){
                    box20.setText("X");
                    boardStatus[3][4] = 1;
                }
                else{
                    box20.setText("0");
                    boardStatus[3][4] = 0;
                }
                box20.setEnabled(false);
                break;

            case R.id.box21:
                if(PLAYER_X){
                    box21.setText("X");
                    boardStatus[4][0] = 1;
                }
                else{
                    box21.setText("0");
                    boardStatus[4][0] = 0;
                }
                box21.setEnabled(false);
                break;

            case R.id.box22:
                if(PLAYER_X){
                    box22.setText("X");
                    boardStatus[4][1] = 1;
                }
                else{
                    box22.setText("0");
                    boardStatus[4][1] = 0;
                }
                box22.setEnabled(false);
                break;

            case R.id.box23:
                if(PLAYER_X){
                    box23.setText("X");
                    boardStatus[4][2] = 1;
                }
                else{
                    box23.setText("0");
                    boardStatus[4][2] = 0;
                }
                box23.setEnabled(false);
                break;

            case R.id.box24:
                if(PLAYER_X){
                    box24.setText("X");
                    boardStatus[4][3] = 1;
                }
                else{
                    box24.setText("0");
                    boardStatus[4][3] = 0;
                }
                box24.setEnabled(false);
                break;

            case R.id.box25:
                if(PLAYER_X){
                    box25.setText("X");
                    boardStatus[4][4] = 1;
                }
                else{
                    box25.setText("0");
                    boardStatus[4][4] = 0;
                }
                box25.setEnabled(false);
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

            if(count==25){
                result("Draw!!!");
            }

            checkWinner();
        }
    }


    //checks when a player wins or loose depending on position
    private void checkWinner(){

        //Horizontal --- rows
        for(int i=0; i<5; i++){
            if(boardStatus[i][0] == boardStatus[i][1] && boardStatus[i][0] == boardStatus[i][2] && boardStatus[i][0] == boardStatus[i][3] && boardStatus[i][0] == boardStatus[i][4]){
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
        for(int i=0; i<5; i++){
            if(boardStatus[0][i] == boardStatus[1][i] && boardStatus[0][i] == boardStatus[2][i] && boardStatus[0][i] == boardStatus[3][i] && boardStatus[0][i] == boardStatus[4][i]){
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
        if(boardStatus[0][0] == boardStatus[1][1] && boardStatus[0][0] == boardStatus[2][2] && boardStatus[0][0] == boardStatus[3][3] && boardStatus[0][0] == boardStatus[4][4]){
            if (boardStatus[0][0]==1){
                result("You Won Player X!");
            }
            else if (boardStatus[0][0]==0) {
                result("You Won Player 0!");
            }
        }

        //Second diagonal
        if(boardStatus[0][4] == boardStatus[1][3] && boardStatus[0][4] == boardStatus[2][2]  && boardStatus[0][4] == boardStatus[4][0]){
            if (boardStatus[0][4]==1){
                result("You Won Player X!");
            }
            else if (boardStatus[0][4]==0) {
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
        box10.setEnabled(value);
        box11.setEnabled(value);
        box12.setEnabled(value);
        box13.setEnabled(value);
        box14.setEnabled(value);
        box15.setEnabled(value);
        box16.setEnabled(value);
        box17.setEnabled(value);
        box18.setEnabled(value);
        box19.setEnabled(value);
        box20.setEnabled(value);
        box21.setEnabled(value);
        box22.setEnabled(value);
        box23.setEnabled(value);
        box24.setEnabled(value);
        box25.setEnabled(value);
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
        box10.setText("");
        box11.setText("");
        box12.setText("");
        box13.setText("");
        box14.setText("");
        box15.setText("");
        box16.setText("");
        box17.setText("");
        box18.setText("");
        box19.setText("");
        box20.setText("");
        box21.setText("");
        box22.setText("");
        box23.setText("");
        box24.setText("");
        box25.setText("");

        enableAllBoxes(true);

        PLAYER_X = true;
        count = 0;

        initializeBoardStatus();

        setInfo("Try Again!!!");

    }

    //adds text of win or draw to the status textview
    private void setInfo(String text){
        status.setText(text);
    }

    //changes the board to initial state once it's reset
    private void initializeBoardStatus(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                boardStatus[i][j] = -1;
            }
        }

    }


}
