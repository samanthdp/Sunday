package com.example.sunday;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.sunday.databinding.ActivityMain3Binding;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    ArrayList arrayList;

    ActivityMain3Binding am3;
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        am3= DataBindingUtil.setContentView(this,R.layout.activity_main3);

        arrayList=new ArrayList();
        arrayList.add("india");
        arrayList.add("uk");
        arrayList.add("usa");
        arrayList.add("aus");
        arrayList.add("japan");
        arrayList.add("russia");
        arrayList.add("india");
        arrayList.add("uk");
        arrayList.add("usa");
        arrayList.add("aus");
        arrayList.add("japan");
        arrayList.add("russia");
        arrayList.add("india");
        arrayList.add("uk");
        arrayList.add("usa");
        arrayList.add("aus");
        arrayList.add("japan");
        arrayList.add("russia");
        arrayList.add("india");
        arrayList.add("uk");
        arrayList.add("usa");
        arrayList.add("aus");
        arrayList.add("japan");
        arrayList.add("russia");
        arrayList.add("india");
        arrayList.add("uk");
        arrayList.add("usa");
        arrayList.add("aus");
        arrayList.add("japan");
        arrayList.add("russia");
        arrayList.add("india");
        arrayList.add("uk");
        arrayList.add("usa");
        arrayList.add("aus");
        arrayList.add("japan");
        arrayList.add("russia");
        arrayList.add("india");
        arrayList.add("uk");
        arrayList.add("usa");
        arrayList.add("aus");
        arrayList.add("japan");
        arrayList.add("russia");
        arrayList.add("india");
        arrayList.add("uk");
        arrayList.add("usa");
        arrayList.add("aus");
        arrayList.add("japan");
        arrayList.add("russia");
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        am3.lv.setAdapter(arrayAdapter);



    }
}