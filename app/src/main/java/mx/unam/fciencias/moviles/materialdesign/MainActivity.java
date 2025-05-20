package mx.unam.fciencias.moviles.materialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.graphics.Insets;
    import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.preference.PreferenceManager;

public class MainActivity extends MainMenuActivity {

    private Button launchSecondActivityButton;
    private String shareViewTransitionName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        launchSecondActivityButton  = findViewById(R.id.launch_second_activity);
        launchSecondActivityButton.setOnClickListener(this::launchSecondActivity);
    }

    public void launchSecondActivity(View button){
        Intent intent = new Intent(this, SecondActivity.class);
        if(!sharedPreferences.getBoolean(getString(
                R.string.enable_transitions_preference_key),false)){
            startActivity(intent);
            return;
        }
        if (shareViewTransitionName == null) {
            shareViewTransitionName = getString(R.string.shared_button_transitionName);
        }
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this, launchSecondActivityButton, shareViewTransitionName
        );

        resultLauncher.launch(intent, options);
    }
}