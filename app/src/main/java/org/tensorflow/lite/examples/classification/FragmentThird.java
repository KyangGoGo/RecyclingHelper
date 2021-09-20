package org.tensorflow.lite.examples.classification;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.tensorflow.lite.examples.classification.data.FragementThirdData;

import java.util.ArrayList;

public class FragmentThird extends Fragment {
    private ArrayList<FragementThirdData> arrayList;
    private FragmentThirdAdapter mainAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private String title;

    public FragmentThird(String title){
        this.title = title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_3p, container, false);

        recyclerView=(RecyclerView) rootView.findViewById(R.id.rd);
        linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList=new ArrayList<>();


        String questionsList[]={"휴지는 재활용이 되나요?","코딩된 종이(광고지,전단지,사진등)는 어떻게 배출 하나요?"
                ,"스프링 등 (철,플라스틱)이 부착된 책자류는 어떻게 배출하나요?","카드 명세서,각종 고지서는 재활용 종이로 배출 가능한가요?"};
        String answerList[]={"휴지는 재활용이 되나요?","코딩된 종이(광고지,전단지,사진등)는 어떻게 배출 하나요?"
                ,"스프링 등 (철,플라스틱)이 부착된 책자류는 어떻게 배출하나요?","카드 명세서,각종 고지서는 재활용 종이로 배출 가능한가요?"};
        for(int i=0;i<questionsList.length;i++){
            FragementThirdData mainData=new FragementThirdData(questionsList[i],answerList[i]);
            arrayList.add(mainData);
        }
        mainAdapter=new FragmentThirdAdapter(arrayList);
        recyclerView.setAdapter(mainAdapter);

        return rootView;
    }
}