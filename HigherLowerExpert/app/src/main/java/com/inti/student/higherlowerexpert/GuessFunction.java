package com.inti.student.higherlowerexpert;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random; // import for the random function use

public class GuessFunction extends AppCompatActivity implements View.OnClickListener{

    public static final int MAX_NUMBER = 100; //set the number between 0-100
    public static final Random RANDOM= new Random(); // random the number
    private TextView msgTv; // pop out result message
    private EditText numberEnteredEt;//user enter num
    private Button validate; //check
    private Button back; //return main
    private int numberToFind, numberTries;//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_function);

        Intent i = getIntent(); //this is the link to main page
        String name = i.getStringExtra(MainActivity.EXTRA_TEXT);
        TextView n = findViewById(R.id.showtext); //bring the text name to this page
        n.setText(name);


        msgTv = (TextView) findViewById(R.id.msg);
        numberEnteredEt = (EditText) findViewById(R.id.numberEnteredEt);
        validate = (Button) findViewById(R.id.validate);
        validate.setOnClickListener(this);
        Button back = (Button) findViewById(R.id.Back); //return to main page
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuessFunction.this, MainActivity.class));
            }
        });
        newGame();
    }

    @Override
    public void onClick(View view) { //ok when click check number is same ad random or not
        if(view == validate){
            validate();
        }
    }


    private void validate() {
        int n = Integer.parseInt(numberEnteredEt.getText().toString());
        numberTries++;
            if (n == numberToFind) {
                String nextLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.

                Toast.makeText(this, " Congratulation You found the Boom" +nextLine +
                        "Answer is: " +  numberToFind + nextLine + "You have Tries "+ numberTries + " times", Toast.LENGTH_LONG).show();
                msgTv.setText("Congratulation!");

                newGame();
            } else if (n > MAX_NUMBER) { //check number if bigger than 100 return not in range
                msgTv.setText(R.string.Not_In_Range); //get the string from string xml
            } else if (n > numberToFind) { //if bigger than the random number will print too high
                msgTv.setText(R.string.too_high);
            } else if (n < numberToFind) { //if smaller than the random number will print too low
                msgTv.setText(R.string.too_low);
            }
    }
    private void newGame() //if call new game than the game will start
    {
        numberToFind = RANDOM.nextInt(MAX_NUMBER)+1;
        msgTv.setText(R.string.start_msg);
        numberEnteredEt.setText(""); //user input number
        numberTries = 0; //counter store how many time u tries
    }
}