package com.example.mylistview

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mylistview.adapter.HeroAdapter
import com.example.mylistview.adapter.RecyclerHeroAdapter
import com.example.mylistview.model.Hero

class MainActivity : AppCompatActivity() {

    private lateinit var listView : ListView
    private lateinit var rv : RecyclerView
    //private lateinit var adapter : HeroAdapter

    private lateinit var rvAdapter: RecyclerHeroAdapter

    private lateinit var dataName : Array<String>
    private lateinit var dataDescription : Array<String>
    private lateinit var dataPhoto : TypedArray

    private var heroes = arrayListOf<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        //adapter = HeroAdapter(this@MainActivity)
        //listView.adapter = adapter
        prepare()
        addItem()
        rvAdapter = RecyclerHeroAdapter(heroes)
        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(this)

//        listView.onItemClickListener = AdapterView.OnItemClickListener{_, _, position, _ ->
//            Toast.makeText(this@MainActivity, heroes[position].name, Toast.LENGTH_SHORT).show()
//        }
    }

    private fun initComponents() {
        //listView = findViewById(R.id.lv_list)
        rv = findViewById(R.id.rv_list)
    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.data_name)
        dataDescription = resources.getStringArray(R.array.data_description)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
    }

    private fun addItem() {
        for(position in dataName.indices) {
            val hero = Hero(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataDescription[position]
            )
            heroes.add(hero)
        }
        //adapter.heroes = heroes
    }
}
