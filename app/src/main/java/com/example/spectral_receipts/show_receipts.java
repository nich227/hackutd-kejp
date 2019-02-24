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
import org.json.*;

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
            try {
                for (File in : receipt_json_file_names) {
                    JSONObject json_obj = new JSONObject(in.getName());
                    toreturn +="New Receipt from "
                             + json_obj.getString("time_of_purchase")
                             + ":\nIdentifier: "
                             + json_obj.getString("identifier")
                             + "\nVendor: "
                             + json_obj.getString("vendor")
                             + "\nAddress: "
                             + json_obj.getString("address")
                             + "\nPhone: "
                             + json_obj.getString("phone")
                             + "\nPerson: "
                             + json_obj.getString("person")
                             + "\nItems:";
                   // for()
                }
            } catch(JSONException jse){
                jse.printStackTrace();
                System.err.println("Error: JSON Exception in show_receipts.getAllReceiptsData()");
            }
        }
        return toreturn;
    }

}
