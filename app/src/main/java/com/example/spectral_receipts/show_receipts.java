package com.example.spectral_receipts;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import org.json.*;

import static com.example.spectral_receipts.R.id.receipts_scroll_text;

public class show_receipts extends AppCompatActivity {

    private List<String> receipt_json_file_names = null;
    private List<String> json_data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_receipts);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ((TextView)findViewById(R.id.receipts_scroll_text)).setMovementMethod(new ScrollingMovementMethod());

        if(QRActivity.r == null)
            return;

        AssetManager assets = getAssets();
        String[] files = null;
        try {
             files = assets.list("");
        } catch (IOException e) {
            e.printStackTrace();
        }


        receipt_json_file_names = new ArrayList<>(Arrays.asList(files));

        for (String in : receipt_json_file_names) {
            json_data.add(getAllReceiptsData(assets, in));
        }

        int i = 0;
        for(String json : json_data) {
            ((TextView) findViewById(R.id.receipts_scroll_text)).append(QRActivity.r.toString());
            i++;
        }
    }

    public String getAllReceiptsData(AssetManager manager, String f_name){
        byte[] formArray = new byte[1];
        if(receipt_json_file_names == null){
            System.err.println("ERROR: show_receipts.receipt_json_file_names was not properly initialized.");
        } else{
            try {
                InputStream is;
                is = manager.open(f_name);
                formArray = new byte[is.available()];
                is.read(formArray);
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new String(formArray).replace("{","")
                .replace("},","").replace("}","")
                .replace("[","").replace("]","")
                .replace("_"," ")
                .replace(",","");
    }


}
