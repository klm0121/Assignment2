package com.example.assign2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    var current_category = "Addition"
    var total = 0
    var correct = 0
    var answer = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val subbtn : Button = findViewById(R.id.sub_btn)
        val answerbox : EditText = findViewById(R.id.editTextNumber)
        loadQuestion()
        subbtn.setOnClickListener {
            var toasttxt = "Wrong answer!"
            total++
            if(answerbox.text.toString().toInt()==answer) {
                correct++
                toasttxt = "Correct answer!"
            }
            Toast.makeText(this, toasttxt, Toast.LENGTH_SHORT).show()
            findViewById<TextView>(R.id.statsTextView).text = "$correct out of $total"
            loadQuestion()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.my_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.resetbtn -> resetStats()
            R.id.categorybtn -> DiaFrag().show(supportFragmentManager, "Select Category")
        }
        return true;
    }
    fun resetStats() {
        total = 0
        correct = 0
        findViewById<TextView>(R.id.statsTextView).text = "N/A"
    }
    fun changeCategory(cat: String) {
        findViewById<TextView>(R.id.CategoryTextView).text = cat
        current_category = cat
        loadQuestion()
    }
    fun loadQuestion() {
        findViewById<EditText>(R.id.editTextNumber).text = null
        var char =  "+"
        var n1 : Int = (0..100).random()
        var n2 : Int = (0..100).random()
        answer = n1 + n2
        if(current_category=="Division") {
            n1 = n1/10 * n2
            answer = n1/n2
            char = "/"
        }
        else if(current_category=="Multiplication") {
            answer = n1 * n2
            char = "*"
        }
        else if(current_category=="Subtraction") {
            answer = n1 - n2
            char = "-"
        }
        findViewById<TextView>(R.id.questionView).text = "$n1 $char $n2"
    }

}

