package edu.gatech.cs2340.spacetraderredux.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import edu.gatech.cs2340.spacetraderredux.R;


import static edu.gatech.cs2340.spacetraderredux.ViewModels.ConfigurationViewModel.*;

public class ConfigurationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        ImageButton difficultyUp = (ImageButton) findViewById(R.id.difficultyUp);
        difficultyUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView difficultyTextView = (TextView) findViewById(R.id.difficultyEditView);
                String difficultyText = (String) difficultyTextView.getText();
                String newDifficulty = updateDifficulty(difficultyText, true);
                difficultyTextView.setText(newDifficulty);
            }
        });

        ImageButton difficultyDown = (ImageButton) findViewById(R.id.difficultyDown);
        difficultyDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView difficultyTextView = (TextView) findViewById(R.id.difficultyEditView);
                String difficultyText = (String) difficultyTextView.getText();
                String newDifficulty = updateDifficulty(difficultyText, false);
                Log.d("hey", newDifficulty);
                difficultyTextView.setText(newDifficulty);
            }
        });


        ImageButton pilotUp = (ImageButton) findViewById(R.id.pilotUp);
        pilotUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView pilotTextView = (TextView) findViewById(R.id.pilotEditView);
                String pilotText = (String) pilotTextView.getText();
                String newSkill = updateSkill(pilotText, true);
                pilotTextView.setText(newSkill);
            }
        });

        ImageButton pilotDown = (ImageButton) findViewById(R.id.pilotDown);
        pilotDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView pilotTextView = (TextView) findViewById(R.id.pilotEditView);
                String pilotText = (String) pilotTextView.getText();
                String newSkill = updateSkill(pilotText, false);
                pilotTextView.setText(newSkill);
            }
        });

        ImageButton fighterUp = (ImageButton) findViewById(R.id.fighterUp);
        fighterUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView fighterTextView = (TextView) findViewById(R.id.fighterEditView);
                String fighterText = (String) fighterTextView.getText();
                String newSkill = updateSkill(fighterText, true);
                fighterTextView.setText(newSkill);
            }
        });

        final ImageButton fighterDown = (ImageButton) findViewById(R.id.fighterDown);
        fighterDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView fighterTextView = (TextView) findViewById(R.id.fighterEditView);
                String fighterText = (String) fighterTextView.getText();
                String newSkill = updateSkill(fighterText, false);
                fighterTextView.setText(newSkill);
            }
        });

        ImageButton traderUp = (ImageButton) findViewById(R.id.traderUp);
        traderUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView traderTextView = (TextView) findViewById(R.id.traderEditView);
                String traderText = (String) traderTextView.getText();
                String newSkill = updateSkill(traderText, true);
                traderTextView.setText(newSkill);
            }
        });

        ImageButton traderDown = (ImageButton) findViewById(R.id.traderDown);
        traderDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView traderTextView = (TextView) findViewById(R.id.traderEditView);
                String traderText = (String) traderTextView.getText();
                String newSkill = updateSkill(traderText, false);
                traderTextView.setText(newSkill);
            }
        });

        ImageButton engineerUp = (ImageButton) findViewById(R.id.engineerUp);
        engineerUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView engineerTextView = (TextView) findViewById(R.id.engineerEditView);
                String engineerText = (String) engineerTextView.getText();
                String newSkill = updateSkill(engineerText, true);
                engineerTextView.setText(newSkill);
            }
        });

        ImageButton engineerDown = (ImageButton) findViewById(R.id.engineerDown);
        engineerDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView engineerTextView = (TextView) findViewById(R.id.engineerEditView);
                String engineerText = (String) engineerTextView.getText();
                String newSkill = updateSkill(engineerText, false);
                engineerTextView.setText(newSkill);
            }
        });

        Button configureButton = (Button) findViewById(R.id.configureButton);
        configureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextName = (EditText) findViewById(R.id.editNameText);
                String nameText = editTextName.getText().toString();
                Toast.makeText(ConfigurationActivity.this, nameText, Toast.LENGTH_SHORT).show();
                TextView difficultyTextView = (TextView) findViewById(R.id.difficultyEditView);
                String difficultyText = (String) difficultyTextView.getText();
                TextView pilotTextView = (TextView) findViewById(R.id.pilotEditView);
                String pilotText = (String) pilotTextView.getText();
                TextView fighterTextView = (TextView) findViewById(R.id.fighterEditView);
                String fighterText = (String) fighterTextView.getText();
                TextView traderTextView = (TextView) findViewById(R.id.traderEditView);
                String traderText = (String) traderTextView.getText();
                TextView engineerTextView = (TextView) findViewById(R.id.engineerEditView);
                String engineerText = (String) engineerTextView.getText();
                boolean isValid = validPlayer(nameText, difficultyText, pilotText, fighterText,
                        traderText, engineerText);
                if (isValid) {
                    Toast.makeText(ConfigurationActivity.this, "YEA", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(ConfigurationActivity.this, "Invalid User Input", Toast.LENGTH_SHORT).show();
                    Intent activityChangeIntent = new Intent(ConfigurationActivity.this, SuccessView.class);

                    // currentContext.startActivity(activityChangeIntent);

                    ConfigurationActivity.this.startActivity(activityChangeIntent);
                    //SuccessView.receiveConfigData(nameText, difficultyText, pilotText, fighterText,
                         //   traderText, engineerText);
                }

            }
        });
    }
}
