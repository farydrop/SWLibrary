package com.example.swlibrary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.swlibrary.databinding.CharacterItemBinding
import com.example.swlibrary.databinding.PlanetItemBinding
import com.example.swlibrary.databinding.StarshipItemBinding
import com.example.swlibrary.model.CharacterResults
import com.example.swlibrary.model.PlanetResults
import com.example.swlibrary.model.StarshipResults


class StarWarsItemAdapter(private val dataList: List<Any>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //val data = emptyList<List<Any>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_CHARACTER -> VHCharacter(CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            VIEW_TYPE_STARSHIPS -> VHStarship(StarshipItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            VIEW_TYPE_PLANET -> VHPlanet(PlanetItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
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
        if (holder is VHCharacter) {
            val dataItem = dataList[position] as CharacterResults
            holder.characterName.text = dataItem.name
            holder.characterGender.text = dataItem.gender
            //holder.characterStarshipsCount.text = dataItem.starships.toString()
            //cast holder to VHItem and set data
        } else if (holder is VHStarship) {
            val dataItem = dataList[position] as StarshipResults
            holder.starshipTitle.text = dataItem.name
            holder.model.text = dataItem.model
            holder.manufacturer.text = dataItem.manufacturer
            //holder.pilots.text = dataItem.pilots.toString()
        } else if (holder is VHPlanet) {
            val dataItem = dataList[position] as PlanetResults
            holder.planetName.text = dataItem.name
            holder.diameter.text = dataItem.diameter.toString()
            holder.population.text = dataItem.population.toString()
        }
    }

    internal class VHCharacter(binding: CharacterItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val characterName = binding.tvCharacterName
        val characterGender = binding.tvCharacterGender
        //val characterStarshipsCount = binding.tvCharacterIsStarshipCount
    }

    internal class VHStarship(binding: StarshipItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val starshipTitle = binding.tvStarshipName
        val model = binding.tvStarshipModel
        val manufacturer = binding.tvStarshipManufacturer
        //val pilots = binding.tvStarshipPilotsName
    }

    internal class VHPlanet(binding: PlanetItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val planetName = binding.tvPlanetName
        val diameter = binding.tvPlanetDiameter
        val population = binding.tvPlanetPopulation
    }

    companion object {
        const val VIEW_TYPE_CHARACTER = 0
        const val VIEW_TYPE_STARSHIPS = 1
        const val VIEW_TYPE_PLANET = 2
    }
}