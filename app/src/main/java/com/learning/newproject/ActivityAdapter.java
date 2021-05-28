package com.learning.newproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ActivityAdapterVH> {

    private List<Datum> datumList;
    private Context context;

    public  ActivityAdapter() {

    }

    public void setData(List<Datum> datumList,Context context) {

        this.datumList = datumList;
        this.context = context;

    }

    @NonNull
    @Override
    public ActivityAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.navigation_bar_row,parent,false);
        ActivityAdapterVH activityAdapterVH = new ActivityAdapterVH(view);
        return activityAdapterVH;
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityAdapterVH holder, int position) {


        Glide.with(context).load(datumList.get(position).getIcons())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.iconImage);

        holder.activityName.setText(datumList.get(position).getActivityName());



    }

    @Override
    public int getItemCount() {
        return datumList.size();
    }



    public class ActivityAdapterVH extends RecyclerView.ViewHolder {

        ImageView iconImage;
        TextView activityName;

        public ActivityAdapterVH(@NonNull View itemView) {
            super(itemView);

            iconImage = itemView.findViewById(R.id.getImage);
            activityName = itemView.findViewById(R.id.getName);

        }
    }
}
