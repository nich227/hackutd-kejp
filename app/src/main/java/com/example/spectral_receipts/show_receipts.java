package com.example.spectral_receipts;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class show_receipts extends AppCompatActivity {

    private List<File> receipt_json_file_names = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_receipts);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        receipt_json_file_names = new ArrayList<File>(Arrays.asList(new File("/data").listFiles()));
    }

    public String getAllReceiptsData(){
        String toreturn = "";
        if(receipt_json_file_names == null){
            System.err.println("ERROR: show_receipts.receipt_json_file_names was not properly initialized.");
        } else{
            for(File in : receipt_json_file_names) {
                JSONObject input_json = new JSONParser().parse(new FileReader(in));
            }
        }
        return toreturn;
    }

}
