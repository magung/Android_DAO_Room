package com.magung.daoroom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.CardViewHolder> {
    private List<Meal> meals;
    private Context context;

    public DataAdapter(List<Meal> meals,Context context){
        this.meals = meals;
        this.context = context;
    }

    public List<Meal> getMeals(){
        return meals;
    }
    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        CardViewHolder viewHolder = new CardViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        final String nama,image;
        nama  = meals.get(position).getNama();
        image = meals.get(position).getImage();
        final int id = meals.get(position).getId();
        holder.tvNama.setText(nama);
        Glide.with(context).load(image).into(holder.imgImage);
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama;
        ImageView imgImage;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = (TextView) itemView.findViewById(R.id.tx_meal);
            imgImage = (ImageView) itemView.findViewById(R.id.im_meal);
        }
    }
}
