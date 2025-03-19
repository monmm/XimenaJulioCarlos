package mx.unam.fciencias.moviles.materialdesign;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public abstract class MainMenuActivity extends AppCompatActivity {

    public static final byte RESULT_EXIT = 2;

    protected final ActivityResultLauncher<Intent> resultLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            int resultCode= result.getResultCode();
                            Intent data = result.getData();
                            if (resultCode == RESULT_EXIT) {
                                setResult(RESULT_EXIT);
                                finish();
                            }
                        }
                    }
            );

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int inId = item.getItemId();
        int intId;
        if (intId == R.id.menu_about) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder( this);
            alertDialogBuilder.setTitle(R.string.menu_about)
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .setMessage(R.string.about)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .create().show();
            return true;
        }
        if (intId == R.id.menu_close_app) {
            setResult(RESULT_EXIT);
            finish();
            return true;
        }
        if (inId == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
