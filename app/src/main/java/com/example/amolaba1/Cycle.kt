package com.example.amolaba1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import kotlin.math.pow

class Cycle : AppCompatActivity() {

    lateinit var a: EditText
    lateinit var b: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cycle)

        a = findViewById(R.id.Number_aaa)
        b = findViewById(R.id.Number_bb)

        a.filters = arrayOf<InputFilter>(InputFilter { source, _, _, _, _, _ ->
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

        b.filters = arrayOf<InputFilter>(InputFilter { source, _, _, _, _, _ ->
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


        val btn = findViewById<Button>(R.id.btn_result)
        val res = findViewById<TextView>(R.id.res_text3)

        btn.setOnClickListener {
            if (TextUtils.isEmpty(a.text.toString()) || TextUtils.isEmpty(b.text.toString())) {
                Toast.makeText(this, "Необхідно ввести значення!!!", Toast.LENGTH_SHORT).show()
            }else{

                var sum = 0f
                var prod = 1f
                var result = 0f

                var a_a = a.text.toString()
                var splt = a_a.split(" ")
                var num_a = splt.map { it.toFloat() }
                var len_a = num_a.size

                var b_b = b.text.toString()
                var splt_b = b_b.split(" ")
                var num_b = splt_b.map { it.toFloat() }
                var len_b = num_b.size

                if (len_a!=len_b){
                    Toast.makeText(this, "Довжина масивів різна!", Toast.LENGTH_SHORT).show()
                }else {
                    for (i in 0 until len_a) {
                        prod *= num_a[i].pow(3) - num_b[i].pow(3)
                    }
                    for (j in 0 until len_b) {
                        sum += num_a[j].pow(3) + num_b[j].pow(3)
                    }
                    result = prod + sum

                    res.text = "Результат: $result"

                    a.text.clear()
                    b.text.clear()
                }
            }
        }
        val btn_save = findViewById<Button>(R.id.btn_save1)
        val btn_download = findViewById<Button>(R.id.btn_download1)
        val FILE_NAME = "number.txt"
        btn_save.setOnClickListener {
            try {
                val file = File(filesDir, FILE_NAME)
                FileOutputStream(file).use {
                    val bytes = a.text.toString().toByteArray() + ",".toByteArray() + b.text.toString().toByteArray() + ",".toByteArray()
                    it.write(bytes)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            a.text.clear()
            b.text.clear()
        }

        btn_download.setOnClickListener {
            try {
                val file = File(filesDir, FILE_NAME)
                var data = FileInputStream(file).use {
                    String(it.readBytes())
                }
                val final_data = data.split(",")

                a.setText(final_data[0])
                b.setText(final_data[1])

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
