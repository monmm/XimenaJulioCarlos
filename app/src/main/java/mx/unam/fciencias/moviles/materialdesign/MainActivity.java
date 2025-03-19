package mx.unam.fciencias.moviles.materialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.launch_second_activity);
        button.setOnClickListener(this::launchSecondActivity);
    }

    public void launchSecondActivity(View button){
        startActivity(new Intent(this, SecondActivity.class));
    }
}