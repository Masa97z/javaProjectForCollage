package com.masa.minisilm.Data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.masa.minisilm.R;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {
    ArrayList<DataSourse> taskList;
    public TaskAdapter(ArrayList<DataSourse> taskList) {
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.process_card,parent,false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.title.setText(taskList.get(position).getTitle() + "");
        holder.des.setText(taskList.get(position).getDescription() + "");
        holder.date.setText(taskList.get(position).getDate() + "");
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
}
