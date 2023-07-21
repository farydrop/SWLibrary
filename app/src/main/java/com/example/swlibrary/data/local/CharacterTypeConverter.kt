package com.example.swlibrary.data.local

import androidx.room.TypeConverter
import com.example.swlibrary.model.CharacterResults
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.Collections

class CharacterTypeConverter {
    private val gson = Gson()
    @TypeConverter
    fun stringToList(data: String?): List<CharacterResults> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<CharacterResults>>() {

        }.type

        return gson.fromJson<List<CharacterResults>>(data, listType)
    }

    @TypeConverter
    fun listToString(someObjects: List<CharacterResults>): String {
        return gson.toJson(someObjects)
    }
}
