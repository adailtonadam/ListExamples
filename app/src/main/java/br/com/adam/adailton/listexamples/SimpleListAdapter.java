package br.com.adam.adailton.listexamples;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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
    /*    view = inflater.inflate(R.layout.adapter_usuario, parent, false);

        final TextView nome = (TextView) view.findViewById(R.id.adapter_usuario_textview_nome);
        final TextView fone = (TextView) view.findViewById(R.id.adapter_usuario_textview_fone);
        final TextView sex = (TextView) view.findViewById(R.id.adapter_usuario_textview_sex);


        nome.setText(usuarioList.get(position).getNome());
        fone.setText(usuarioList.get(position).getFone());
        if(usuarioList.get(position).getSex() == Usuario.MASCULINO){
            sex.setText(activity.getResources().getString(R.string.activity_user_list_masculino));
        }  else {
            sex.setText(activity.getResources().getString(R.string.activity_user_list_feminino));
        }

        view.findViewById(R.id.adapter_usuario_button_mostrar_usuario ).setOnClickListener(
                new OnClickListener() {

                    @Override
                    public void onClick(View v) {


                        String url = "tel:" + usuarioList.get(position).getFone();
                        Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse(url));
                        activity.startActivity(intent);


                    }
                });

        view.findViewById(R.id.adapter_usuario_layout_contato).setOnClickListener(
                new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(activity,UserPlaceActivity.class);
                        intent.putExtra("userid",usuarioList.get(position).getId());
                        activity.startActivity(intent);
                    }
                });
                */

        return view;
    }

}
