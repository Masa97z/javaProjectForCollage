package com.masa.minisilm;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.masa.minisilm.Data.DataSourse;
import com.masa.minisilm.Data.SqlDB;
import com.masa.minisilm.Data.TaskAdapter;

import java.util.ArrayList;

import com.masa.minisilm.databinding.FragmentRecBinding;

public  class recFragment extends Fragment  {
    private FragmentRecBinding binding;
    private SqlDB sqlDB;
    private Fragment currentFragment;

    public recFragment(Context context) {
        sqlDB = new SqlDB(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentRecBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setup();
    }

    public void setup(){

        ArrayList<DataSourse> task = sqlDB.getData();
        TaskAdapter adapter = new TaskAdapter(task);

        binding.recycle.setAdapter(adapter);
    }



}