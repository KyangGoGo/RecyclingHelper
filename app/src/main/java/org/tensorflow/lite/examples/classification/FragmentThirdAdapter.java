package org.tensorflow.lite.examples.classification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.tensorflow.lite.examples.classification.data.FragementThirdData;

import java.util.ArrayList;

public class FragmentThirdAdapter extends RecyclerView.Adapter<FragmentThirdAdapter.CustomViewHolder> {
    private ArrayList<FragementThirdData> arrayList;
    private TextView visibleText;

    public FragmentThirdAdapter(ArrayList<FragementThirdData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment3_item_list,parent,false);
        CustomViewHolder holder=new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.fnq_questions.setText(arrayList.get(position).getQuestions());

        holder.itemView.setTag(position);
        holder.fnq_answer.setText(arrayList.get(position).getQuestions());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(visibleText!=null)visibleText.setVisibility(View.GONE);
                visibleText=holder.fnq_answer;
                holder.fnq_answer.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null !=arrayList ? arrayList.size():0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView fnq_questions;
        protected TextView fnq_answer;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.fnq_questions=(TextView) itemView.findViewById(R.id.fnq_questions);
            this.fnq_answer=(TextView)itemView.findViewById(R.id.fnq_answer);
        }
    }
}