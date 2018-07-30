package org.master.utils.bldeapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Gururaj on 7/28/2018.
 */
public class StudAdapater extends RecyclerView.Adapter<ItemViewHolder> {

    List<Student> studentList ;

    public StudAdapater(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view,null, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        Student student = studentList.get(holder.getAdapterPosition());

        holder.image.setImageResource(student.image);
        holder.name.setText(student.getName());
        holder.dob.setText(student.getDob());
    }

    @Override
    public int getItemCount() {
        if(studentList != null){
           return studentList.size();
        }else{
            return  0 ;
        }
    }
}
