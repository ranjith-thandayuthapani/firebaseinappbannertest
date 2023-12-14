package com.example.firebaseinappbannertest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            startActivity(Intent(this, AnotherActivity::class.java))
        }

    }

    override fun onResume() {
        super.onResume()
        Firebase.analytics.logEvent(FirebaseAnalytics.Event.BEGIN_CHECKOUT, Bundle().apply {
            putInt(FirebaseAnalytics.Param.ITEM_ID, 1)
            putString(FirebaseAnalytics.Param.ITEM_NAME, "Some Item")
            putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image")
        })
    }
}