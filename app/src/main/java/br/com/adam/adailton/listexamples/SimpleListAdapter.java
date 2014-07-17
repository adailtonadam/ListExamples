package br.com.adam.adailton.listexamples;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ad036950 on 16/07/2014.
 */
public class SimpleListAdapter extends BaseAdapter{

    private LayoutInflater inflater;
    private List<String> products;
    private Activity activity;

    public SimpleListAdapter(Activity activity,
                              List<String> products) {
        super();
        inflater = LayoutInflater.from(activity);
        this.products = products;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View view = convertView;
        view = inflater.inflate(R.layout.adapter_simple_list, parent, false);

        final TextView name = (TextView) view.findViewById(R.id.adapter_simple_list_textview_name);

        name.setText(products.get(position));

        view.findViewById(R.id.adapter_simple_list_textview_name ).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(activity.getApplicationContext(),ItemViewActivity.class);
                        intent.putExtra("MainText",products.get(position));
                        activity.startActivity(intent);
                    }
                });

        return view;
    }

}
