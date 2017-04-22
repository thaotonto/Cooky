package com.example.tonto.cooky;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tonto on 4/22/2017.
 */

public class CookyDatabase extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "cooky.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_CAKE = "cake";
    private static final String COOKY_IMAGE = "image";
    private static final String COOKY_TITLE = "title";
    private static final String COOKY_DESCRIPTION = "description";
    private static final String COOKY_INGREDIENTS = "ingredients";
    private static final String COOKY_RECIPE = "recipe";
    private static final String[] COOKY_ALL_COLUMNS = {
            COOKY_IMAGE,
            COOKY_TITLE,
            COOKY_DESCRIPTION,
            COOKY_INGREDIENTS,
            COOKY_RECIPE
    };

    public CookyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public List<Cake> loadAllCake() {
        List<Cake> cakes = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_CAKE, COOKY_ALL_COLUMNS, null, null, null, null, null);

        while (cursor.moveToNext()) {
            String image = cursor.getString(cursor.getColumnIndex(COOKY_IMAGE));
            String title = cursor.getString(cursor.getColumnIndex(COOKY_TITLE));
            String description = cursor.getString(cursor.getColumnIndex(COOKY_DESCRIPTION));
            String ingredients = cursor.getString(cursor.getColumnIndex(COOKY_INGREDIENTS));
            String recipe = cursor.getString(cursor.getColumnIndex(COOKY_RECIPE));
            Cake cake = new Cake(image, title, description, ingredients, recipe);
            cakes.add(cake);
        }
        cursor.close();
        db.close();
        return cakes;
    }
}
