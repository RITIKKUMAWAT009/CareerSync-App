package com.example.careersync;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.careersync.CustomAdapter.FIndJobAdapter;
import com.example.careersync.model.Course;

import java.util.ArrayList;

public class FindJobActivity extends AppCompatActivity {

    RecyclerView recyclerViewJob;
    FIndJobAdapter findJobAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_job);
        ArrayList<Course> jobList= new ArrayList<>();
        jobList.add(new Course("Machine learning","4","ml","100"));
        jobList.add(new Course("Android dev","5","android","200"));
        jobList.add(new Course("web dev","2","web","140"));
        jobList.add(new Course("AI","1","ai","103"));
        jobList.add(new Course("React-native dev","4","mobile dev","100"));
        jobList.add(new Course("React-native dev","4","mobile dev","100"));
        jobList.add(new Course("React-native dev","4","mobile dev","100"));
        jobList.add(new Course("React-native dev","4","mobile dev","100"));
        jobList.add(new Course("Machine learning","4","ml","100"));
        jobList.add(new Course("Machine learning","4","ml","100"));
        jobList.add(new Course("Machine learning","4","ml","100"));
        jobList.add(new Course("Machine learning","4","ml","100"));
        jobList.add(new Course("Machine learning","4","ml","100"));
        jobList.add(new Course("React-native dev","4","mobile dev","100"));
        recyclerViewJobList(jobList);
    }

    private void recyclerViewJobList(ArrayList<Course> jobList) {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewJob=findViewById(R.id.recyclerViewJob);
        recyclerViewJob.setLayoutManager(linearLayoutManager);
        findJobAdapter=new FIndJobAdapter(jobList);
        recyclerViewJob.setAdapter(findJobAdapter);
    }
}