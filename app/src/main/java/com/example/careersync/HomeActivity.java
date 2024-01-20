package com.example.careersync;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.careersync.CustomAdapter.CourseAdapter;
import com.example.careersync.model.Course;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerViewCourses,recyclerViewTopCourse,recyclerViewLecture,recyclerViewTopLecture;
    CourseAdapter courseAdapter;
    RecyclerView.Adapter<CourseAdapter.ViewHolder> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ArrayList<Course>courseList= new ArrayList<>();
        courseList.add(new Course("Machine learning","4","ml","100"));
        courseList.add(new Course("Android dev","5","android","200"));
        courseList.add(new Course("web dev","2","web","140"));
        courseList.add(new Course("AI","1","ai","103"));
        courseList.add(new Course("React-native dev","4","mobile dev","100"));
        recyclerViewCourseList(courseList);
        recyclerViewTopCourses(courseList);
        recyclerViewLecture(courseList);

    }

    public  void recyclerViewCourseList(ArrayList<Course> courseList){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCourses =findViewById(R.id.recyclerViewCourse);
        recyclerViewCourses.setLayoutManager(linearLayoutManager);
        adapter=new CourseAdapter(courseList);
        recyclerViewCourses.setAdapter(adapter);
    }

    public void recyclerViewTopCourses(ArrayList<Course> coursesList){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewTopCourse=findViewById(R.id.recyclerViewTop);
        recyclerViewTopCourse.setLayoutManager(linearLayoutManager);
        adapter=new CourseAdapter(coursesList);
        recyclerViewTopCourse.setAdapter(adapter);
    }
    public void recyclerViewLecture(ArrayList<Course> coursesList){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewLecture=findViewById(R.id.recyclerViewLecture);
        recyclerViewLecture.setLayoutManager(linearLayoutManager);
        adapter=new CourseAdapter(coursesList);
        recyclerViewLecture.setAdapter(adapter);
    }

}