package com.example.mylistview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mylistview.R
import com.example.mylistview.model.Hero

class RecyclerHeroAdapter(private val items: List<Hero>): RecyclerView.Adapter<RecyclerHeroAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val txtName : TextView = itemView.findViewById(R.id.txt_name)
        private val txtDescription : TextView = itemView.findViewById(R.id.txt_description)
        private val imgPhoto : ImageView = itemView.findViewById(R.id.img_photo)

        fun bindItem(hero: Hero) {
            txtName.text = hero.name
            txtDescription.text = hero.description
            imgPhoto.setImageResource(hero.photo)

            itemView.setOnClickListener {
                Toast.makeText(itemView.context, hero.name, Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

}