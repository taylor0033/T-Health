package com.sau.comsci;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;

import com.example.aungpao.t_health.R;

public class ExerciseListViewAdapter extends ArrayAdapter<Exercise> {



    private Context context;

    public ExerciseListViewAdapter(Context context, int textViewResourceId, List<Exercise> objects) {
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
        Exercise exercise = getItem(position);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if(convertView == null) {
            convertView = layoutInflater.inflate(R.layout.row_show_exercise, null);
            holder = new Holder();

            holder.txtName = (TextView) convertView.findViewById(R.id.txtName);
            holder.txtCalorie = (TextView) convertView.findViewById(R.id.txtCalorie);
            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();
        }
        holder.txtName.setText(exercise.getEname());
        holder.txtCalorie.setText(exercise.getEcalorie());

        return convertView;
    }


}
