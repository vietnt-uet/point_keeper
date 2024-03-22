package com.camlanhchanh.pointkeeper

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.camlanhchanh.pointkeeper.views.AddPlayerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


const val MAX_PHOM_PLAYER = 4
const val MAX_XI_DACH_PLAYER = 10

class AddPlayerActivity : AppCompatActivity() {
    lateinit var mLayoutPlayerContainer: LinearLayout
    lateinit var mTvTitle: TextView
    var mTotalPlayer = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_player)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var type = "phom"
        if (intent != null && intent?.getStringExtra("type") != null) {
            type = intent?.getStringExtra("type")!!
        }

        mLayoutPlayerContainer = findViewById(R.id.layout_player_container)
        mTvTitle = findViewById(R.id.tv_title)


        when(type) {
            "phom" -> mTvTitle.text = "Nhập người chơi Phỏm"
            "xi_dach" -> mTvTitle.text = "Nhập người chơi Xì Dách"
        }

        findViewById<View>(R.id.btn_start_game).setOnClickListener {
            if ("phom".equals(type)) {
                val intent = Intent(this@AddPlayerActivity, LivePhomGameActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this@AddPlayerActivity, LivePhomGameActivity::class.java)
                startActivity(intent)
            }
        }
        findViewById<FloatingActionButton>(R.id.btn_add_player).setOnClickListener {
            if (mTotalPlayer == MAX_PHOM_PLAYER && "phom" == type || mTotalPlayer == MAX_XI_DACH_PLAYER && "xi_dach" == type) {
                return@setOnClickListener
            }

            val addPlayerView = AddPlayerView(this@AddPlayerActivity)
            mLayoutPlayerContainer.addView(addPlayerView)
            mTotalPlayer++

            if (mTotalPlayer == MAX_PHOM_PLAYER && "phom" == type || mTotalPlayer == MAX_XI_DACH_PLAYER && "xi_dach" == type) {
                findViewById<FloatingActionButton>(R.id.btn_add_player).visibility = View.GONE
            }
        }
    }
}