package com.sau.comsci;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.aungpao.t_health.R;

import java.util.ArrayList;

public class ProfileListViewAdapter extends BaseAdapter {
    private Button btnSave;
    private LayoutInflater mInflater;
    private Context context;
    private ActivityProfile control;

    private ArrayList<Profile> listData = new ArrayList<Profile>();

    public ProfileListViewAdapter(ActivityProfile control, ArrayList<Profile> listData) {
        this.control = control;
        this.context = control.getBaseContext();
        this.mInflater = LayoutInflater.from(context);
        this.listData = listData;
    }

    public int getCount() {

        return listData.size();
    }


    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        HolderListAdapter holderListAdapter;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.row_show_profile, null);

            //สร้างตัวเก็บส่วนประกอบของ List แต่ละอัน
            holderListAdapter = new HolderListAdapter();

            //เชื่อมส่วนประกอบต่างๆ ของ List เข้ากับ View
            holderListAdapter.txtName = (TextView) convertView.findViewById(R.id.txtPname);
            holderListAdapter.txtOld = (TextView) convertView.findViewById(R.id.txtPold);
            holderListAdapter.txtWeight = (TextView) convertView.findViewById(R.id.txtPweight);
            holderListAdapter.txtHeight = (TextView) convertView.findViewById(R.id.txtPheight);
            holderListAdapter.txtSex = (TextView) convertView.findViewById(R.id.txtPsex);


            convertView.setTag(holderListAdapter);
        } else {
            holderListAdapter = (HolderListAdapter) convertView.getTag();
        }

        //ดึงข้อมูลจาก listData มาแสดงทีละ position
        final int id = listData.get(position).getId();
        final String name = listData.get(position).getName();
        final int age = listData.get(position).getAge();
        final int weight = listData.get(position).getWeight();
        final int height = listData.get(position).getHeight();
        final String sex = listData.get(position).getSex();

        holderListAdapter.txtName.setText("" + name);
        holderListAdapter.txtOld.setText("" + age);
        holderListAdapter.txtWeight.setText("" + weight);
        holderListAdapter.txtHeight.setText("" + height);
        holderListAdapter.txtSex.setText("" + sex);




        return convertView;
    }
}