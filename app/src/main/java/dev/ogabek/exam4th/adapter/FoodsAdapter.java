package dev.ogabek.exam4th.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import dev.ogabek.exam4th.R;
import dev.ogabek.exam4th.activity.MainActivity;
import dev.ogabek.exam4th.model.Food;

public class FoodsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Food> foods;
    MainActivity mainActivity;

    public FoodsAdapter(MainActivity mainActivity, List<Food> foods) {
        this.mainActivity = mainActivity;
        this.foods = foods;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foods_view, parent, false);
        return new FoodsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Food food = foods.get(position);

        if (holder instanceof FoodsViewHolder) {
            ((FoodsViewHolder) holder).img.setImageResource(food.getImg());
            ((FoodsViewHolder) holder).name.setText(food.getName());
            ((FoodsViewHolder) holder).price.setText("$" + food.getPrice());
            ((FoodsViewHolder) holder).score.setRating(food.getScore());
            ((FoodsViewHolder) holder).restaurant.setText(food.getRestaurant() + " ⬤ " + food.getLocation());
        }
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    private static class FoodsViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView name;
        TextView price;
        RatingBar score;
        TextView restaurant;

        public FoodsViewHolder(View view) {
            super(view);

            img = view.findViewById(R.id.item_img);
            name = view.findViewById(R.id.item_name);
            price = view.findViewById(R.id.item_price);
            score = view.findViewById(R.id.ratingBar);
            restaurant = view.findViewById(R.id.item_restaurant);

        }
    }
}
