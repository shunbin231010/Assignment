package com.example.assignment

import android.app.DownloadManager.Request
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
import org.json.JSONObject


class MainActivity : AppCompatActivity() {

    private val URL :String = "http://192.168.0.19:8081/mobile/event.php"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttonJoin : Button
        buttonJoin = findViewById(R.id.test_btn)
        buttonJoin.setOnClickListener { join() }
    }

    private fun join(){
        var errortxt : TextView
        errortxt = findViewById(R.id.error)
        val textViewID : TextView
        textViewID = findViewById(R.id.event_id)
        val id = textViewID.text.toString().trim()

        val stringRequest: StringRequest = object : StringRequest(
            com.android.volley.Request.Method.POST, URL,
            Response.Listener { response ->
                Log.d("res", response)
                val jsonObject = JSONObject(response)
                val message = jsonObject.getString("message")
                if (message == "success") {
                    val name = jsonObject.getString("name")
                    val company = jsonObject.getString("company")
                    val intent = Intent(this@MainActivity, EventDetails::class.java)
                    intent.putExtra("name",name)
                    intent.putExtra("company",company)
                    intent.putExtra("id",id)
                    startActivity(intent)
                    finish()
                } else if (message == "failure") {
                    Toast.makeText(
                        this@MainActivity,
                        "Invalid Id",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            },
            Response.ErrorListener { error ->
                Toast.makeText(
                    this@MainActivity,
                    error.toString().trim { it <= ' ' },
                    Toast.LENGTH_SHORT
                ).show()
            }) {
            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String>? {
                val data: MutableMap<String, String> = HashMap()
                data["id"] = id
                return data
            }
        }
        val requestQueue = Volley.newRequestQueue(applicationContext)
        requestQueue.add(stringRequest)


    }

}