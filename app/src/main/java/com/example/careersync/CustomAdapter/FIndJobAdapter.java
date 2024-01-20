package com.example.careersync.CustomAdapter;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.careersync.R;
import com.example.careersync.model.Course;

import java.util.ArrayList;

public class FIndJobAdapter extends RecyclerView.Adapter<FIndJobAdapter.ViewHolder> {

    private final ArrayList<Course> jobList;

    public FIndJobAdapter(ArrayList<Course> jobList) {
        this.jobList = jobList;
    }

    @NonNull
    @Override
    public FIndJobAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_job, parent, false);
        return new FIndJobAdapter.ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull FIndJobAdapter.ViewHolder holder, int position) {
        holder.JobName.setText(jobList.get(position).getCourseName());
        holder.salary.setText("salary: " + jobList.get(position).getPrice() + "$");
        holder.type.setText("type: " + jobList.get(position).getType());
        holder.rating.setText("rating: " + jobList.get(position).getRating());
//        holder.mainLayout.setBackgroundColor(000000);
    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout mainLayout;
        TextView JobName;
        TextView type;
        TextView salary;
        TextView rating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mainLayout = itemView.findViewById(R.id.constraintLayout2);
           JobName = itemView.findViewById(R.id.txCourseName);
            type = itemView.findViewById(R.id.txCourseType);
            salary = itemView.findViewById(R.id.txCoursePrice);
            rating = itemView.findViewById(R.id.txRating);

        }
    }
}
