package com.example.recycler_view_test91124

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerViewForHold : RecyclerView
    private lateinit var productsAdapter: ProductsAdapter
    private lateinit var laptop: ArrayList<Laptop>
    private lateinit var book : ArrayList<Book>

private val lapimg = arrayOf(R.drawable.laptop1,R.drawable.laptop2,R.drawable.laptop3)
    private val booimg = arrayOf(R.drawable.book1,R.drawable.book2,R.drawable.book3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        initViews()
        initArray()
        initAdapter()
    }
    private fun initViews(){
        recyclerViewForHold = findViewById(R.id.recyclerViewForHold)
    }
    private fun initArray(){
        laptop = ArrayList()
        book = ArrayList()
        for (i in lapimg.indices){
            laptop.add(Laptop(lapimg[i],"laptop$i"))
        }
        for (i in booimg.indices){
            book.add(Book(booimg[i],"book$i"))
        }
    }
    private fun initAdapter(){
        productsAdapter = ProductsAdapter(laptop,book)
        recyclerViewForHold.adapter = productsAdapter
        recyclerViewForHold.layoutManager = LinearLayoutManager(this)
    }
}