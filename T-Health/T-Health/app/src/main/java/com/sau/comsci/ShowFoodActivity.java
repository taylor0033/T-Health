package com.sau.comsci;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import com.example.aungpao.t_health.R;

public class ShowFoodActivity extends Activity {

    private FoodDBHelper foodDBHelper;

    private ListView lstShowAllFood;

    private List<Food> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_food);

        foodDBHelper = new FoodDBHelper(ShowFoodActivity.this);

        lstShowAllFood = (ListView) findViewById(R.id.lstShowFood);

        foodList = new ArrayList<Food>();
        foodList = foodDBHelper.showAllFood();

        FoodListViewAdapter adapter = new FoodListViewAdapter(ShowFoodActivity.this,R.layout.row_show_food,foodList);
        lstShowAllFood.setAdapter(adapter);
    }
}
