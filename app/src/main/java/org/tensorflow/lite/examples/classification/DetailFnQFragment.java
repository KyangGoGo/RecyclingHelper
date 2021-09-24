package org.tensorflow.lite.examples.classification;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.tensorflow.lite.examples.classification.adapter.FnQFragmentAdapter;
import org.tensorflow.lite.examples.classification.data.Data;
import org.tensorflow.lite.examples.classification.data.FragementThirdData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DetailFnQFragment extends Fragment {
    private ArrayList<FragementThirdData> arrayList;
    private FnQFragmentAdapter mainAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private Data data;

    public DetailFnQFragment(Data data) {
        this.data = data;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.detail_fnq_fragment, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.rd);
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();

        StringBuffer sb = new StringBuffer();
        try {
            InputStream is = inflater.getContext().getAssets().open("questions.json");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            JSONObject json = new JSONObject(sb.toString());

            JSONArray jsonArray = json.getJSONArray(getQuestions(data));
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                FragementThirdData mainData = new FragementThirdData(jsonObject.get("question").toString(), jsonObject.get("answer").toString());
                arrayList.add(mainData);
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        mainAdapter = new FnQFragmentAdapter(arrayList);
        recyclerView.setAdapter(mainAdapter);

        return rootView;
    }

    public String getQuestions(Data data) {
        String tem = null;
        switch (data.getClassification()) {
            case "비닐류":
                tem = "plastic_bag";
                break;
            case "폐스티로폼":
                tem = "styrofoam";
                break;
            case "유리병류":
                tem = "glass";
                break;
            case "종이류":
                tem = "paper";
                break;
            case "캔류":
                tem = "can";
                break;
            case "폐전지":
                tem = "battery";
                break;
            case "플라스틱류":
                tem = "plastic";
                break;
            case "형광등":
                tem = "lamp";
                break;
        }
        return tem;
    }
}