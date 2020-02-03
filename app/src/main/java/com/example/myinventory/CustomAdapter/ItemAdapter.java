package com.example.myinventory.CustomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myinventory.Model.ItemModel;
import com.example.myinventory.R;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    Context context;
    List<ItemModel> list;

    public ItemAdapter(Context context, List<ItemModel> list) {
        this.context = context;
        this.list = list;
    }

    public void add(int position, ItemModel itemModel) {
        list.add(position, itemModel);
        notifyItemInserted(position);
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_view_items, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemModel data = list.get(position);

        holder.tvId.setText("Item ID: "+data.getItemId());
        holder.tvName.setText(data.getItemName());
        holder.tvCat.setText("Category: "+data.getItemCat());
        holder.tvDesc.setText(data.getItemDesc());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvId, tvName, tvDesc, tvCat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvId = (TextView) itemView.findViewById(R.id.tv_view_item_id);
            tvName = (TextView) itemView.findViewById(R.id.tv_view_item_name);
            tvCat = (TextView) itemView.findViewById(R.id.tv_view_item_cat);
            tvDesc = (TextView) itemView.findViewById(R.id.tv_view_item_desc);
        }
    }
}
