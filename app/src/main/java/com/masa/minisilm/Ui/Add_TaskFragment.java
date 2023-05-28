package com.masa.minisilm.Ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.masa.minisilm.Data.SqlDB;
import com.masa.minisilm.R;
import com.masa.minisilm.databinding.FragmentAddTaskBinding;

import java.util.Date;


public class Add_TaskFragment extends Fragment {

    private FragmentAddTaskBinding binding;

    private SqlDB sqlDB;

    public Add_TaskFragment(Context context) {
        sqlDB = new SqlDB(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddTaskBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Date date = new Date();
        long timestamp = date.getDate();

        String timestampStr = String.valueOf(timestamp);
        TextInputLayout inputTitle = view.findViewById(R.id.inputTitle);
        TextInputLayout inputDescription = view.findViewById(R.id.description);
        TextInputLayout inputDate = view.findViewById(R.id.inputDate);


        binding.addTaskButton.setOnClickListener(v -> {
            sqlDB.insert(
                    inputTitle.getEditText().getText().toString(),
                    inputDescription.getEditText().getText().toString(),
                    inputDate.getDrawingTime());
            Toast.makeText(requireContext(), timestamp+"", Toast.LENGTH_SHORT).show();
            Log.d("daylog",timestamp+"");
        });



    }




}