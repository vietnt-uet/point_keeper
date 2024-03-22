package com.camlanhchanh.pointkeeper

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var mLayoutXiDach: View
    lateinit var mLayoutPhom: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mLayoutPhom = findViewById(R.id.layout_phom)
        mLayoutXiDach = findViewById(R.id.layout_xi_dach)

        mLayoutPhom.setOnClickListener {
            val intent = Intent(this@MainActivity, AddPlayerActivity::class.java)
            intent.putExtra("type", "phom")
            startActivity(intent)
        }

        mLayoutXiDach.setOnClickListener {
            val intent = Intent(this@MainActivity, AddPlayerActivity::class.java)
            intent.putExtra("type", "xi_dach")
            startActivity(intent)
        }

    }
}