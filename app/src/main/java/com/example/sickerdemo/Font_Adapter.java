package com.example.sickerdemo;


import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Font_Adapter extends RecyclerView.Adapter<Font_Adapter.ViewData> {
    Activity activity;
    String[] fonts = {"Font/font1.ttf", "Font/font2.ttf", "Font/font3.ttf"};

    public Font_Adapter(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.font_item, parent, false);
        return new ViewData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewData holder, int position) {
        Typeface typeface = Typeface.createFromAsset(activity.getAssets(), fonts[position]);
        holder.txt_item.setTypeface(typeface);
        
       holder.txt_item.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {



           }
       });
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class ViewData extends RecyclerView.ViewHolder {
        TextView txt_item;

        public ViewData(@NonNull View itemView) {
            super(itemView);
            txt_item = itemView.findViewById(R.id.txt_item);
        }
    }
}
