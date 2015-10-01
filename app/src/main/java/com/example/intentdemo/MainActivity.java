package com.example.intentdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		final EditText editNombre = (EditText)findViewById(R.id.editNombre);
        Button buttonEnviar = (Button)findViewById(R.id.buttonEnviar);
		buttonEnviar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if(!editNombre.getText().toString().equals("")) {
					Intent intent = new Intent(MainActivity.this, ActivityTwo.class);
					intent.putExtra("nombre", editNombre.getText().toString());
					startActivity(intent);
				} else {
                    /* cuadro de mensaje */
					AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
					dialog.setTitle(R.string.alert_title);
					dialog.setMessage(R.string.alert_message);
					dialog.setPositiveButton(R.string.alert_button, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.cancel();
						}
					});
					AlertDialog alert = dialog.create();
					alert.show();

                    /* Toast */
                    //Toast mensaje = Toast.makeText(MainActivity.this, R.string.alert_message, Toast.LENGTH_SHORT);
                    //mensaje.show();
				}
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
