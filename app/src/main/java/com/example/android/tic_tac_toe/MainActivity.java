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

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    AlertDialog alertDialog1;
    CharSequence[] values = {" 3 x 3 "," 4 x 4 "," 5 x 5 "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playWithSomeone = (Button)findViewById(R.id.playWithSomeone);
        playWithSomeone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChooseBoardSizeForPlayWithSomeone();
            }
        });

        Button playAlone = (Button)findViewById(R.id.playAlone);
        playAlone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChooseBoardSizeForPlayAlone();
            }
        });
    }

    //creates an alert box where you can choose the board size you want
    public void ChooseBoardSizeForPlayWithSomeone(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Choose Board Size");
        builder.setSingleChoiceItems(values, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                switch (item) {
                    case 0:
                        Intent intent = new Intent(MainActivity.this, ThreeGridActivity.class);
                        MainActivity.this.startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, FourGridActivity.class);
                        MainActivity.this.startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, FiveGridActivity.class);
                        MainActivity.this.startActivity(intent);
                        break;
                }
                alertDialog1.dismiss();
            }
        });
        alertDialog1 = builder.create();
        alertDialog1.show();

    }

    //takes you to the page where you play with the computer
    public void ChooseBoardSizeForPlayAlone(){
        Intent intent = new Intent(MainActivity.this, playAloneActivity.class);
        MainActivity.this.startActivity(intent);
    }

    //exits the game
    public void exit_click(View v) {
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

        dlgAlert.setMessage("Do you really want to exit?");
        dlgAlert.setTitle("Exit");

        dlgAlert.setCancelable(true);
        dlgAlert.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        System.exit(0);
                    }
                });
        dlgAlert.create().show();
    }


}
