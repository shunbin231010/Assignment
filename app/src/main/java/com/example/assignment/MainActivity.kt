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

class MainActivity : AppCompatActivity() {

    lateinit var image1 : ImageView
    lateinit var image2 : ImageView
    private lateinit var listPeopleRecycler : RecyclerView
    private lateinit var newArrayList: ArrayList<ListDonate>
    lateinit var imageId : Array<Int>
    lateinit var name : Array<String>
    lateinit var btnJoin : Button
    lateinit var builder : AlertDialog.Builder

    lateinit var textViewAmount : TextView
    lateinit var editTextAmount : EditText
    lateinit var radioGroupAmount: RadioGroup


    lateinit var textViewTest : TextView
    lateinit var buttonSubmit : Button
    lateinit var editTextEmail : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        setContentView(R.layout.fundraising_details)

//        image1  = findViewById(R.id.event_img)
//        image1.setImageResource(R.drawable.dice_1)

//        image1 = findViewById(R.id.fundraising_img)
//        image1.setImageResource(R.drawable.dice_1)
//
//        image2 = findViewById(R.id.fundraising_orgazation_img)
//        image2.setImageResource(R.drawable.dice_1)
//
//        imageId = arrayOf(
//            R.drawable.dice_1,
//            R.drawable.dice_2,
//            R.drawable.dice_3,
//            R.drawable.dice_4,
//            R.drawable.dice_5,
//            R.drawable.dice_6
//        )
//
//        name = arrayOf(
//            "Ling Cong",
//            "Yong SHun Bin",
//            "Yeam Chi Yong",
//            "Tan Jia Hon",
//            "Ng Ming Zhe",
//            "Khoo Jie Kee"
//        )
//
//        listPeopleRecycler = findViewById(R.id.fundraising_people_list)
//        listPeopleRecycler.layoutManager = LinearLayoutManager(this)
//        listPeopleRecycler.setHasFixedSize(true)
//
//        newArrayList = arrayListOf<ListDonate>()
//        getUserdata()

//        btnJoin = findViewById(R.id.btn_join)
//        builder = AlertDialog.Builder(this)
//
//        btnJoin.setOnClickListener { confirmation(it) }


//        setContentView(R.layout.fundraising_details_donate_payment)
//        textViewAmount = findViewById(R.id.donate_amount_txt)
//        editTextAmount = findViewById(R.id.donate_amount_edit)
//        radioGroupAmount = findViewById(R.id.donate_amount)
//        radioGroupAmount.setOnCheckedChangeListener { group, checkedId ->
//            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//            inputMethodManager.hideSoftInputFromWindow(editTextAmount.windowToken, 0)
//
//            when{
//                checkedId==R.id.donate_5->
//                    textViewAmount.text = "5"
//                checkedId==R.id.donate_10->
//                    textViewAmount.text = "10"
//                checkedId==R.id.donate_20->
//                    textViewAmount.text = "20"
//                checkedId==R.id.donate_50->
//                    textViewAmount.text = "50"
//                checkedId==R.id.donate_100->
//                    textViewAmount.text = "100"
//            }
//
//            editTextAmount.visibility=View.GONE
//            textViewAmount.visibility=View.VISIBLE
//        }
//
//        textViewAmount.setOnClickListener { openEditText(it) }






//        setContentView(R.layout.donate_creditcard_display)





        setContentView(R.layout.donate_paypal_display)

        textViewTest = findViewById(R.id.textView6)
        buttonSubmit = findViewById(R.id.paypal_btn)
        editTextEmail = findViewById(R.id.email_paypal)

        buttonSubmit.setOnClickListener { testing(it) }

    }

    private fun testing(view:View) {
        textViewTest.text = editTextEmail.text.toString()
    }

//    private fun openEditText(view:View) {
//        radioGroupAmount.clearCheck()
//        editTextAmount.visibility=View.VISIBLE
//        textViewAmount.visibility=View.GONE
//    }

//    private fun confirmation(view: View) {
//
//        builder.setTitle("Confirmation")
//            .setMessage("Are you sure want to join this event?")
//            .setCancelable(true)
//            .setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i -> finish() })
//            .setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i -> dialogInterface.cancel() })
//            .show()
//    }
//
//    private fun getUserdata(){
//
//        for(i in imageId.indices){
//            val people = ListDonate(imageId[i],name[i])
//            newArrayList.add(people)
//        }
//
//        listPeopleRecycler.adapter = MyAdapter(newArrayList)
//    }
}