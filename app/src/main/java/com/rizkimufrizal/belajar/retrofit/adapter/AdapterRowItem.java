package com.rizkimufrizal.belajar.retrofit.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.rizkimufrizal.belajar.retrofit.R;
import com.rizkimufrizal.belajar.retrofit.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 09 March 2017
 * @Time 9:25 AM
 * @Project Belajar-Retrofit
 * @Package com.rizkimufrizal.belajar.retrofit.adapter
 * @File AdapterRowItem
 */
public class AdapterRowItem extends RecyclerView.Adapter<AdapterRowItem.ViewHolder> {

    private List<Item> itemList = new ArrayList<>();

    public void clear() {
        itemList.clear();
    }

    public void addItem(List<Item> itemList) {
        this.itemList = itemList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            imageView = (ImageView) itemView.findViewById(R.id.imageview);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(itemList.get(position).getName());
        Glide
                .with(holder.imageView.getContext())
                .load(itemList.get(position).getAlbum().getImages().get(0).getUrl())
                .centerCrop()
                .placeholder(R.mipmap.gears)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

}
