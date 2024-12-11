package com.example.pivco.Data

import java.io.Serializable


data class Person(val mail : String, val password : String) : Serializable {
    companion object {
        var list: ArrayList<Person> = arrayListOf()
    }
}
