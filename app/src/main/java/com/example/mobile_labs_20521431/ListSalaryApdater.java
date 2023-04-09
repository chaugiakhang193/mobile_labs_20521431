package com.example.mobile_labs_20521431;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;



public class ListSalaryApdater extends ArrayAdapter<NetSalary> {

    private Context context;
    private int layoutResourceId;
    private ArrayList<NetSalary> data ;
    private static LayoutInflater inflater = null;

    public ListSalaryApdater(Context context, int layoutResourceId, ArrayList<NetSalary> data) {
        super(context, layoutResourceId, data);
        try{
            this.context = context;
            this.data = data;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        } catch (Exception e) {}
    }

    public int getCount() {
        return data.size();
    }

    public NetSalary getItem(NetSalary position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        public TextView display;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        final ViewHolder holder;
        try {
            if (convertView == null) {
                vi = inflater.inflate(R.layout.item, null);
                holder = new ViewHolder();

                holder.display = (TextView) vi.findViewById(R.id.tvBoth);
                vi.setTag(holder);
            } else {
                holder = (ViewHolder) vi.getTag();
            }



            holder.display.setText(data.get(position).GetBoth());



        } catch (Exception e) {


        }
        return vi;
    }

}
