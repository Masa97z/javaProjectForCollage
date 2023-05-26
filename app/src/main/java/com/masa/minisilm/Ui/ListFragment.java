package com.masa.minisilm.Ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.masa.minisilm.Data.DataSourse;
import com.masa.minisilm.Data.TaskAdapter;
import com.masa.minisilm.R;
import com.masa.minisilm.databinding.FragmentAddBinding;
import com.masa.minisilm.databinding.FragmentListBinding;

import java.util.ArrayList;


public class ListFragment extends Fragment {
    private FragmentListBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setup();
    }
    public void setup(){ArrayList<DataSourse> taskList = new ArrayList<>();
        TaskAdapter adapter = new TaskAdapter(taskList);
        taskList.add(new DataSourse(1,"43","rdfd","343"));
        taskList.add(new DataSourse(1,"43","rdfd","343"));
    binding.recycle.setAdapter(adapter);}


}