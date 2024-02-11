package com.example.careersync;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.careersync.CustomAdapter.CourseAdapter;
import com.example.careersync.model.Course;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerViewCourses, recyclerViewTopCourse, recyclerViewLecture, recyclerViewTopLecture;
    CourseAdapter courseAdapter;
    RecyclerView.Adapter<CourseAdapter.ViewHolder> adapter;
    TextView txUserName;
    ImageView imgJob, imgProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.black));

//        txUserName.setText(userName);
        ArrayList<Course> courseList = new ArrayList<>();
        courseList.add(new Course("Machine learning", "4", "ml", "100"));
        courseList.add(new Course("Android dev", "5", "android", "200"));
        courseList.add(new Course("web dev", "2", "web", "140"));
        courseList.add(new Course("AI", "1", "ai", "103"));
        courseList.add(new Course("React-native dev", "4", "mobile dev", "100"));
        recyclerViewCourseList(courseList);
        recyclerViewTopCourses(courseList);
        recyclerViewLecture(courseList);

        init();
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        if (userName != null) {
            txUserName.setText(userName);
        }
        imgJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, FindJobActivity.class);
                startActivity(intent);
            }
        });
        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

    }

    public void init() {
        imgJob = findViewById(R.id.icon_job);
        imgProfile = findViewById(R.id.icon_profile);
        txUserName = findViewById(R.id.txUserName);

    }


    public void recyclerViewCourseList(ArrayList<Course> courseList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCourses = findViewById(R.id.recyclerViewCourse);
        recyclerViewCourses.setLayoutManager(linearLayoutManager);
        adapter = new CourseAdapter(courseList);
        recyclerViewCourses.setAdapter(adapter);
    }

    public void recyclerViewTopCourses(ArrayList<Course> coursesList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewTopCourse = findViewById(R.id.recyclerViewTop);
        recyclerViewTopCourse.setLayoutManager(linearLayoutManager);
        adapter = new CourseAdapter(coursesList);
        recyclerViewTopCourse.setAdapter(adapter);
    }

    public void recyclerViewLecture(ArrayList<Course> coursesList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewLecture = findViewById(R.id.recyclerViewLecture);
        recyclerViewLecture.setLayoutManager(linearLayoutManager);
        adapter = new CourseAdapter(coursesList);
        recyclerViewLecture.setAdapter(adapter);
    }

}