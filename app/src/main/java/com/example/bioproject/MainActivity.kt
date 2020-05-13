package com.example.bioproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var forest : Area = Area()
    var day = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forest.water = 30
        forest.temp = 20
    }
    class Area(){
        var water = 0
        var temp = 0
        var animals : MutableList<Lifes> = mutableListOf()
    }
    class Lifes(){
        var name = ""
        var water = 0
        var temp = 0
        var food : MutableList<Lifes> = mutableListOf()
        override fun toString(): String {
            return name
        }
    }
    var i = 0
    fun toDo(v:View){
        if (forest.animals.isNotEmpty() == true){
            while(forest.water > 0){
                    while (i < forest.animals.size){
                        if (forest.temp > forest.animals[i].temp){
                        forest.animals[i].water++}
                        i++ }

                forest.water = forest.water - forest.animals.sumBy { it.water }
                day++
            }
            text.setText("на $day день вода закончится")
        }}
    fun toLive(v:View){
        if ((waterr.text.toString() != "")&&(tempp.text.toString() != "")){
        forest.animals.apply {
            add(Lifes().apply {
                name = namee.text.toString()
                temp = tempp.text.toString().toInt()
                water = waterr.text.toString().toInt() })
        }
        list?.adapter = ArrayAdapter<Lifes>(this, android.R.layout.simple_list_item_1, forest.animals)
        }
    }
}