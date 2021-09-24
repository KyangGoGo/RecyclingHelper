package org.tensorflow.lite.examples.classification.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.tensorflow.lite.examples.classification.R;
import org.tensorflow.lite.examples.classification.data.FragementThirdData;

import java.util.ArrayList;

public class FnQFragmentAdapter extends RecyclerView.Adapter<FnQFragmentAdapter.CustomViewHolder> {
    private ArrayList<FragementThirdData> arrayList;
    private VisibleData visibleData;


    public FnQFragmentAdapter(ArrayList<FragementThirdData> arrayList) {
        this.arrayList = arrayList;
        this.visibleData=new VisibleData();
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_fnq_item_list,parent,false);
        CustomViewHolder holder=new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        holder.itemView.setTag(position);
        holder.fnq_questions.setText(arrayList.get(position).getQuestions());
        holder.fnq_answer.setText(arrayList.get(position).getAnswer());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!visibleData.isEmpty()){
                    if(visibleData.getVisibleText()!=holder.fnq_answer){
                        visibleData.getVisibleText().setVisibility(View.GONE);
                        visibleData.getVisibleImage().setVisibility(View.GONE);
                    }
                    else if(visibleData.getVisibleText().getVisibility()==View.VISIBLE){
                        visibleData.getVisibleText().setVisibility(View.GONE);
                        visibleData.getVisibleImage().setVisibility(View.GONE);
                        return;
                    }
                }
                holder.fnq_answer.setVisibility(View.VISIBLE);
                holder.fnq_image.setVisibility(View.VISIBLE);
                visibleData.setVisible(holder.fnq_answer,holder.fnq_image);
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
        protected ImageView fnq_image;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.fnq_questions=(TextView) itemView.findViewById(R.id.fnq_questions);
            this.fnq_answer=(TextView)itemView.findViewById(R.id.fnq_answer);
            this.fnq_image=itemView.findViewById(R.id.fnq_answer_down);
        }
    }
    public class VisibleData{
        private TextView visibleText;
        private ImageView visibleImage;

        public boolean isEmpty(){
            if(visibleText==null || visibleImage==null){
                return true;
            }
            return false;
        }

        public void setVisible(TextView visibleText,ImageView visibleImage) {
            this.visibleText=visibleText;
            this.visibleImage = visibleImage;
        }

        public TextView getVisibleText() {
            return visibleText;
        }

        public ImageView getVisibleImage() {
            return visibleImage;
        }


    }
}