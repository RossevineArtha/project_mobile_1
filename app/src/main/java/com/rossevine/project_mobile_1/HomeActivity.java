package com.rossevine.project_mobile_1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HomeActivity extends AppCompatActivity {
    Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        ButterKnife.bind(this);
        buttonAdd = findViewById(R.id.buttonAdd12);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("heheh");
            }
        });
        setTanggal();
    }

//    @OnClick(R.id.buttonAdd)
//    void ButtonAdd(){
//        CharSequence pilihan[] = new CharSequence[] {"Pemasukan","Pengeluwaran"};
//
//        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle(" Cek 1");
//        builder.setItems(pilihan, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                System.out.println(builder.getContext().toString());
//                System.out.println(builder.getContext().toString());
//            }
//        });
//        builder.show();
//    }
//
//    public void ayeybutton(View view){
//        System.out.println("asdasdad");
//    }
////    public void buttonOnClick(View view){
////        System.out.println("asdasdada");
////    }
public void setTanggal(){
    TextView txtTanggal = findViewById(R.id.textView2);
    Calendar c = Calendar.getInstance();
    SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
    String formattedDate = df.format(c.getTime());
    txtTanggal.setText("Tanggal : " + formattedDate);

    TextView txtPenghasilan = findViewById(R.id.textView);
    txtPenghasilan.setText("Rp 50.000.00");
    txtPenghasilan.setTextColor(Color.GREEN);


    TextView txtPengeluwaran = findViewById(R.id.textView3);
    txtPengeluwaran.setText("Rp 50.000.00");
    txtPengeluwaran.setTextColor(Color.RED);


}
}
