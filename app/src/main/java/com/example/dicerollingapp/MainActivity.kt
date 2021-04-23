package com.example.dicerollingapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var maxvalue = 0
    var randomvalue1 = 0
    var randomvalue2 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreference =  getSharedPreferences("NAME", Context.MODE_PRIVATE)
        val radioGroup = findViewById(R.id.radiogroup) as RadioGroup
        val mynumber = findViewById(R.id.mynum) as EditText
        val btn1 = findViewById(R.id.button1) as Button
        val btn2 = findViewById(R.id.button2) as Button
        val textview1 = findViewById(R.id.ans1) as TextView
        val textview2 = findViewById(R.id.ans2) as TextView
        val selectedBtn =  radioGroup.checkedRadioButtonId
        if (selectedBtn == R.id.side4){
            maxvalue = 4
        }
        else if (selectedBtn == R.id.side6){
            maxvalue = 6
        }
        else if (selectedBtn == R.id.side8){
            maxvalue = 8
        }
        else if (selectedBtn == R.id.side10){
            maxvalue = 10
        }
        else if (selectedBtn == R.id.side12){
            maxvalue = 12
        }

        else if (selectedBtn == R.id.side20){
            maxvalue = 20
        }
        if(sharedPreference.getString("MyVals","")?.length != 0){
            mynumber.setText(sharedPreference.getString("MyVals",""))
            maxvalue = sharedPreference.getString("MyVals","")?.toInt()!!
        }

        mynumber.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                if(!s.toString().length.equals(0)){
                    maxvalue = s.toString().toInt();
                    sharedPreference.edit().putString("MyVals", maxvalue.toString()).apply()
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if(!s.length.equals(0)){
                    maxvalue = s.toString().toInt();
                    sharedPreference.edit().putString("MyVals", maxvalue.toString()).apply()
                }
            }
        })
        btn1.setOnClickListener(View.OnClickListener {
            val selectedBtn =  radioGroup.checkedRadioButtonId
            if (selectedBtn == R.id.side4){
                maxvalue = 4
            }
            else if (selectedBtn == R.id.side6){
                maxvalue = 6
            }
            else if (selectedBtn == R.id.side8){
                maxvalue = 8
            }
            else if (selectedBtn == R.id.side10){
                maxvalue = 10
            }
            else if (selectedBtn == R.id.side12){
                maxvalue = 12
            }

            else if (selectedBtn == R.id.side20){
                maxvalue = 20
            }
            randomvalue1 = (Math.random()*maxvalue).toInt()+1
            textview1.text = String.format("%d", randomvalue1)
        })

        btn2.setOnClickListener(View.OnClickListener {
            val selectedBtn =  radioGroup.checkedRadioButtonId
            if (selectedBtn == R.id.side4){
                maxvalue = 4
            }
            else if (selectedBtn == R.id.side6){
                maxvalue = 6
            }
            else if (selectedBtn == R.id.side8){
                maxvalue = 8
            }
            else if (selectedBtn == R.id.side10){
                maxvalue = 10
            }
            else if (selectedBtn == R.id.side12){
                maxvalue = 12
            }

            else if (selectedBtn == R.id.side20){
                maxvalue = 20
            }
            randomvalue2 = (Math.random()*maxvalue).toInt()+1
            textview2.text = String.format("%d", randomvalue2)
            Toast.makeText(this@MainActivity, String.format("%d", randomvalue2), Toast.LENGTH_SHORT).show()
        })
    }
}