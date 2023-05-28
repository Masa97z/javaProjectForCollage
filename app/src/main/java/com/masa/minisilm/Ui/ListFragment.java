package com.masa.minisilm.Ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.masa.minisilm.Data.SqlDB;
import com.masa.minisilm.Data.TaskAdapter;
import com.masa.minisilm.R;
import com.masa.minisilm.databinding.FragmentListBinding;

import com.masa.minisilm.recFragment;


public class ListFragment extends Fragment {
    private FragmentListBinding binding;
    private SqlDB sqlDB;

    TaskAdapter adapter ;
    private Fragment currentFragment;

    public ListFragment(Context context) {
        sqlDB = new SqlDB(context);
    }
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

        adapter = new TaskAdapter(null);
        currentFragment = new recFragment(requireContext());
        getChildFragmentManager().beginTransaction()
                .add(R.id.listfrv, currentFragment)
                .commit();
        changeTask();


    }

    public void changeTask() {
        binding.processBtn.setOnClickListener(v -> {
            currentFragment = new recFragment(requireContext());
            getChildFragmentManager().beginTransaction()
                    .replace(R.id.listfrv, currentFragment)
                    .commit();
        });
        binding.doneBtn.setOnClickListener(v -> {
            currentFragment = new CardDone();
            getChildFragmentManager().beginTransaction()
                    .replace(R.id.listfrv, currentFragment)
                    .commit();
        });
        binding.deadBtn.setOnClickListener(v -> {
            currentFragment = new DeadCard();
            getChildFragmentManager().beginTransaction()
                    .replace(R.id.listfrv, currentFragment)
                    .commit();
        });
    }





}