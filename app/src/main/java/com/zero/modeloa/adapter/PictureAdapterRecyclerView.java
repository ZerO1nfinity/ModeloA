package com.zero.modeloa.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zero.modeloa.R;
import com.zero.modeloa.model.Picture;
import com.zero.modeloa.view.PictureDetailActivity;

import java.util.ArrayList;

/**
 * Created by ROBIN on 04/04/2017.
 */

public class PictureAdapterRecyclerView extends RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder>{
    private ArrayList<Picture> lista;
    private int resource;
    private Activity activity;

    public PictureAdapterRecyclerView(ArrayList<Picture> lista, int resource, Activity activity) {
        this.lista = lista;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PictureViewHolder holder, int position) {
        Picture picture = lista.get(position);
        holder.tv_userNameCard.setText(picture.getUserName());
        holder.tv_timeCard.setText(picture.getTime());
        holder.tv_likeNumberCard.setText(picture.getLike_number());
        Picasso.with(activity).load(picture.getPicture()).into(holder.img_pictureCard);

        holder.img_pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, PictureDetailActivity.class);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    Explode explode = new Explode();
                    explode.setDuration(1000);
                    activity.getWindow().setExitTransition(explode);
                    activity.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(
                            activity,
                            v,
                            activity.getString(R.string.transition_picture)
                    ).toBundle());
                }else{
                    activity.startActivity(intent);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public void addAll(@NonNull ArrayList<Picture> pictures){
        if (pictures == null){
            throw new NullPointerException("The items cannot be null");
        }
        this.lista.addAll(pictures);
        notifyItemRangeInserted(getItemCount()-1,pictures.size());
    }

    public class PictureViewHolder extends RecyclerView.ViewHolder{

        private ImageView img_pictureCard;
        private TextView tv_userNameCard;
        private TextView tv_timeCard;
        private TextView tv_likeNumberCard;

        public PictureViewHolder(View itemView) {
            super(itemView);

            img_pictureCard = (ImageView) itemView.findViewById(R.id.img_pictureCard);
            tv_userNameCard = (TextView) itemView.findViewById(R.id.tv_userNameCard);
            tv_timeCard = (TextView) itemView.findViewById(R.id.tv_timeCard);
            tv_likeNumberCard = (TextView) itemView.findViewById(R.id.tv_likeNumberCard);

        }
    }
}
