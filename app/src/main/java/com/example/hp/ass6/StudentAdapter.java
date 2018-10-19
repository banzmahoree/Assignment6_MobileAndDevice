package com.example.hp.ass6;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {
    private Context context;
    private List<Student> studentList;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.student_list_row,viewGroup,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        Student student = studentList.get(position);

        myViewHolder.idTextView.setText(student.getId());
        myViewHolder.nameTextView.setText(student.getName());
        myViewHolder.tracktextView.setText(student.getTrack());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView idTextView;
        public TextView nameTextView;
        public TextView tracktextView;
        public MyViewHolder(@NonNull View view) {
            super(view);
            idTextView = view.findViewById(R.id.text_view_id);
            nameTextView = view.findViewById(R.id.text_view_name);
            tracktextView = view.findViewById(R.id.text_view_track);
        }
    }
    public StudentAdapter(Context context,List<Student> noteList){
        this.context = context;
        this.studentList = noteList;
    }
}
