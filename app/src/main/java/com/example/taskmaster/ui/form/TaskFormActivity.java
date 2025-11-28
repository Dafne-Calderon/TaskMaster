package com.example.taskmaster.ui.form;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.taskmaster.R;
import com.example.taskmaster.model.Task;

public class TaskFormActivity extends AppCompatActivity {

    private EditText etTitulo;
    private Spinner spnCategoriaForm;
    private RadioGroup rgPrioridad;
    private RatingBar ratingImportancia;
    private CheckBox cbCompletadaForm;
    private Button btnGuardar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_form);

        etTitulo = findViewById(R.id.etTitulo);
        spnCategoriaForm = findViewById(R.id.spnCategoriaForm);
        rgPrioridad = findViewById(R.id.rgPrioridad);
        ratingImportancia = findViewById(R.id.ratingImportancia);
        cbCompletadaForm = findViewById(R.id.cbCompletadaForm);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(v -> guardarTarea());
    }

    private void guardarTarea() {
        String titulo = etTitulo.getText().toString();
        String categoria = spnCategoriaForm.getSelectedItem().toString();

        if (titulo.isEmpty()) {
            etTitulo.setError("Ingrese un título");
            return;
        }

        int prioridad = 1;
        int checkedId = rgPrioridad.getCheckedRadioButtonId();
        if (checkedId != -1) {
            RadioButton rb = findViewById(checkedId);
            String texto = rb.getText().toString();
            if (texto.equalsIgnoreCase("Media")) prioridad = 2;
            else if (texto.equalsIgnoreCase("Alta")) prioridad = 3;
        }

        float rating = ratingImportancia.getRating();
        boolean completada = cbCompletadaForm.isChecked();

        Task nueva = new Task(titulo, categoria, prioridad, rating, completada);

        Toast.makeText(this,
                "Tarea guardada: " + nueva.getTitle(),
                Toast.LENGTH_SHORT).show();

        // Por ahora solo cerramos y volvemos a la lista
        finish();
    }
}

