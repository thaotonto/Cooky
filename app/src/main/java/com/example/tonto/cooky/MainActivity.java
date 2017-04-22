package com.example.tonto.cooky;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listCake;
    private List<Cake> cakes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init() {
        listCake = (ListView) findViewById(R.id.list_cake);
        CookyDatabase cookyDatabase = CookyApplication.getInstance().getCookyDatabase();
        cakes = cookyDatabase.loadAllCake();
        List<RowItem> rows = new ArrayList<>();
        for (Cake cake : cakes) {
            RowItem row = new RowItem(cake.getImage(), cake.getTitle(), cake.getDescription(),
                    cake.getIngredients(), cake.getRecipe());
            rows.add(row);
        }
        CustomAdapter customAdapter = new CustomAdapter(this,rows);
        listCake.setAdapter(customAdapter);
    }
}
