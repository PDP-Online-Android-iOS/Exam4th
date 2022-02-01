package dev.ogabek.exam4th.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.telephony.TelephonyManager;

import java.util.ArrayList;
import java.util.List;

import dev.ogabek.exam4th.R;
import dev.ogabek.exam4th.adapter.FoodsAdapter;
import dev.ogabek.exam4th.model.Food;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews() {
        recyclerView = findViewById(R.id.rv_mainRecyclerView);
        mainActivity = this;

        FoodsAdapter adapter = new FoodsAdapter(mainActivity, prepareFoodsList());

        if (isTablet(mainActivity)) {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        }

        recyclerView.setAdapter(adapter);

    }

    private List<Food> prepareFoodsList() {
        List<Food> foods = new ArrayList<>();
        foods.add(new Food(R.drawable.pizza, "Pizza", 4.59, 5F, "Avalon", "Beruniy, Toshkent"));
        foods.add(new Food(R.drawable.cake, "Cake", 0.99, 4.5F, "Avalon", "Beruniy, Toshkent"));
        foods.add(new Food(R.drawable.chicken, "Chicken", 3.99, 4.5F, "Evos", "Beruniy, Toshkent"));
        foods.add(new Food(R.drawable.hamburger, "Hamburger", 1.39, 4.0F, "Avalon", "Beruniy, Toshkent"));
        foods.add(new Food(R.drawable.soap, "Soap", 3.39, 4.0F, "Milliy Taomlar", "Beruniy, Toshkent"));
        foods.add(new Food(R.drawable.super_soup, "Super Soup", 4.09, 4.0F, "Milliy Taomlar", "Beruniy, Toshkent"));
        foods.add(new Food(R.drawable.lavash, "Lavash", 1.39, 3.5F, "Lavash Center", "Beruniy, Toshkent"));
        foods.add(new Food(R.drawable.meat, "Meat", 5.39, 3.5F, "Meat Market", "Beruniy, Toshkent"));
        foods.add(new Food(R.drawable.frie, "Frie", 3.39, 2.5F, "Avalon", "Beruniy, Toshkent"));
        return foods;
    }

//    private boolean isTablet() {
//        TelephonyManager manager = (TelephonyManager) getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
//        return manager.getPhoneType() == TelephonyManager.PHONE_TYPE_NONE;
//    }

    public static boolean isTablet(Context ctx){
        return (ctx.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

}