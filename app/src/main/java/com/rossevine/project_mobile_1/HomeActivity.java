package com.rossevine.project_mobile_1;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //setTanggal();
    }
    public void setTanggal(){
        TextView txtTanggal = findViewById(R.id.textView);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c.getTime());
        txtTanggal.setText("Tanggal : " + formattedDate);

        TextView txtPenghasilan = findViewById(R.id.textView2);
        txtPenghasilan.setText("Rp 50.000.00");
        txtPenghasilan.setTextColor(Color.CYAN);

    }
}
