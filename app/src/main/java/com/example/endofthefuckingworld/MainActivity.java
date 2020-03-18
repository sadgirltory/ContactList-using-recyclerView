package com.example.endofthefuckingworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ExampleDialog.ExampleDialogListerner {
    private static final String TAG = "MainActivity";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mPhoneNum = new ArrayList<>();
    Button Addbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Addbtn = findViewById(R.id.btn);
        Addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();

            }
        });


        Log.d(TAG,"on create: started;");
        initImageBitmaps();

    }

    private void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(),"exampleDialog");
    }

    @Override
    public void applyTexts(String username, String phonenumber) {
                mNames.add(username);
                mPhoneNum.add(phonenumber);
                recyclerView();

    }

    private void initImageBitmaps(){
        Log.d(TAG,"initimages");

    }
    private void recyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerViewAdapter adapter = new recyclerViewAdapter(mNames,mPhoneNum,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
