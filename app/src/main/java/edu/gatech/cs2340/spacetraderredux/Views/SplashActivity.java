package edu.gatech.cs2340.spacetraderredux.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import edu.gatech.cs2340.spacetraderredux.R;

public class SplashActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final Button button = (Button) findViewById(R.id.newGame);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent activityChangeIntent = new Intent(SplashActivity.this, ConfigurationActivity.class);

                // currentContext.startActivity(activityChangeIntent);

                SplashActivity.this.startActivity(activityChangeIntent);
            }

        });

        if (getIntent().getBooleanExtra("EXIT", false)) {   // To be removed...
            finish();
        }
    }


}
