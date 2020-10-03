package com.example.submission7.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.submission7.R
import com.example.submission7.model.ResultsItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_main.view.*


class Adapter_Main() : PagedListAdapter<ResultsItem, RecyclerView.ViewHolder>(ResultsItem().DIFF_CALLBACK){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_main, parent, false)

        return MovieHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MovieHolder)
            holder.onBind(getItem(position))
    }
}

class MovieHolder(val view : View) : RecyclerView.ViewHolder(view){
        fun onBind(item : ResultsItem?){
            val poster      = item?.posterPath
            val posterSize  = "w185/"
            val urlImage    = "http://image.tmdb.org/t/p/$posterSize${poster}"

            itemView.tv_name.text = item?.name
            Picasso.get()
                .load(urlImage)
                .placeholder(R.drawable.animation_progress)
                .error(R.drawable.try_later)
                .into(itemView.iv_gambar)


        }
    }