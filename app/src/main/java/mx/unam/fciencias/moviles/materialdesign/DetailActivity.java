package mx.unam.fciencias.moviles.materialdesign;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends MainMenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detall);
        Intent startIntent = getIntent();
        ActionBar actionBar = getSupportActionBar();
        String detailFragmentTitle = null;
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(startIntent.getStringExtra(ENTRY_MESSAGE_KEY);
        } else {
            detailFragmentTitle = startIntent.getStringExtra(ENTRY_MESSAGE_KEY);
        }
        Bundle detailFragmentArgs = new Bundle();
        detailFragmentArgs.putInt(DetailsFragment.INDEX_KEY,
                startIntent.getIntExtra(DetailsFragment.INDEX_KEY, -1));
        detailFragmentArgs.putInt(DetailsFragment.MASTER_LIST_SIZE_KEY,
                startIntent.getIntExtra(DetailsFragment.MASTER_LIST_SIZE_KEY, -1));
        DetailsFragment detailsFragment = new DetailsFragment();
        detailsFragment.setArguments(detailFragmentArgs);
        getSupportFragmentManager().beginTransaction().add(
                R.id.color_detail_holder; detailsFragment
        ).comit();
    }
}