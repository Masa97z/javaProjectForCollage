package com.masa.minisilm.Ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.masa.minisilm.Data.DataSourse;
import com.masa.minisilm.Data.NoteAdapter;
import com.masa.minisilm.Data.NoteSourse;
import com.masa.minisilm.Data.SqlDB;
import com.masa.minisilm.Data.TaskAdapter;
import com.masa.minisilm.R;
import com.masa.minisilm.databinding.FragmentHomeBinding;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;

    private SqlDB sqlDB;
    public HomeFragment(Context context) {
        sqlDB = new SqlDB(context);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater,container , false);




        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.cart.pieChart.addPieSlice(new PieModel("done", 15, Color.parseColor("#10BAA5")));
        binding.cart.pieChart.addPieSlice(new PieModel("process", 25, Color.parseColor("#61FFB74B")));
        binding.cart.pieChart.addPieSlice(new PieModel("dead", 35, Color.parseColor("#52E21717")));

        binding.cart.pieChart.startAnimation();

        setup();
    }

    private void setup(){

        ArrayList<DataSourse> task = sqlDB.getData();
        TaskAdapter adapter = new TaskAdapter(task);
        ArrayList<NoteSourse> note= sqlDB.getDataNote();
        NoteAdapter noteAdapter = new NoteAdapter(note);
        binding.ress.setAdapter(adapter);
        binding.recNote.setAdapter(noteAdapter);
    }
}