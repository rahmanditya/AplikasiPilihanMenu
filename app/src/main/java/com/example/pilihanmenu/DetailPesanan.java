package com.example.pilihanmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class DetailPesanan extends AppCompatActivity {
    private ImageView gambarMasuk;
    private Button plusItem,minusItem,pesanDetail;
    private TextView nmMasuk,descMasuk,hargaItem;
    private TextView hrgTotal,numberOrderTxt;
    private int numberOrder = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pesanan);

        gambarMasuk = findViewById(R.id.gbrterima);
        nmMasuk = findViewById(R.id.namatrm);
        descMasuk = findViewById(R.id.desctrm);
        hargaItem = findViewById(R.id.hrgtrm);
        hrgTotal = findViewById(R.id.totalHarga);
        numberOrderTxt = findViewById(R.id.txtNumberItem);

        plusItem=findViewById(R.id.btnPlus);
        minusItem=findViewById(R.id.btnMinus);
        pesanDetail=findViewById(R.id.btnSave);

        Intent intent = getIntent();
        int gambar = intent.getExtras().getInt("gambar");
        String nama = intent.getExtras().getString("nama");
        String desc = intent.getExtras().getString("desc");
        String harga = String.valueOf(intent.getExtras().getFloat("harga"));

        gambarMasuk.setImageResource(gambar);
        nmMasuk.setText(nama);
        descMasuk.setText(desc);
        hargaItem.setText("Rp." +harga);
        hrgTotal.setText("Rp." +harga);

        numberOrderTxt.setText(String.valueOf(numberOrder));

        plusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOrder=numberOrder+1;
                numberOrderTxt.setText(String.valueOf(numberOrder));
                hrgTotal.setText(String.valueOf("Rp." +numberOrder * intent.getExtras().getFloat("harga")));
            }
        });

        minusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numberOrder>1){
                    numberOrder = numberOrder - 1;
                }
                numberOrderTxt.setText(String.valueOf(numberOrder));
                hrgTotal.setText(String.valueOf("Rp." +numberOrder * intent.getExtras().getFloat("harga")));
            }
        });

        pesanDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), KeranjangPesanan.class);
                intent.putExtra("namapesanan",nmMasuk.getText());
                intent.putExtra("jumlahitem",numberOrderTxt.getText());
                intent.putExtra("harga",hargaItem.getText());
                intent.putExtra("total",hrgTotal.getText());
                view.getContext().startActivities(new Intent[]{intent});
            }
        });

    }
}