package com.example.taskmaster.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskmaster.R;
import com.example.taskmaster.adapter.TaskAdapter;
import com.example.taskmaster.model.Task;
import com.example.taskmaster.ui.form.TaskFormActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerTareas;
    private TaskAdapter taskAdapter;
    private Spinner spinnerCategoria;
    private Button btnAgregar;

    // Para la demo: lista de ejemplo
    private List<Task> allTasks = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerTareas = findViewById(R.id.recyclerTareas);
        spinnerCategoria = findViewById(R.id.spinnerCategoria);
        btnAgregar = findViewById(R.id.btnAgregar);

        recyclerTareas.setLayoutManager(new LinearLayoutManager(this));

        // Datos de ejemplo
        allTasks.add(new Task("Estudiar Android", "Estudios", 3, 4.5f, false));
        allTasks.add(new Task("Enviar correo trabajo", "Trabajo", 2, 3.0f, true));

        taskAdapter = new TaskAdapter(allTasks);
        recyclerTareas.setAdapter(taskAdapter);

        btnAgregar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TaskFormActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        taskAdapter.notifyDataSetChanged();
    }
}
