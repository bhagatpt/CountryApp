package com.infosy.assingment.mycountry.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.infosy.assingment.mycountry.R
import com.infosy.assingment.mycountry.model.CountryDetails
import com.infosy.assingment.mycountry.ui.CountryAdapter.CountryViewHolder

class CountryAdapter(var context: Context, var countryDetailsList: List<CountryDetails>) : RecyclerView.Adapter<CountryViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CountryViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.country_item_layout, viewGroup, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val details = countryDetailsList[position]
        if (details.title != null) {
            holder.cardView.visibility = View.VISIBLE
        } else {
            holder.cardView.visibility = View.GONE
            holder.itemView.layoutParams = RecyclerView.LayoutParams(10, 10)
        }

        //set image with Glide lib
        if (details.imageHref != null) {
            Glide.with(context).load(details.imageHref).override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).into(holder.imageView)
            val Params1 = LinearLayout.LayoutParams(200, 200)
            holder.imageView.layoutParams = Params1
        } else {
            val Params1 = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            holder.descTxt.layoutParams = Params1
            holder.imageView.visibility = View.GONE
        }

        //set title and description
        holder.titleTxt.text = details.title
        holder.descTxt.text = details.description
    }

    override fun getItemCount(): Int {
        return countryDetailsList.size
    }

    inner class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val imageView: ImageView = itemView.findViewById(R.id.imageView)
        internal val titleTxt: TextView = itemView.findViewById(R.id.titleTxt)
        internal val descTxt: TextView = itemView.findViewById(R.id.descTxt)
        internal val cardView: CardView = itemView.findViewById(R.id.cardView)

    }
}