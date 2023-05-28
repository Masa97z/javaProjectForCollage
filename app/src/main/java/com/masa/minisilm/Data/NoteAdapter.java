package com.masa.minisilm.Data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.masa.minisilm.R;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {

    ArrayList<NoteSourse> noteList;
    public NoteAdapter(@Nullable ArrayList<NoteSourse> noteList  ) {
        this.noteList = noteList;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notecard,parent,false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.title.setText(noteList.get(position).getTitle() + "");
        holder.des.setText(noteList.get(position).getDescription() + "");
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }
}
