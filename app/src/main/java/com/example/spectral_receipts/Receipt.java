package com.example.spectral_receipts;

import org.json.JSONArray;
import org.json.JSONException;

public class Receipt {
    protected String time, vendor, address, phone, person, payment_method, payment_details, extra_details;
    protected JSONArray items;
    protected String total_before_tax, tax, total_w_tax;

    //Constructor that takes in all the parameters from the json file
    Receipt(String t, String v, String add, String pho, String per, String payM, String payD, String extraD, JSONArray i, String tot, String ta, String totW) {
        this.time = t;
        this.vendor = v;
        this.address = add;
        this.phone = pho;
        this.person = per;
        this.payment_method = payM;
        this.payment_details = payD;
        this.extra_details = extraD;
        this.items = i;
        this.total_before_tax = tot;
        this.tax = ta;
        this.total_w_tax = totW;
    }

    public String toString(){
        String toreturn = vendor
                + "\nPhone: " + phone
                + "\nAddress: " + address
                + "\nDate: " + time
                + "\n" + person
                + "Items: \n";
        for (int i = 0; i < items.length(); i++) {
            try {
                toreturn += "\n"
                        + "\nName: " + items.getJSONObject(i).getString("name")
                        + "\nQuantity: " + items.getJSONObject(i).getString("quantity")
                        + "\nPrice Each: " + items.getJSONObject(i).getString("priceeach")
                        + "\nTotal Cost for Item: " + items.getJSONObject(i).getString("totalcost");
            } catch(JSONException jse){
                jse.printStackTrace();
                System.err.println("ERROR in Receipt.toString: JSONException");
            }
        }
        toreturn +="\n"
                + "Total Before Tax: " + total_before_tax
                + "Tax: " + tax
                + "Total With Tax: " + total_w_tax + "\n\n";
    }
    
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getPayment_details() {
        return payment_details;
    }

    public void setPayment_details(String payment_details) {
        this.payment_details = payment_details;
    }

    public String getExtra_details() {
        return extra_details;
    }

    public void setExtra_details(String extra_details) {
        this.extra_details = extra_details;
    }

    public JSONArray getItems() {
        return items;
    }

    public void setItems(JSONArray items) {
        this.items = items;
    }

    public String getTotal_before_tax() {
        return total_before_tax;
    }

    public void setTotal_before_tax(String total_before_tax) {
        this.total_before_tax = total_before_tax;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTotal_w_tax() {
        return total_w_tax;
    }

    public void setTotal_w_tax(String total_w_tax) {
        this.total_w_tax = total_w_tax;
    }
}