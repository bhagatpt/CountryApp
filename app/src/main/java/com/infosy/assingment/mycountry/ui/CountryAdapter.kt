package com.infosy.assingment.mycountry.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.infosy.assingment.mycountry.R;
import com.infosy.assingment.mycountry.model.CountryDetails;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    Context context;
    List<CountryDetails> countryDetailsList;

    public CountryAdapter(Context context, List<CountryDetails> countryDetailsList) {
        this.context = context;
        this.countryDetailsList = countryDetailsList;
    }

    @NonNull
    @Override
    public CountryAdapter.CountryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.country_item_layout, viewGroup, false);
        return new CountryAdapter.CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        CountryDetails details = countryDetailsList.get(position);
        if (!(details.getTitle()==null)) {
            holder.cardView.setVisibility(View.VISIBLE);
        } else {
            holder.cardView.setVisibility(View.GONE);
            holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(10, 10));

        }

        //set image with Glide lib
        if (details.getImageHref() != null) {
            Glide.with(context).
                    load(details.getImageHref()).
                    override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).into(holder.imageView);
            LinearLayout.LayoutParams Params1 = new LinearLayout.LayoutParams(200, 200);
            holder.imageView.setLayoutParams(Params1);
        } else {
            LinearLayout.LayoutParams Params1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            holder.descTxt.setLayoutParams(Params1);
            holder.imageView.setVisibility(View.GONE);
        }

        //set title and description
        holder.titleTxt.setText(details.getTitle());
        holder.descTxt.setText(details.getDescription());
    }

    @Override
    public int getItemCount() {
        return countryDetailsList.size();
    }

    class CountryViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView titleTxt, descTxt;
        private CardView cardView;
        public CountryViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            titleTxt = itemView.findViewById(R.id.titleTxt);
            descTxt = itemView.findViewById(R.id.descTxt);
            cardView=itemView.findViewById(R.id.cardView);
        }
    }
}