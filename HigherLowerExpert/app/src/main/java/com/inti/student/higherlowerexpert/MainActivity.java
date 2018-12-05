package com.inti.student.higherlowerexpert;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT="student.inti.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button next = (Button) findViewById(R.id.open); //link with guess function
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //if click then go to guess function
                openGuessFunction(); //open the guess function page
            }
        });
    }
    public void openGuessFunction(){
        EditText user = (EditText) findViewById(R.id.username);// bring the name to the guess function
        String text = user.getText().toString();//convert the text to string and get it

        Intent i = new Intent(this,GuessFunction.class); //change page
        i.putExtra(EXTRA_TEXT,text);
        startActivity(i);
    }
}
