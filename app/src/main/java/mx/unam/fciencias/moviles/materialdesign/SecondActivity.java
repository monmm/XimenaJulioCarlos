package mx.unam.fciencias.moviles.materialdesign;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SecondActivity extends MainMenuActivity {


    InfiniteListAdapter listAdapter;

    //@onCreate metodo que se manda a llamar cuando la lista ya esta construida.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        setContentView(R.layout.activity_second);
        //Hacemos referencia al boton
        Button button = findViewById(R.id.add_to_list_button);
        button.setOnClickListener(this::addListElement);
        RecyclerView infiniteList = findViewById(R.id.infinite_list);
        infiniteList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        infiniteList.setLayoutManager(layoutManager);
        listAdapter = new InfiniteListAdapter(getResources());
        //Agregar elemento nulo para inicializar la lista
        addListElement(null);
        infiniteList.setAdapter(listAdapter);



    }

    //Metodo que responde a los toques del boton.
    public void addListElement(View button){
        listAdapter.addItem();
    }
}