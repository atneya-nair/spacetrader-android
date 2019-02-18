package edu.gatech.cs2340.spacetraderredux.Views;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
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

import org.w3c.dom.Text;

import edu.gatech.cs2340.spacetraderredux.R;
import edu.gatech.cs2340.spacetraderredux.ViewModels.ConfigurationViewModel;


import static edu.gatech.cs2340.spacetraderredux.ViewModels.ConfigurationViewModel.*;

public class ConfigurationActivity extends AppCompatActivity {
    private ConfigurationViewModel mViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        mViewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);

        TextView difficultyText =  (TextView) findViewById(R.id.difficulty_buttons)
                .findViewById(R.id.labelText);
        TextView difficultyValue =  (TextView) findViewById(R.id.difficulty_buttons)
                .findViewById(R.id.valueText);
        TextView pilotText =  (TextView) findViewById(R.id.pilot_buttons)
                .findViewById(R.id.labelText);
        TextView fighterText =  (TextView) findViewById(R.id.fighter_buttons)
                .findViewById(R.id.labelText);
        TextView traderText =  (TextView) findViewById(R.id.trader_buttons)
                .findViewById(R.id.labelText);
        TextView engineerText =  (TextView) findViewById(R.id.engineer_buttons)
                .findViewById(R.id.labelText);
        TextView nameText = (TextView) findViewById(R.id.characterName);
        Button submitButton = (Button) findViewById(R.id.submitButton);
        nameText.setText("Player1");
        difficultyText.setText("Difficulty:");
        pilotText.setText("Pilot");
        fighterText.setText("Fighter");
        traderText.setText("Trader");
        engineerText.setText("Engineer");
        difficultyValue.setText("EASY");
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView nameText = (TextView) findViewById(R.id.characterName);
                mViewModel.setName(nameText.getText().toString());
                if (mViewModel.validPlayer()) {
                    Toast.makeText(ConfigurationActivity.this, "Creating valid player", Toast.LENGTH_SHORT).show();
                    String s = mViewModel.createPlayer();
                    Intent activityChangeIntent = new Intent(ConfigurationActivity.this, SuccessView.class);
                    activityChangeIntent.putExtra("playerData", s);
                    ConfigurationActivity.this.startActivity(activityChangeIntent);
                } else {
                    Toast.makeText(ConfigurationActivity.this, "Invalid User Input", Toast.LENGTH_SHORT).show();


                }

            }
        });
    }
    public void downClicked(View view) {
        View parentView = (View) view.getParent();
        TextView labelText =  (TextView) parentView.findViewById(R.id.valueText);
        TextView remainingText = (TextView) findViewById(R.id.totalPoints);
        if (parentView.getId() ==  R.id.difficulty_buttons) {
            mViewModel.decDifficulty();
            labelText.setText(mViewModel.difficulty.toString());
        } else if (parentView.getId() == R.id.pilot_buttons) {
            mViewModel.decPoints(0);
            labelText.setText(Integer.toString(mViewModel.pilot));
        } else if (parentView.getId() == R.id.fighter_buttons) {
            mViewModel.decPoints(1);
            labelText.setText(Integer.toString(mViewModel.fighter));
        } else if (parentView.getId() == R.id.trader_buttons) {
            mViewModel.decPoints(2);
            labelText.setText(Integer.toString(mViewModel.trader));
        } else if (parentView.getId() == R.id.engineer_buttons) {
            mViewModel.decPoints(3);
            labelText.setText(Integer.toString(mViewModel.engineer));

        }
        remainingText.setText(mViewModel.getRemaining());
    }
    public void upClicked(View view) {
        View parentView = (View) view.getParent();
        TextView labelText =  (TextView) parentView.findViewById(R.id.valueText);
        TextView remainingText = (TextView) findViewById(R.id.totalPoints);
        if (parentView.getId() ==  R.id.difficulty_buttons) {
            mViewModel.incDifficulty();
            labelText.setText(mViewModel.difficulty.toString());
        } else if (parentView.getId() == R.id.pilot_buttons) {
            mViewModel.incPoints(0);
            labelText.setText(Integer.toString(mViewModel.pilot));
        } else if (parentView.getId() == R.id.fighter_buttons) {
            mViewModel.incPoints(1);
            labelText.setText(Integer.toString(mViewModel.fighter));
        } else if (parentView.getId() == R.id.trader_buttons) {
            mViewModel.incPoints(2);
            labelText.setText(Integer.toString(mViewModel.trader));
        } else if (parentView.getId() == R.id.engineer_buttons) {
            mViewModel.incPoints(3);
            labelText.setText(Integer.toString(mViewModel.engineer));

        }
        remainingText.setText(mViewModel.getRemaining());
    }
}
