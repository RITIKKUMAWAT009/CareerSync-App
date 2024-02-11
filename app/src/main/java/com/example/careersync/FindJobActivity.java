package com.example.careersync;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.careersync.CustomAdapter.CourseAdapter;
import com.example.careersync.CustomAdapter.FIndJobAdapter;
import com.example.careersync.model.Course;

import java.util.ArrayList;

public class FindJobActivity extends AppCompatActivity {

    RecyclerView recyclerViewJob;
    FIndJobAdapter findJobAdapter;
    RecyclerView recyclerViewCourses, recyclerViewTopCourse, recyclerViewLecture, recyclerViewTopLecture;
    CourseAdapter courseAdapter;
    RecyclerView.Adapter<CourseAdapter.ViewHolder> adapter;
    ImageView imgHome, imgProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_job);
        init();
        ArrayList<Course> jobList = new ArrayList<>();
        jobList.add(new Course("Machine learning", "4", "ml", "100"));
        jobList.add(new Course("Android dev", "5", "android", "200"));
        jobList.add(new Course("web dev", "2", "web", "140"));
        jobList.add(new Course("AI", "1", "ai", "103"));
        jobList.add(new Course("React-native dev", "4", "mobile dev", "100"));
        jobList.add(new Course("React-native dev", "4", "mobile dev", "100"));
        jobList.add(new Course("React-native dev", "4", "mobile dev", "100"));
        jobList.add(new Course("React-native dev", "4", "mobile dev", "100"));
        jobList.add(new Course("Machine learning", "4", "ml", "100"));
        jobList.add(new Course("Machine learning", "4", "ml", "100"));
        jobList.add(new Course("Machine learning", "4", "ml", "100"));
        jobList.add(new Course("Machine learning", "4", "ml", "100"));
        jobList.add(new Course("Machine learning", "4", "ml", "100"));
        jobList.add(new Course("React-native dev", "4", "mobile dev", "100"));
        recyclerViewRecentJob(jobList);
        recyclerViewTrending(jobList);
        recyclerViewApplied(jobList);

        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindJobActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindJobActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    public void init() {
        imgHome = findViewById(R.id.icon_home);
        imgProfile = findViewById(R.id.icon_profile);
    }


    public void recyclerViewRecentJob(ArrayList<Course> courseList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCourses = findViewById(R.id.recyclerViewTop);
        recyclerViewCourses.setLayoutManager(linearLayoutManager);
        adapter = new CourseAdapter(courseList);
        recyclerViewCourses.setAdapter(adapter);
    }

    public void recyclerViewTrending(ArrayList<Course> coursesList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewTopCourse = findViewById(R.id.recyclerViewTop);
        recyclerViewTopCourse.setLayoutManager(linearLayoutManager);
        adapter = new CourseAdapter(coursesList);
        recyclerViewTopCourse.setAdapter(adapter);
    }

    public void recyclerViewApplied(ArrayList<Course> coursesList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewLecture = findViewById(R.id.recyclerViewLecture);
        recyclerViewLecture.setLayoutManager(linearLayoutManager);
        adapter = new CourseAdapter(coursesList);
        recyclerViewLecture.setAdapter(adapter);
    }
}