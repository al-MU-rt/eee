package com.example.amolaba1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn_lin = findViewById<Button>(R.id.btn_to_lin)
        btn_lin.setOnClickListener{
            var intent = Intent(this, Linear::class.java)
            startActivity(intent)
        }

        var btn_branch = findViewById<Button>(R.id.btn_to_branch)
        btn_branch.setOnClickListener{
            var intent = Intent(this, Branch::class.java)
            startActivity(intent)
        }

        var btn_cycle = findViewById<Button>(R.id.btn_to_cycle)
        btn_cycle.setOnClickListener{
            var intent = Intent(this, Cycle::class.java)
            startActivity(intent)
        }
    }
}