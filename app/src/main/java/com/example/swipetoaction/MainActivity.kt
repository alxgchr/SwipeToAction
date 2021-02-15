package com.example.swipetoaction

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.swipetoaction.adapter.MyAdapter
import com.example.swipetoaction.helper.MyButton
import com.example.swipetoaction.helper.MySwipeHelper
import com.example.swipetoaction.listener.MyButtonClickListener
import com.example.swipetoaction.model.Item
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: MyAdapter
    lateinit var layoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_test.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recycler_test.layoutManager = layoutManager

        // add swipe
        val swipe = object : MySwipeHelper(this, recycler_test, 200){
            override fun instantiateMyButton(viewHolder: RecyclerView.ViewHolder, buffer: MutableList<MyButton>) {
                // add button
                buffer.add(MyButton(this@MainActivity, "Delete", 30, 0, Color.parseColor("#ff3c30"), object : MyButtonClickListener{
                    override fun onClick(pos: Int) {
                        Toast.makeText(this@MainActivity, "Delete id "+ pos, Toast.LENGTH_SHORT).show()
                    }

                }))

                buffer.add(MyButton(this@MainActivity, "Update", 30, R.drawable.ic_edit_white_24dp, Color.parseColor("#ff9502"), object : MyButtonClickListener{
                    override fun onClick(pos: Int) {
                        Toast.makeText(this@MainActivity, "Update id "+ pos, Toast.LENGTH_SHORT).show()
                    }

                }))
            }

        }
        generateItem()
    }

    private fun generateItem(){
        val itemList = ArrayList<Item>()
        var i = 0
        while (i<50){
            itemList.add(Item("Pie 0" + i++, "100", "https://images-gmi-pmc.edge-generalmills.com/f4c0a86f-b080-45cd-a8a7-06b63cdb4671.jpg"))
            i++
        }
        adapter = MyAdapter(this, itemList)
        recycler_test.adapter = adapter
    }
}