package com.example.labassignment01;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import static android.view.View.Y;

public class MainActivity extends AppCompatActivity {

    private Button button;

    public int Strike = 0;
    public int Ball = 0;
    TextView Str;
    TextView Bal;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openAboutBtn();

            }
        });

        Str = (TextView) findViewById(R.id.VALUE_STRIKE);
        Bal = (TextView) findViewById(R.id.VALUE_BALL);



    }

    public void openAboutBtn(){

        Intent intent = new Intent(this,About.class);

        startActivity(intent);


    }



    public void AddStrike(View Y){
        Strike++;
        Str.setText(Integer.toString(Strike));
        Check();
    }

    public void AddBall(View X){

        Ball++;
        Bal.setText(Integer.toString(Ball));
        Check();
    }

   public void ResetAll(View R){
        Strike = 0;
        Ball = 0;


        Str.setText(Integer.toString(Strike));
        Bal.setText(Integer.toString(Ball));
    }

    public void Exit(View view){
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
    public void Check(){
        if(Strike >= 3){
            Strike = 0;
            Ball = 0;
            Str.setText(Integer.toString(Strike));
            Bal.setText(Integer.toString(Ball));
            AlertDialog.Builder MessageBuilder = new AlertDialog.Builder(this);
            // Set Dialog Message
            MessageBuilder.setTitle("Result");
            MessageBuilder.setMessage("Out!!");
            MessageBuilder.setCancelable(false);
            MessageBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {

                    dialog.cancel();

                }

            });
            // make alert dialog
            AlertDialog alertDialog = MessageBuilder.create();
            // show the Out!! message
            alertDialog.show();
        }

        else if (Ball >= 4){
            Strike = 0;
            Ball = 0;
            Str.setText(Integer.toString(Strike));
            Bal.setText(Integer.toString(Ball));
            AlertDialog.Builder MessageBuilder = new AlertDialog.Builder(this);

            MessageBuilder.setTitle("Result");
            MessageBuilder.setMessage("Walk!!!");
            MessageBuilder.setCancelable(false);
            MessageBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int id) {

                    dialog.cancel();

                }

            });

            AlertDialog alertDialog = MessageBuilder.create();
            alertDialog.show();

        }

    }

}

