package com.example.carracegame

import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), GameTask {

    lateinit var rootLayout: LinearLayout
    lateinit var startBtn: Button
    lateinit var mGameView: GameView
    lateinit var score: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        startBtn = findViewById(R.id.startBtn)
        rootLayout = findViewById(R.id.rootLayout)
        score = findViewById(R.id.score)
        mGameView = GameView(this,this)

        startBtn.setOnClickListener{
            mGameView.setBackgroundResource(R.drawable.img)
            rootLayout.addView(mGameView)
            startBtn.visibility = View.GONE
            score.visibility = View.GONE

            // Resetting score to 0
            mGameView.score = 0

            // Resetting speed to 1
            mGameView.speed = 1

            // Clearing otherCars list to remove all yellow vehicles
            mGameView.torpedo.clear()

            // Invalidate the view to force a redraw
            mGameView.invalidate()

        }
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }

    override fun closeGame(mScore: Int) {
        score.text = "Score : $mScore"
        rootLayout.removeView(mGameView)
        startBtn.visibility = View.VISIBLE
        score.visibility = View.VISIBLE
    }
}