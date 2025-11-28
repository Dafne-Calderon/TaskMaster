package com.example.taskmaster.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskmaster.R;
import com.example.taskmaster.model.Task;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Task> taskList;

    public TaskAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }

    public void updateData(List<Task> tasks) {
        this.taskList = tasks;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = taskList.get(position);

        holder.tvTitulo.setText(task.getTitle());
        holder.tvCategoria.setText(task.getCategory());
        holder.tvPrioridad.setText("Prioridad: " + task.getPriority());
        holder.cbCompletada.setChecked(task.isCompleted());

        holder.cbCompletada.setOnCheckedChangeListener((buttonView, isChecked) -> {
            task.setCompleted(isChecked);
        });
    }

    @Override
    public int getItemCount() {
        return taskList != null ? taskList.size() : 0;
    }

    static class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitulo, tvCategoria, tvPrioridad;
        CheckBox cbCompletada;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            tvCategoria = itemView.findViewById(R.id.tvCategoria);
            tvPrioridad = itemView.findViewById(R.id.tvPrioridad);
            cbCompletada = itemView.findViewById(R.id.cbCompletada);
        }
    }
}

