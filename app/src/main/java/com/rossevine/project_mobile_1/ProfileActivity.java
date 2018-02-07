package com.rossevine.project_mobile_1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonMasukanPengeluwaran)
    public void MunculTampilanAddMasPe(){
        final CharSequence pilihan[] = new CharSequence[] {"Pemasukan","Pengeluwaran"};

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Pemasukan/Pengeluwaran");
        builder.setItems(pilihan, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.out.println(pilihan[i]);
                System.out.println("heheh");
                if(pilihan[i].equals("Pemasukan")){
                    Intent intent = new  Intent( ProfileActivity.this, AddPemasukanActivity.class);
                    startActivity(intent);
                }
                else if(pilihan[i].equals("Pengeluwaran")){
                    Intent intent = new  Intent( ProfileActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        });
        builder.show();
    }
    @OnClick(R.id.buttonUbahPassword)
    public void tampilanUbahPassword(){
        Intent intent = new  Intent( ProfileActivity.this, UbahPassword.class);
        startActivity(intent);
    }

    @OnClick(R.id.buttonAlokasiData)
    public void buttonAlokasiDataOnClick(){
        Intent intent = new  Intent( ProfileActivity.this, AlokasiDanaActivity.class);
        startActivity(intent);
    }

}
