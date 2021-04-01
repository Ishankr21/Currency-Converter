package com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    var opt1=1
    var opt2=1
    var input:Double=0.0
    var output:Double=0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner1: Spinner = findViewById(R.id.spinner1)
        val ed:EditText=findViewById(R.id.edcurr)


        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.currency_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner1.adapter = adapter
        }
        val spinner2: Spinner = findViewById(R.id.spinner2)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.currency_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner2.adapter = adapter
        }
        spinner1.onItemSelectedListener= object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                 opt2=position+1

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(applicationContext,"Please select a currency",Toast.LENGTH_LONG).show()
            }

        }
        spinner2.onItemSelectedListener= object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                 opt1=position+1

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(applicationContext,"Please select a currency",Toast.LENGTH_LONG).show()
            }

        }
        var btn:Button=findViewById(R.id.btnconvert)
        btn.setOnClickListener {
            input=ed.text.toString().toDouble()
            if(opt1==1)
            {
                if(opt2==1)
                    output=input
                else if(opt2==2)
                    output=0.014*input
                else if(opt2==3)
                    output=0.012*input
                else if(opt2==4)
                    output=1.51*input


            }
            else if(opt1==2)
            {
                if(opt2==1)
                    output=73.36*input
                else if(opt2==2)
                    output=input
                else if(opt2==3)
                    output=0.85*input
                else if(opt2==4)
                    output=110.75*input

            }
            else if(opt1==3)
            {
                if(opt2==1)
                    output=86.20*input
                else if(opt2==2)
                    output=1.17*input
                else if(opt2==3)
                    output=input
                else if(opt2==4)
                    output=130.03*input


            }
            else if(opt1==4)
            {
                if(opt2==1)
                    output=0.66*input
                else if(opt2==2)
                    output=0.0090*input
                else if(opt2==3)
                    output=0.0077*input
                else if(opt2==4)
                    output=input


            }

            val txt:TextView=findViewById(R.id.txt)
            txt.text=output.toString()
        }



    }

}