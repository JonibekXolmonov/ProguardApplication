package com.example.proguardapplication

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proguardapplication.databinding.ItemHomePhotoBinding
import com.example.proguardapplication.model.Response

class HomePhotoAdapter(private val list: List<Response>) :
    RecyclerView.Adapter<HomePhotoAdapter.HomePhotoVH>() {

    inner class HomePhotoVH(private val view: ItemHomePhotoBinding) :
        RecyclerView.ViewHolder(view.root) {
        fun bind(photo: Response) {
            Log.d("TAG", "bind: $photo")
            Glide.with(view.ivHomePhoto.context)
                .load(photo.urls.thumb)
                .placeholder(ColorDrawable(Color.parseColor(photo.color)))
                .into(view.ivHomePhoto)

            if (photo.description != null) {
                view.tvHomePhotoTitle.text = photo.description
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePhotoVH {
        return HomePhotoVH(
            ItemHomePhotoBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: HomePhotoVH, position: Int) {
        holder.bind(getItem(position))
    }

    private fun getItem(position: Int): Response = list[position]

    override fun getItemCount(): Int = list.size
}