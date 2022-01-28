package com.example.myapplicationplanets

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view.view.*
import java.util.*

class Adapter(var planet: List<PlanetData>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title = view.title
        var planetimg = view.planet_img
        var galaxy = view.galaxy

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var planetImage: Int? = null
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, PlanetDetail::class.java)
            intent.putExtra("planet", planet[position])
            intent.putExtra("planetImage", planetImage)
            holder.itemView.context.startActivity(intent)

        }
        holder.title.text = planet[position].title
        holder.galaxy.text = planet[position].galaxy

        when (planet[position].title!!.lowercase(Locale.getDefault())) {
            "mars" -> {
                planetImage = R.drawable.ic_mars
            }
            "neptune" -> {
                planetImage = R.drawable.ic_neptune
            }
            "earth" -> {
                planetImage = R.drawable.ic_earth
            }
            "moon" -> {
                planetImage = R.drawable.ic_moon
            }
            "venus" -> {
                planetImage = R.drawable.ic_venus
            }
            "jupiter" -> {
                planetImage = R.drawable.ic_jupiter
            }
            "saturn" -> {
                planetImage = R.drawable.ic_saturn
            }
            "uranus" -> {
                planetImage = R.drawable.ic_uranus
            }
            "mercury" -> {
                planetImage = R.drawable.ic_mercury
            }
            "sun" -> {
                planetImage = R.drawable.ic_sun
            }
        }
        holder.planetimg.setImageResource(planetImage!!)


    }

    override fun getItemCount(): Int {
        return planet.size
    }
}

