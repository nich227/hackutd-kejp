package com.example.spectral_receipts;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

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

        ((TextView)findViewById(R.id.receipts_scroll_text)).setText(this.getAllReceiptsData());


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
                             + "\nItems:\n";
                    JSONArray items = json_obj.getJSONArray("items");
                    for(int i = 0; i < items.length(); i++){
                        JSONObject item_obj = items.getJSONObject(i);
                        toreturn += "\n"+item_obj.getString("name")
                                   +"\nquantity:"
                                   +item_obj.getString("quantity")
                                   +"\nprice per item:"
                                   +item_obj.getString("priceeach")
                                   +"\ntotal cost:"
                                   +item_obj.getString("totalcost")
                                   +"\n";
                    }
                    toreturn += "total before tax: "
                             +  json_obj.getString("total_before_tax")
                             +  "\ntax: "
                             +  json_obj.getString("tax")
                             +  "\ntotal with tax: "
                             +  json_obj.getString("total_with_tax")
                             +  "\npayment method: "
                             +  json_obj.getString("payment_method")
                             +  "\npayment details: "
                             +  json_obj.getString("payment_details")
                             +  "\nextra details: "
                             +  json_obj.getString("extra_details")
                             +  "\n";
                }
            } catch(JSONException jse){
                jse.printStackTrace();
                System.err.println("Error: JSON Exception in show_receipts.getAllReceiptsData()");
            }
        }
        return toreturn;
    }

}
