package br.com.adam.adailton.listexamples;

import android.app.Activity;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.adam.adailton.listexamples.R;

public class ExpandableListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list);
        setAdapter();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.expandable_list, menu);
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
        Map<String, List<String>> productColors =  getProductColors();

        ExpandableListView productsListView = (ExpandableListView) findViewById(R.id.activity_expandable_listview_main);
        TextView emptyTextView = (TextView) findViewById(R.id.activity_expandable_textview_empty);

        if (products.size() != 0) {
            productsListView.setAdapter(new ExpandableListAdapter(this, products,productColors));
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


    private Map<String, List<String>> getProductColors(){
        Map<String, List<String>> productColors =  new HashMap<String, List<String>>();

        ArrayList <String> colors;

        colors = new ArrayList<String>();
        colors.add("Amarelo");
        colors.add("Azul");
        colors.add("Preto");
        productColors.put("Arroz",colors);

        colors = new ArrayList<String>();
        colors.add("Amarelo");
        productColors.put("Banana",colors);

        colors = new ArrayList<String>();
        colors.add("Azul");
        colors.add("Preto");
        productColors.put("Feijão",colors);

        colors = new ArrayList<String>();
        productColors.put("Carne de porco",colors);

        colors = new ArrayList<String>();
        colors.add("Azul");
        colors.add("Vermelho");
        productColors.put("Maça",colors);


        colors = new ArrayList<String>();
        productColors.put("Macarrão",colors);

        colors = new ArrayList<String>();
        colors.add("Azul");
        productColors.put("Maionese",colors);

        colors = new ArrayList<String>();
        productColors.put("Mostarda",colors);

        return productColors;
    }
}
