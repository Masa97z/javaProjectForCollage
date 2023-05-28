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
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.masa.minisilm.Data.SqlDB;
import com.masa.minisilm.R;
import com.masa.minisilm.databinding.FragmentAddNoteBinding;


public class Add_NoteFragment extends Fragment {
    FragmentAddNoteBinding binding;
    private SqlDB sqlDB;

    public Add_NoteFragment(Context context) {
        sqlDB = new SqlDB(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentAddNoteBinding.inflate(inflater , container , false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextInputLayout inputTitle = view.findViewById(R.id.inputTitle);
        TextInputLayout inputDescription = view.findViewById(R.id.description);


        binding.addBtn.setOnClickListener(v -> {
                    sqlDB.insertNote(
                            inputTitle.getEditText().getText().toString(),
                            inputDescription.getEditText().getText().toString());
                }
        );
    }


}