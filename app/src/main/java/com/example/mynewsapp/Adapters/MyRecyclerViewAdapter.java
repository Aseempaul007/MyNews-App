package com.example.mynewsapp.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mynewsapp.CustomWebView;
import com.example.mynewsapp.Models.ModelClass;
import com.example.mynewsapp.R;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    Context context;
    ArrayList<ModelClass> modelClasses;

    public MyRecyclerViewAdapter(Context context, ArrayList<ModelClass> modelClasses) {
        this.context = context;
        this.modelClasses = modelClasses;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_list_items,null,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, CustomWebView.class);
                i.putExtra("url",modelClasses.get(position).getUrl());
                context.startActivity(i);
            }
        });

        holder.mmainheading.setText(modelClasses.get(position).getTitle());
        holder.mcontent.setText(modelClasses.get(position).getDescription());
        holder.mauthor.setText(modelClasses.get(position).getAuthor());
        Glide.with(context).load(modelClasses.get(position).getUrlToImage())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return modelClasses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView mmainheading,mcontent,mauthor,mtime;
        ImageView imageView;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mmainheading = itemView.findViewById(R.id.main_heading);
            mcontent = itemView.findViewById(R.id.content);
            mauthor = itemView.findViewById(R.id.author);
            mtime = itemView.findViewById(R.id.time);
            imageView = itemView.findViewById(R.id.image1);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
