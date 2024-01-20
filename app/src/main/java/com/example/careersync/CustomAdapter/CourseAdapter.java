package com.example.careersync.CustomAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.careersync.R;
import com.example.careersync.model.Course;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder>{
    ArrayList<Course>courseList;
    public CourseAdapter(ArrayList<Course> courseList){
        this.courseList=courseList;
    }
    @NonNull
    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_courses,parent,false);
    return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.ViewHolder holder, int position) {
        holder.courseName.setText(courseList.get(position).getCourseName());
        holder.price.setText("price: "+courseList.get(position).getPrice()+"$");
        holder.type.setText("type: "+courseList.get(position).getType());
                holder.rating.setText("rating: "+courseList.get(position).getRating());
    }

    @Override
    public int getItemCount() {
       return courseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
ConstraintLayout mainLayout;
TextView courseName;
TextView type;
TextView price;
TextView rating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mainLayout=itemView.findViewById(R.id.constraintLayout2);
courseName=itemView.findViewById(R.id.txCourseName);
type=itemView.findViewById(R.id.txCourseType);
price=itemView.findViewById(R.id.txCoursePrice);
rating=itemView.findViewById(R.id.txRating);

        }
    }
}
