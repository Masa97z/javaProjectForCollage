package com.masa.minisilm.Ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.masa.minisilm.Data.SqlDB;
import com.masa.minisilm.R;
import com.masa.minisilm.databinding.FragmentAddBinding;


public class AddFragment extends Fragment {

    private FragmentAddBinding binding;
    private Fragment currentFragment;
    private SqlDB sqlDB ;
    public AddFragment(Context context){
        sqlDB = new SqlDB(context);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        currentFragment = new Add_TaskFragment(requireContext());
        getChildFragmentManager().beginTransaction()
                .replace(R.id.fragmentadd, currentFragment)
                .commit();

        binding.addTask.setOnClickListener(v -> {
            currentFragment = new Add_TaskFragment(requireContext());
            getChildFragmentManager().beginTransaction()
                    .replace(R.id.fragmentadd, currentFragment)
                    .commit();
        });
        binding.addNote.setOnClickListener(v -> {

            currentFragment = new Add_NoteFragment(requireContext());
            getChildFragmentManager().beginTransaction()
                    .replace(R.id.fragmentadd, currentFragment)
                    .commit();
        });
    }
}