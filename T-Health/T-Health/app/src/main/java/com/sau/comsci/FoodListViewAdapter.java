package com.sau.comsci;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.aungpao.t_health.R;

import java.util.List;

public class FoodListViewAdapter extends ArrayAdapter<Food> {

    private Context context;

    public FoodListViewAdapter(Context context, int textViewResourceId, List<Food> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
    }


    public class Holder {
        TextView txtName;
        TextView txtCalorie;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Holder holder = null;
        Food food = getItem(position);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if(convertView == null) {
            convertView = layoutInflater.inflate(R.layout.row_show_food, null);
            holder = new Holder();

            holder.txtName = (TextView) convertView.findViewById(R.id.txtName);
            holder.txtCalorie = (TextView) convertView.findViewById(R.id.txtCalorie);
            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();
        }
        holder.txtName.setText(food.getFname());
        holder.txtCalorie.setText(food.getFcalorie());

        return convertView;
    }


}

