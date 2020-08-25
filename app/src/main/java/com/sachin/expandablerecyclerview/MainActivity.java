package com.sachin.expandablerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Capitals> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler_Expandable);


        arrayList.add(new Capitals("India",R.drawable.india,"New Delhi"));
        arrayList.add(new Capitals("Russia",R.drawable.russia,"Moscow"));
        arrayList.add(new Capitals("Israeil",R.drawable.israel,"Jerusalem"));
        arrayList.add(new Capitals("Japan",R.drawable.japan,"Tokyo"));
        arrayList.add(new Capitals("Austraila",R.drawable.australia,"Canbera"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CountryAdapter countryAdapter=new CountryAdapter(this,arrayList);
        recyclerView.setAdapter(countryAdapter);

       // Toast.makeText(this, ""+arrayList.size(), Toast.LENGTH_SHORT).show();

    }
}