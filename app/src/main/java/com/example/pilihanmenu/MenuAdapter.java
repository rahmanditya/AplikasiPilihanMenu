package com.example.pilihanmenu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    private ArrayList<Menu> listMenu;

    public MenuAdapter(ArrayList<Menu> listMenu) {
        this.listMenu = listMenu;
    }


    @NonNull
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.item_menu,parent,false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.ViewHolder holder, int position) {
        Menu menu = listMenu.get(position);
        holder.txtNama.setText(menu.getNama());
        holder.txtDesc.setText(menu.getDeskripsi());
        holder.txtHrg.setText(Float.toString(menu.getHarga()));
        holder.imgFoto.setImageResource(menu.getId_gambar());
        holder.btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailPesanan.class);
                intent.putExtra("gambar",listMenu.get(position).getId_gambar());
                intent.putExtra("nama",listMenu.get(position).getNama());
                intent.putExtra("desc",listMenu.get(position).getDeskripsi());
                intent.putExtra("harga",listMenu.get(position).getHarga());
                view.getContext().startActivities(new Intent[]{intent});
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMenu.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtNama,txtDesc,txtHrg;
        public ImageView imgFoto;
        public Button btnPesan;
        public ConstraintLayout itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNama = (TextView) itemView.findViewById(R.id.txtNama);
            txtDesc = (TextView) itemView.findViewById(R.id.txtDesc);
            txtHrg = (TextView) itemView.findViewById(R.id.txtHrg);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            btnPesan = (Button) itemView.findViewById(R.id.btnPesan);
            this.itemView = (ConstraintLayout) itemView.findViewById(R.id.mainLayout);
        }
    }
}
