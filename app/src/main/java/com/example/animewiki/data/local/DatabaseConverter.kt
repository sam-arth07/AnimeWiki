package com.example.animewiki.data.local

import androidx.room.TypeConverter

class DatabaseConverter {

    private val separator = ","
    /**
     * Function to convert a List<String> to a simple String
     * */
    @TypeConverter
    fun convertListToString(list: List<String>): String {

        if (list.isEmpty()) {
            return ""
        }
//        var s = list.elementAt(0)
//
//        list.slice(1..list.lastIndex).forEach { string ->
//            s = "$s$separator$string"
//        }
        return list.joinToString(separator = separator)
    }

    /**
     * Function to convert back the stored string back to a List<String>
     * */
    @TypeConverter
    fun convertStringToList(str: String): List<String> {
        if (str.isEmpty()) {
            return emptyList()
        }
        val list = str.split(separator)
        return list
    }

}