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


public class ShowExerciseActivity extends Activity {

    private ExerciseDBHelper exerciseDBHelper;

    private ListView lstShowAllExercise;

    private List<Exercise> exerciseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_exercise);

        exerciseDBHelper = new ExerciseDBHelper(ShowExerciseActivity.this);

        lstShowAllExercise = (ListView) findViewById(R.id.lstShowExercise);

        exerciseList = new ArrayList<Exercise>();
        exerciseList = exerciseDBHelper.showAllExercise();

        ExerciseListViewAdapter adapter = new ExerciseListViewAdapter(ShowExerciseActivity.this,R.layout.row_show_exercise,exerciseList);
        lstShowAllExercise.setAdapter(adapter);


    }
    }

