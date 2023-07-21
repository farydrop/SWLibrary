package com.example.swlibrary.data.local

import androidx.room.TypeConverter
import com.example.swlibrary.model.CharacterResults
import com.example.swlibrary.model.StarshipResults
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.Collections

class StarshipTypeConverter {
    private val gson = Gson()
    @TypeConverter
    fun stringToList(data: String?): List<StarshipResults> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<StarshipResults>>() {

        }.type

        return gson.fromJson<List<StarshipResults>>(data, listType)
    }

    @TypeConverter
    fun listToString(someObjects: List<StarshipResults>): String {
        return gson.toJson(someObjects)
    }
}