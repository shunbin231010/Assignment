package com.example.assignment

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject

class EventDetails : AppCompatActivity(){

    lateinit var image1 : ImageView
    private lateinit var listPeopleRecycler : RecyclerView
    private lateinit var newArrayList: ArrayList<ListDonate>
    lateinit var imageId : Array<Int>
    lateinit var name : Array<String>
    lateinit var btnJoin : Button
    lateinit var builder : AlertDialog.Builder
    private val URL :String = "http://192.168.0.19:8081/mobile/eventjoin.php"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.event_details)

        val textViewTitile : TextView
        val textViewCompany : TextView

        textViewTitile = findViewById(R.id.event_title)
        textViewCompany = findViewById(R.id.event_organization_edit)

        val testname = intent.getStringExtra("name")
        val compnay = intent.getStringExtra("company")
        val testid = intent.getStringExtra("id").toString().trim()

        textViewTitile.text = testname.toString()
        textViewCompany.text = compnay.toString()


        image1  = findViewById(R.id.event_img)
        image1.setImageResource(R.drawable.dice_1)

        name = arrayOf(
            "Ling Cong",
            "Shun bin",
            "Chi yong"
        )
        imageId = arrayOf(
            R.drawable.dice_1,
            R.drawable.dice_2,
            R.drawable.dice_3
        )

//        val stringRequest: StringRequest = object : StringRequest(
//            com.android.volley.Request.Method.POST, URL,
//            Response.Listener { response ->
//                Log.d("res", response)
//                try {
//                    val jsonObject = JSONObject(response)
//                    val message = jsonObject.getString("status")
//                    if (message == "success") {
//                        val dataArray = jsonObject.getJSONArray("data")
//                        for (i in 0 until dataArray.length()) {
//                            val dataObject = dataArray.getJSONObject(i)
//                            val nameList = dataObject.getString("name").toString()
//                            val imgList = dataObject.getString("img")
//                            name += arrayOf(nameList)
//
//                        }
//                    } else if (message == "failure") {
//                        Toast.makeText(
//                            this@EventDetails,
//                            "Invalid Id",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                } catch (e: JSONException) {
//                    e.printStackTrace()
//                    // Handle JSON parsing error here
//                }
//            },
//            Response.ErrorListener { error ->
//                Toast.makeText(
//                    this@EventDetails,
//                    error.toString().trim { it <= ' ' },
//                    Toast.LENGTH_SHORT
//                ).show()
//            }) {
//            @Throws(AuthFailureError::class)
//            override fun getParams(): Map<String, String>? {
//                val data: MutableMap<String, String> = HashMap()
//                data["id"] = testid
//                return data
//            }
//        }
//        val requestQueue = Volley.newRequestQueue(applicationContext)
//        requestQueue.add(stringRequest)

        listPeopleRecycler = findViewById(R.id.fundraising_people_list)
        listPeopleRecycler.layoutManager = LinearLayoutManager(this)
        listPeopleRecycler.setHasFixedSize(true)

        newArrayList = arrayListOf<ListDonate>()
        getUserdata()

        btnJoin = findViewById(R.id.btn_join)
        builder = AlertDialog.Builder(this)

        btnJoin.setOnClickListener { confirmation(it) }
    }

    private fun getUserdata() {
        for(i in imageId.indices){
            val people = ListDonate(imageId[i],name[i])
            newArrayList.add(people)
        }

        listPeopleRecycler.adapter = MyAdapter(newArrayList)
    }

    private fun confirmation(view: View) {
        builder.setMessage("Are you sure want to join this event?")
            .setCancelable(true)
            .setPositiveButton("Join", DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.dismiss() // Dismiss the first dialog
                storeJoinEventPeople()
            })
            .setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.cancel()
            })
            .show()
    }

    private fun storeJoinEventPeople() {
        builder.setMessage("Thank for you joining this event")
            .setCancelable(true)
            .setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.dismiss() // Dismiss the second dialog
                testOtherScreen()
            })
            .setNegativeButton("", DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.cancel()
            })
            .show()
    }

    fun testOtherScreen(){
        val intent = Intent(this@EventDetails,FundraisingDetails::class.java)
        startActivity(intent)
        finish()
    }


}