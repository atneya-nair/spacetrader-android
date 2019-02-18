package edu.gatech.cs2340.spacetraderredux.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import edu.gatech.cs2340.spacetraderredux.R;

public class SuccessView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_view);
        Intent intent = getIntent();
        TextView successText = (TextView) findViewById(R.id.successTextView);
        successText.setText(intent.getStringExtra("playerData"));
    }

    public  void receiveConfigData(String nameText, String difficultyText, String pilotText, String fighterText,
                                  String traderText, String engineerText) {
        //TextView successText = (TextView) findViewById(R.)

    }
}
