package com.example.assignment

import android.content.Context
import android.content.DialogInterface
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class FundraisingDetails : AppCompatActivity() {

    lateinit var image1 : ImageView
    lateinit var image2 : ImageView
    private lateinit var listPeopleRecycler : RecyclerView
    private lateinit var newArrayList: ArrayList<ListDonate>
    lateinit var imageId : Array<Int>
    lateinit var name : Array<String>
    lateinit var btnJoin : Button
    lateinit var builder : AlertDialog.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fundraising_details)

        image1 = findViewById(R.id.fundraising_img)
        image1.setImageResource(R.drawable.dice_1)

        image2 = findViewById(R.id.fundraising_orgazation_img)
        image2.setImageResource(R.drawable.dice_1)

        imageId = arrayOf(
            R.drawable.dice_1,
            R.drawable.dice_2,
            R.drawable.dice_3,
            R.drawable.dice_4,
            R.drawable.dice_5,
            R.drawable.dice_6
        )

        name = arrayOf(
            "Ling Cong",
            "Yong SHun Bin",
            "Yeam Chi Yong",
            "Tan Jia Hon",
            "Ng Ming Zhe",
            "Khoo Jie Kee"
        )

        listPeopleRecycler = findViewById(R.id.fundraising_people_list)
        listPeopleRecycler.layoutManager = LinearLayoutManager(this)
        listPeopleRecycler.setHasFixedSize(true)

        newArrayList = arrayListOf<ListDonate>()
        getUserdata()


    }

    private fun getUserdata(){

        for(i in imageId.indices){
            val people = ListDonate(imageId[i],name[i])
            newArrayList.add(people)
        }
        listPeopleRecycler.adapter = MyAdapter(newArrayList)
    }
}