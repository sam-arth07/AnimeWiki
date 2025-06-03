package com.example.animewiki.data.local

import androidx.room.TypeConverter

class DatabaseConverter {

    private val separator = ","

    @TypeConverter
    fun convertListToString(list: List<String>): String {
        /* *
        * Function to convert a List<String> to a simple String
        * */
        var s = list.elementAt(0)

        list.slice(1..list.lastIndex).forEach { string ->
            s = "$s$separator$string"
        }
        return s
    }

    fun convertStringToList(str: String): List<String> {
        /* *
        * Function to convert back the stored string back to a List<String>
        * */
        val list = str.split(delimiters = arrayOf(separator))
        return list
    }

}