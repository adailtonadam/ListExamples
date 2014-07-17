package br.com.adam.adailton.listexamples;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by ad036950 on 16/07/2014.
 */
public class ExpandableListAdapter extends BaseExpandableListAdapter{

    private List<String> products;
    private Map<String, List<String>> productColors;
    private Activity activity;
    private LayoutInflater inflater;
    // context.getLayoutInflater();

    public ExpandableListAdapter(Activity activity, List<String> products, Map<String, List<String>> productColors) {
        this.activity = activity;
        this.products = products;
        this.productColors = productColors;
        this.inflater = LayoutInflater.from(activity);
    }
    public Object getChild(int groupPosition, int childPosition) {
        return productColors.get(products.get(groupPosition)).get(childPosition);
    }

    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    public int getChildrenCount(int groupPosition) {
        return productColors.get(products.get(groupPosition)).size();
    }

    public Object getGroup(int groupPosition) {
        return products.get(groupPosition);
    }

    public int getGroupCount() {
        return products.size();
    }

    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final String color = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_expandable_list_subitem, null);
        }

        TextView item = (TextView) convertView.findViewById(R.id.adapter_expandable_list_subitem_name);
        item.setText(color);

        convertView.findViewById(R.id.adapter_expandable_list_subitem_name).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(activity.getApplicationContext(),ItemViewActivity.class);
                intent.putExtra("MainText",color);
                activity.startActivity(intent);
             }
        });

        return convertView;
    }

    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        final String product = (String) getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.adapter_expandable_list_item, null);
        }
        TextView nome = (TextView) convertView.findViewById(R.id.adapter_expandable_list_item_name);
        nome.setText(product);


        convertView.findViewById(R.id.adapter_expandable_list_item_name).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity.getApplicationContext(),ItemViewActivity.class);
                intent.putExtra("MainText",product);
                activity.startActivity(intent);
            }
        });

        return convertView;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return super.isEmpty();
    }

}

