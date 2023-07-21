package com.example.swlibrary.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.swlibrary.databinding.CharacterItemBinding
import com.example.swlibrary.databinding.PlanetItemBinding
import com.example.swlibrary.databinding.StarshipItemBinding
import com.example.swlibrary.model.CharacterResults
import com.example.swlibrary.model.PlanetResults
import com.example.swlibrary.model.StarshipResults


class FavoritesAdapter(private val dataList: List<Any>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val charVH = VHCharacter(CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        val starVH = VHStarship(StarshipItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        val planetVH = VHPlanet(PlanetItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
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
                }
            }
            is VHStarship -> {
                val dataItem = dataList[position] as StarshipResults
                if (dataItem != null) {
                    holder.starshipTitle.text = dataItem.name
                    holder.model.text = dataItem.model
                    holder.manufacturer.text = dataItem.manufacturer
                    holder.pilots.text = dataItem.pilots.size.toString()
                }
            }
            is VHPlanet -> {
                val dataItem = dataList[position] as PlanetResults
                if (dataItem != null) {
                    holder.planetName.text = dataItem.name
                    holder.diameter.text = dataItem.diameter
                    holder.population.text = dataItem.population
                }
            }
        }
    }

    internal class VHCharacter(binding: CharacterItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val characterName = binding.tvCharacterName
        val characterGender = binding.tvCharacterGender
        val characterStarshipsCount = binding.tvCharacterIsStarshipCount
        val favCharacter = binding.ivFavoriteButton
    }

    internal class VHStarship(binding: StarshipItemBinding) : RecyclerView.ViewHolder(binding.root) {
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
        val fsvPlanet = binding.ivFavoriteButton
    }

    companion object {
        const val VIEW_TYPE_CHARACTER = 0
        const val VIEW_TYPE_STARSHIPS = 1
        const val VIEW_TYPE_PLANET = 2
    }

}