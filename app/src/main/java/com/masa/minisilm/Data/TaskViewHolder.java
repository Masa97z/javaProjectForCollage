package com.masa.minisilm.Data;

import android.view.View;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.masa.minisilm.R;

public class TaskViewHolder extends RecyclerView.ViewHolder {
    public TaskViewHolder( View itemView) {
        super(itemView);
    }
    TextView title = itemView.findViewById(R.id.titleView);
    TextView des = itemView.findViewById(R.id.des);
    TextView date = itemView.findViewById(R.id.date);

}
