package br.com.adam.adailton.listexamples;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import java.util.List;
import java.util.Map;

/**
 * Created by ad036950 on 16/07/2014.
 */
public class ExpandableListAdapter extends BaseExpandableListAdapter{

    private List<String> products;
    private Map<String, List<String>> productColors;
    private Activity context;
    private LayoutInflater inflater;
    // context.getLayoutInflater();

    public ExpandableListAdapter(Activity context, List<String> products, Map<String, List<String>> productColors) {
        this.context = context;
        this.products = products;
        this.productColors = productColors;
        this.inflater = LayoutInflater.from(context);
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
        final String product = (String) getGroup(groupPosition);

/*
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_usuario_place_item, null);
        }

        TextView item = (TextView) convertView.findViewById(R.id.adapter_usuario_places_item_textview_nome);
        item.setText(local.getNome());

        convertView.findViewById(R.id.adapter_usuario_places_item_textview_nome).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                UsuarioLocalDao dao = new UsuarioLocalDao(context);
                UsuarioLocal item = dao.getIdByUserLocal(local.getId(),usuario.getId());
                if(item == null){
                    return;
                }
                Intent intent = new Intent(context,PlaceViewByUserActivity.class);
                intent.putExtra("userlocalid",item.getId());
                context.startActivity(intent);

            }
        });
        */

        return convertView;
    }

    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        final String product = (String) getGroup(groupPosition);
      /*  if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.adapter_usuario_places, null);
        }
        TextView nome = (TextView) convertView.findViewById(R.id.adapter_usuario_places_textview_nome);
        nome.setText(usuario.getNome());
        TextView fone = (TextView) convertView.findViewById(R.id.adapter_usuario_places_textview_fone);
        fone.setText(usuario.getFone());
        TextView sex = (TextView) convertView.findViewById(R.id.adapter_usuario_places_textview_sex);
        if (usuario.getSex() == Usuario.MASCULINO) {
            sex.setText(context.getResources().getString(R.string.activity_user_list_masculino));
        } else {
            sex.setText(context.getResources().getString(R.string.activity_user_list_feminino));
        }



        convertView.findViewById(R.id.adapter_usuario_places_layout_contato_imagem).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String url = "tel:" + usuario.getFone();
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(url));
                context.startActivity(intent);
            }
        });

        convertView.findViewById(R.id.adapter_usuario_places_layout_contato).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent intent = new Intent(context, UserPlaceActivity.class);
                intent.putExtra("userid", usuario.getId());
                context.startActivity(intent);
            }
        });
*/
        return convertView;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return super.isEmpty();
    }

}

