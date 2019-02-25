package edu.gatech.cs2340.spacetraderredux.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.gatech.cs2340.spacetraderredux.Model.Difficulty;
import edu.gatech.cs2340.spacetraderredux.Model.GameInstance;
import edu.gatech.cs2340.spacetraderredux.Model.Player;
import edu.gatech.cs2340.spacetraderredux.R;

public class SuccessView extends AppCompatActivity {
    private GameInstance gameInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_view);
        Intent intent = getIntent();
        TextView successText = (TextView) findViewById(R.id.successTextView);
        successText.setText(intent.getStringExtra("playerData"));
        final Button exitButton = (Button) findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SplashActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);

            }

        });

        Bundle gameData = intent.getBundleExtra("gameData");
        int[] stats = gameData.getIntArray("playerStats");
        String playerName = gameData.getString("playerName");
        int difficultyValue = gameData.getInt("difficulty");
        Difficulty difficulty = Difficulty.values()[difficultyValue];
        gameInstance = new GameInstance(new Player(playerName, stats[0], stats[1], stats[2], stats[3]), difficulty);
        gameInstance.getUniverse().dumpToLog();

    }
}
