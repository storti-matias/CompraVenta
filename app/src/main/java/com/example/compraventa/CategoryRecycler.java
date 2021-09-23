package com.example.compraventa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.compraventa.model.Categoria;

public class CategoryRecycler extends AppCompatActivity {

    protected RecyclerView mRecyclerView;
    protected CategoryRecyclerAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_recycler);

        mRecyclerView = findViewById(R.id.listaRecycler);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new CategoryRecyclerAdapter(Categoria.categorias());
        mAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentResultado = new Intent();

                intentResultado.putExtra("categoria",Categoria.categorias().get(mRecyclerView.getChildAdapterPosition(view)).getName());
                setResult(Activity.RESULT_OK,intentResultado);
                finish();
            }
        });
        mRecyclerView.setAdapter(mAdapter);


    }


}
