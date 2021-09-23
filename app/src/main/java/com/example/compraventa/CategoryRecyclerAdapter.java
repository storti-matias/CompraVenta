package com.example.compraventa;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.compraventa.model.Categoria;

import java.util.List;

public class CategoryRecyclerAdapter
        extends RecyclerView.Adapter<CategoryRecyclerAdapter.ViewHolder>
        implements View.OnClickListener{

    private View.OnClickListener listener;
    private List<Categoria> mDataset;


    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        View v;
        CardView cd;


        public ViewHolder( View itemView) {
            super(itemView);
            v = itemView;
            titulo = itemView.findViewById(R.id.rowTitulo);
            cd = itemView.findViewById(R.id.cardView);
        }

        public TextView getTitulo() {
            return titulo;
        }

        public View getView() {
            return v;
        }
    }

    public CategoryRecyclerAdapter(List <Categoria> myDataset) {mDataset = myDataset; }

    @Override
    public CategoryRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup pr, int tipo) {
       View v = LayoutInflater.from(pr.getContext())
               .inflate(R.layout.fila_cat, pr, false);

       v.setOnClickListener(this);
       return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(CategoryRecyclerAdapter.ViewHolder viewHolder, int i) {

        Categoria unaCat = mDataset.get(i);
        viewHolder.titulo.setText(unaCat.getName());
        //viewHolder.titulo.setBackgroundColor(Color.parseColor(unaCat.getColorAsociado()));
        viewHolder.titulo.setBackgroundColor(Color.WHITE);
        viewHolder.cd.setCardBackgroundColor(Color.parseColor(unaCat.getColorAsociado()));
        };




    public void setOnClickListener(View.OnClickListener listener) {
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }

    @Override
    public int getItemCount() {return mDataset.size();}


}
