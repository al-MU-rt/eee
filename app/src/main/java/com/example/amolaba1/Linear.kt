package com.example.amolaba1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt


class Linear : AppCompatActivity() {

    lateinit var a: EditText
    lateinit var b: EditText
    lateinit var x: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear)

        a = findViewById(R.id.Number_a)
        b = findViewById(R.id.Number_x)
        x = findViewById(R.id.Number_c)

        var btn = findViewById<Button>(R.id.btn_result)
        var res = findViewById<TextView>(R.id.res_text1)
        btn.setOnClickListener {

            if (TextUtils.isEmpty(a.text.toString()) || TextUtils.isEmpty(b.text.toString()) || TextUtils.isEmpty(x.text.toString())) {
                Toast.makeText(this, "Необхідно ввести значення!!!", Toast.LENGTH_SHORT).show()
            }else if (x.text.toString().toFloat() == 0f) {
                Toast.makeText(this, "Помилка х=0", Toast.LENGTH_SHORT).show()
            }else{
                val aa = a.text.toString().toFloat()
                val bb = b.text.toString().toFloat()
                val xx = x.text.toString().toFloat()
                val result = (aa+bb/xx).pow(3) + (bb+aa/xx).pow(5)
                res.text = "Результат: " + result.toString()
                a.text.clear()
                b.text.clear()
                x.text.clear()
            }
        }
    }
}