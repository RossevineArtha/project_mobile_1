package com.rossevine.project_mobile_1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabHost host = (TabHost)findViewById(R.id.tabhost);
        host.setup();

        //Coba Tab1
        TabHost.TabSpec tabProfile = host.newTabSpec("Tab One");
        tabProfile = host.newTabSpec("Tab Profile");
        tabProfile.setIndicator("Profile");
        tabProfile.setContent(R.id.layout1);
        host.addTab(tabProfile);
        setTanggal();

        //Coba Tab2
        TabHost.TabSpec tabLaporan = host.newTabSpec("Tab Two");
        tabLaporan = host.newTabSpec("Tab Laporan");
        tabLaporan.setIndicator("Laporan");
        tabLaporan.setContent(R.id.layout2);
        host.addTab(tabLaporan);

        //Coba Tab3
        TabHost.TabSpec tabHome = host.newTabSpec("Tab three");
        tabHome = host.newTabSpec("Tab Home");
        tabHome.setIndicator("Home");
        tabHome.setContent(R.id.layout3);
        host.addTab(tabHome);
        ////////////////////////////////







        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    public void setTanggal(){
        TextView txtTanggal = findViewById(R.id.textView);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c.getTime());
        txtTanggal.setText("Tanggal : " + formattedDate);

        TextView txtPenghasilan = findViewById(R.id.textView2);
        txtPenghasilan.setText("Rp 50.000.00");
        txtPenghasilan.setTextColor(Color.GREEN);


        TextView txtPengeluwaran = findViewById(R.id.textView3);
        txtPengeluwaran.setText("Rp 50.000.00");
        txtPengeluwaran.setTextColor(Color.RED);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
