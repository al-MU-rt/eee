package com.example.amolaba1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.pow
import kotlin.math.sqrt


class Branch : AppCompatActivity() {

    lateinit var i: EditText
    lateinit var n: EditText
    lateinit var c: EditText
    lateinit var x: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_branch)

        i = findViewById(R.id.Number_i)
        n = findViewById(R.id.Number_n)
        c = findViewById(R.id.Number_c)
        x = findViewById(R.id.Number_xx)

        c.filters = arrayOf<InputFilter>(InputFilter { source, _, _, _, _, _ ->
            val allowedChars = "1234567890 "
            if (source != null) {
                for (i in source.indices) {
                    if (!allowedChars.contains(source[i].toString())) {
                        return@InputFilter ""
                    }
                }
            }
            null
        })


        var btn = findViewById<Button>(R.id.btn_result)
        var res = findViewById<TextView>(R.id.res_text2)

        btn.setOnClickListener {

            if (TextUtils.isEmpty(n.text.toString()) || TextUtils.isEmpty(i.text.toString()) || TextUtils.isEmpty(c.text.toString()) || TextUtils.isEmpty(x.text.toString())) {
                Toast.makeText(this, "Необхідно ввести значення!!!", Toast.LENGTH_SHORT).show()
            }else if (x.text.toString().toFloat()==0f) {
                Toast.makeText(this, "Помилка ділення на 0!", Toast.LENGTH_SHORT).show()
            }else{
                val nn = n.text.toString().toFloat()
                val ii = i.text.toString().toFloat()
                val xx = i.text.toString().toFloat()

                var c_c = c.text.toString()
                var splt_a = c_c.split(" ")
                var num_c = splt_a.map { it.toFloat() }
                var len_c = num_c.size

                var cc = num_c[ii.toInt() - 1]

                var result = 0f

                if (ii > len_c || ii<=0f){
                    Toast.makeText(this, "Значення і має дорівнювати від 1 до $len_c", Toast.LENGTH_SHORT).show()
                }else if (cc == 0f){
                    Toast.makeText(this, "Помилка С не може = 0", Toast.LENGTH_SHORT).show()
                }

                if (ii == 2*nn + 1){
                    result = 25 * cc.pow(2) - sqrt((2*ii)/(34*xx.pow(2))) + 4 * sqrt(ii/(45*xx.pow(2)))
                }else if(ii == 2*nn){
                    result = 25 * xx.pow(2) - sqrt((2*ii)/(34*cc.pow(2))) + 4 * sqrt(ii/(45*cc.pow(2)))
                }else{
                    Toast.makeText(this, "Помилка i = 2n+1 або і = 2n", Toast.LENGTH_SHORT).show()
                }

                res.text = "Результат: $result"

                i.text.clear()
                n.text.clear()
                x.text.clear()
                c.text.clear()
            }
        }
    }
}