package br.com.adam.adailton.listexamples;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import br.com.adam.adailton.listexamples.R;

public class SimpleListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);
        setAdapter();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.simple_list, menu);
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


    private void setAdapter() {
        ArrayList<String> products = (ArrayList<String>) getProducts();
        ListView productsListView = (ListView) findViewById(R.id.activity_simple_list_main_list);
        TextView emptyTextView = (TextView) findViewById(R.id.activity_simple_list_textview_empty);
        if (products.size() != 0) {
            productsListView.setAdapter(new SimpleListAdapter(this, products));
            emptyTextView.setVisibility(View.GONE);
        } else {
            productsListView.setVisibility(View.GONE);
        }
    }


    private List<String> getProducts() {
        ArrayList<String> products = new ArrayList<String>();
        products.add("Arroz");
        products.add("Banana");
        products.add("Feijão");
        products.add("Carne de porco");
        products.add("Maça");
        products.add("Macarrão");
        products.add("Maionese");
        products.add("Mostarda");
        return products;
    }
}
