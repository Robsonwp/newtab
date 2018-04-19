/* Rozwiązanie dla rozdział 21., ćwiczenie 2. */
   
package com.java21days.president;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class PresidentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_santa);
    }

    public void processClicks(View display) {
        Intent action = null;
        int id = display.getId();

        switch (id) {
            case (R.id.imageButton):
                action = new Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:202-456-1111"));
                break;
            case (R.id.imageButton2):
                action = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.whitehouse.gov/"));
                break;
            case (R.id.imageButton3):
                action = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("geo:0,0?q=1600 Pennsylvania Ave NW, Washington, DC 20500"));
                    break;
            default:
                break;
            }
        startActivity(action);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Przygotowanie menu; dodaje elementy do paska akcji, jeśli istnieje.
        getMenuInflater().inflate(R.menu.menu_santa, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Obsługa kliknięcia przycisku akcji. Pasek akcji automatycznie
        // obsługuje kliknięcia dla przycisku Główna i w górę, o ile
        // określi się aktywność nadrzędną w AndroidManifest.xml.
        int id = item.getItemId();

        // Obsługa akcji ustawień.
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
