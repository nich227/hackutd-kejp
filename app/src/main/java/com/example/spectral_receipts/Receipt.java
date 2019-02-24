package com.example.spectral_receipts;

//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

public class Receipt {
    protected String time, vendor, address, phone, person, payment_method, payment_details, extra_details, id;
    protected String[] items;
    protected double total_before_tax, tax, total_w_tax;

    //DatabaseReference qrCode;

    //Constructor that takes in all the parameters from the json file
    Receipt(String t, String v, String add, String pho, String per, String payM, String payD, String extraD, String[] i, double tot, double ta, double totW, String iD) {
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
        this.id = iD;
        //qrCode = FirebaseDatabase.getInstance().getReference();

        //qrCode.push();
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

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public double getTotal_before_tax() {
        return total_before_tax;
    }

    public void setTotal_before_tax(double total_before_tax) {
        this.total_before_tax = total_before_tax;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal_w_tax() {
        return total_w_tax;
    }

    public void setTotal_w_tax(double total_w_tax) {
        this.total_w_tax = total_w_tax;
    }
}
