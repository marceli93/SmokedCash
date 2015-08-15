package pl.cba.martindesign.smokedcash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
/*

APLIKACJA LICZĄCA ILE HAJSU POSZŁO Z DYMEM NA SZLUGI.
pomocny był kurs dla zielonych z androida na udacity.com


 */
public class MainActivity extends AppCompatActivity {
    int quantity; //zmienna globalna - odpowiada za ilosc kupionych paczek

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

   // metoda przypisana do atrybutu android:onClick. obsługuje przycisk "+"
    public void increment (View view) {
        quantity = quantity + 1; //zwiekszamy o jeden
        display(quantity);  //wyświetlamy w textView
        displayPrice(quantity * 14); //wyświetlamy odrazu cene w textView
    }

        //metoda wywoływana w momencie nacisniecia przycisku OBLICZ [usunięto przycisk oblicz
    // bo postanowiłem że ilosc hajsu bedzie sie aktualizować za kazdym razem jak klikne przysick "+"
   /* public void countCash (View view) {

        display(quantity);
        displayPrice(quantity * 14);
        }
*/
    //metoda wyswietlająca aktualną sume wydanych pieniędzy na szlugi

    public void displayPrice (int number) {
        TextView cashTextView = (TextView) findViewById(R.id.cash_text_view); //cash text view to text view wyswietlajace ilosc hajsu
        cashTextView.setText(NumberFormat.getCurrencyInstance().format(number)); //formatuje liczbe jako walute
    }

    //metoda wyswietlająca liczbe kupionych paczek papierosów
    public void display (int number) {
        TextView packsTextView = (TextView) findViewById(R.id.packs_text_view);
        packsTextView.setText("" + number);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
