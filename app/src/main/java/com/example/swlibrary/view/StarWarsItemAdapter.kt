package com.example.swlibrary.view

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.swlibrary.R
import com.example.swlibrary.databinding.CharacterItemBinding
import com.example.swlibrary.databinding.PlanetItemBinding
import com.example.swlibrary.databinding.StarshipItemBinding
import com.example.swlibrary.model.CharacterResults
import com.example.swlibrary.model.PlanetResults
import com.example.swlibrary.model.StarshipResults


class StarWarsItemAdapter(private val dataList: List<Any>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val charVH = VHCharacter(
            CharacterItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        val starVH = VHStarship(
            StarshipItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        val planetVH =
            VHPlanet(PlanetItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        return when (viewType) {
            VIEW_TYPE_CHARACTER -> charVH
            VIEW_TYPE_STARSHIPS -> starVH
            VIEW_TYPE_PLANET -> planetVH
            else -> throw IllegalArgumentException("Unknown view type: $viewType")
        }
    }

    override fun getItemCount(): Int = dataList.size

    override fun getItemViewType(position: Int): Int {
        return when (dataList[position]) {
            is CharacterResults -> VIEW_TYPE_CHARACTER
            is StarshipResults -> VIEW_TYPE_STARSHIPS
            is PlanetResults -> VIEW_TYPE_PLANET
            else -> throw IllegalArgumentException("Unknown data type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is VHCharacter -> {
                val dataItem = dataList[position] as CharacterResults
                if (dataItem != null) {
                    holder.characterName.text = dataItem.name
                    holder.characterGender.text = dataItem.gender
                    holder.characterStarshipsCount.text = dataItem.starships.size.toString()
                    holder.favCharacter.setOnClickListener {
                        if (!dataItem.favorite){
                            holder.favCharacter.setImageDrawable(
                                ContextCompat.getDrawable(
                                    holder.itemView.context,
                                    R.drawable.ic_star
                                )
                            )
                            dataItem.favorite = true
                        } else {
                            holder.favCharacter.setImageDrawable(
                                ContextCompat.getDrawable(
                                    holder.itemView.context,
                                    R.drawable.ic_star_border
                                )
                            )
                            dataItem.favorite = false
                        }
                    }

                }
            }

            is VHStarship -> {
                val dataItem = dataList[position] as StarshipResults
                if (dataItem != null) {
                    holder.starshipTitle.text = dataItem.name
                    holder.model.text = dataItem.model
                    holder.manufacturer.text = dataItem.manufacturer
                    holder.pilots.text = dataItem.pilots.size.toString()
                    holder.favStarship.setOnClickListener {
                        if (!dataItem.favorite){
                            holder.favStarship.setImageDrawable(
                                ContextCompat.getDrawable(
                                    holder.itemView.context,
                                    R.drawable.ic_star
                                )
                            )
                            dataItem.favorite = true
                        } else {
                            holder.favStarship.setImageDrawable(
                                ContextCompat.getDrawable(
                                    holder.itemView.context,
                                    R.drawable.ic_star_border
                                )
                            )
                            dataItem.favorite = false
                        }
                    }
                }
            }

            is VHPlanet -> {
                val dataItem = dataList[position] as PlanetResults
                if (dataItem != null) {
                    holder.planetName.text = dataItem.name
                    holder.diameter.text = dataItem.diameter
                    holder.population.text = dataItem.population
                    holder.favPlanet.setOnClickListener {
                        if (!dataItem.favorite){
                            holder.favPlanet.setImageDrawable(
                                ContextCompat.getDrawable(
                                    holder.itemView.context,
                                    R.drawable.ic_star
                                )
                            )
                            dataItem.favorite = true
                        } else {
                            holder.favPlanet.setImageDrawable(
                                ContextCompat.getDrawable(
                                    holder.itemView.context,
                                    R.drawable.ic_star_border
                                )
                            )
                            dataItem.favorite = false
                        }
                    }
                }
            }
        }
    }

    internal class VHCharacter(binding: CharacterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val characterName = binding.tvCharacterName
        val characterGender = binding.tvCharacterGender
        val characterStarshipsCount = binding.tvCharacterIsStarshipCount
        val favCharacter = binding.ivFavoriteButton
    }

    internal class VHStarship(binding: StarshipItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val starshipTitle = binding.tvStarshipName
        val model = binding.tvStarshipModel
        val manufacturer = binding.tvStarshipManufacturer
        val pilots = binding.tvStarshipPilotsName
        val favStarship = binding.ivFavoriteButton
    }

    internal class VHPlanet(binding: PlanetItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val planetName = binding.tvPlanetName
        val diameter = binding.tvPlanetDiameter
        val population = binding.tvPlanetPopulation
        val favPlanet = binding.ivFavoriteButton
    }

    companion object {
        const val VIEW_TYPE_CHARACTER = 0
        const val VIEW_TYPE_STARSHIPS = 1
        const val VIEW_TYPE_PLANET = 2
    }
}