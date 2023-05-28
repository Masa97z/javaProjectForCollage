package com.masa.minisilm.Data;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.masa.minisilm.R;
import com.masa.minisilm.Ui.CardDone;
import com.masa.minisilm.recFragment;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    Fragment currentFragment;
    ArrayList<DataSourse> taskList;
    public TaskAdapter(@Nullable ArrayList<DataSourse> taskList  ) {
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.process_card,parent,false);
        return new TaskViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.title.setText(taskList.get(position).getTitle() + "");
        holder.des.setText(taskList.get(position).getDescription() + "");
        holder.date.setText(taskList.get(position).getDate() + "");

        holder.itemView.setOnClickListener(v -> {


            holder.itemView.setBackgroundColor(R.color.sec1);
        });

    }




    @Override
    public int getItemCount() {
        return taskList.size();
    }
}
