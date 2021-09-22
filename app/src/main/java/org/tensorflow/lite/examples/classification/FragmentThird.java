package org.tensorflow.lite.examples.classification;


import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.tensorflow.lite.examples.classification.data.FragementThirdData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

        StringBuffer sb=new StringBuffer();
        try {
            InputStream is = inflater.getContext().getAssets().open("questions.json");
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br=new BufferedReader(isr);
            String line=br.readLine();
            while(line!=null){
                sb.append(line);
                line=br.readLine();
            }
            JSONObject json=new JSONObject(sb.toString());

            JSONArray jsonArray=json.getJSONArray(getQuestions(title));
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=(JSONObject) jsonArray.get(i);
                FragementThirdData mainData=new FragementThirdData(jsonObject.get("question").toString(),jsonObject.get("answer").toString());
                arrayList.add(mainData);
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }


        mainAdapter=new FragmentThirdAdapter(arrayList);
        recyclerView.setAdapter(mainAdapter);

        return rootView;
    }

    public String getQuestions(String title){
        String tem=null;
        switch (title){
            case "고철":
                tem="can";
                break;
            case "비닐":
                tem="plastic_bag";
                break;
            case "스티로폼":
                tem="styrofoam";
                break;
            case "유리병":
                tem="glass";
                break;
            case "종이":
                tem="paper";
                break;
            case "캔류":
                tem="can";
                break;
            case "폐전지":
                tem="battery";
                break;
            case "플라스틱류":
                tem="plastic";
                break;
            case "형광등":
                tem="can";
                break;
        }
        return tem;
    }
}