package ethered.mcc_project;

/**
 * Created by Mitul Champaneri on 4/6/2018.
 */

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;



import java.util.List;

/**
 * Created by Suraj on 20-06-2017.
 * This ${class} is used for
 */

public class MyListAdapter extends ArrayAdapter<MyData> {

    Context context;
    int resource;
    List<MyData> myDatas;


    public MyListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<MyData> objects) {
        super(context, resource, objects);

        this.context=context;
        this.resource=resource;
        this.myDatas=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder=new ViewHolder();

        if (convertView==null){
            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(resource,parent,false);
//just removed my id
        //    viewHolder.id= (TextView) convertView.findViewById(R.id.my_id);
            viewHolder.name= (TextView) convertView.findViewById(R.id.subject);
            viewHolder.minreq= (TextView) convertView.findViewById(R.id.minrequired);

            viewHolder.attended= (TextView) convertView.findViewById(R.id.curratt);
            viewHolder.bunked= (TextView) convertView.findViewById(R.id.currbunk);
            viewHolder.minattend= (TextView) convertView.findViewById(R.id.lec2attend);


            viewHolder.llMain= (LinearLayout) convertView.findViewById(R.id.ll_main);

            convertView.setTag(viewHolder);
        }else {
            try {
                viewHolder = (ViewHolder) convertView.getTag();
            }catch (ClassCastException e){
                e.printStackTrace();
            }
        }

        try {

            MyData myData = myDatas.get(position);

            //viewHolder.id.setText("ID : " + myData.getId());
            viewHolder.name.setText(myData.getName());
            viewHolder.attended.setText(myData.getattended());
            viewHolder.bunked.setText(myData.getbunked());
            viewHolder.llMain.setTag(myData.getId());
        }catch (NullPointerException e){
            e.printStackTrace();
        }

        return convertView;
    }

    private class ViewHolder{
        TextView name,attended,minreq,minattend,bunked;
        LinearLayout llMain;
    }
}
