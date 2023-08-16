package com.example.pilihanmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class KeranjangPesanan extends AppCompatActivity {
    private Button buttonBack;
    private TextView namaPesanan,hargaPesanan;
    private TextView jmlItem,totalHarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keranjang_pesanan);

        namaPesanan = findViewById(R.id.pesanNama);
        jmlItem = findViewById(R.id.jmlPesanan);
        hargaPesanan = findViewById(R.id.pesanHarga);
        totalHarga = findViewById(R.id.pesanTotal);

        buttonBack = findViewById(R.id.btnKembali);


        Intent intent = getIntent();
        String namapesanan = intent.getExtras().getString("namapesanan");
        String jumlahitem = intent.getExtras().getString("jumlahitem");
        String harga = intent.getExtras().getString("harga");
        String total = intent.getExtras().getString("total");


        namaPesanan.setText(namapesanan);
        jmlItem.setText(jumlahitem);
        hargaPesanan.setText(harga);
        totalHarga.setText(total);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivities(new Intent[]{intent});
            }
        });

    }
}