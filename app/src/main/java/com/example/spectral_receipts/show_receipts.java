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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_receipts);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ((TextView)findViewById(receipts_scroll_text)).setMovementMethod(new ScrollingMovementMethod());

        AssetManager assets = getAssets();
        String[] files = null;
        try {
             files = assets.list("");
        } catch (IOException e) {
            e.printStackTrace();
        }


        receipt_json_file_names = new ArrayList<>(Arrays.asList(files));

        ((TextView)findViewById(receipts_scroll_text)).setText(this.getAllReceiptsData(assets));
    }

    public String getAllReceiptsData(AssetManager manager){
        byte[] formArray = new byte[1];
        if(receipt_json_file_names == null){
            System.err.println("ERROR: show_receipts.receipt_json_file_names was not properly initialized.");
        } else{
            try {
                InputStream is;
                for (String in : receipt_json_file_names) {
                     is = manager.open(in);
                     formArray = new byte[is.available()];
                     is.read(formArray);
                     is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new String(formArray);
    }

}
