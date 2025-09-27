package com.example.dummybrowser

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

  private fun blockedText(url: String?): String =
    if (!url.isNullOrBlank()) "Navigation bloquée\n\nURL: $url"
    else "Navigation bloquée\n\nLes liens web sont désactivés sur cet appareil."

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val tv = findViewById<TextView>(R.id.tvBlocked)
    val btn = findViewById<Button>(R.id.btnClose)
    tv.text = blockedText(intent?.data?.toString())
    btn.setOnClickListener { finish() }
  }

  override fun onNewIntent(intent: Intent?) {
    super.onNewIntent(intent)
    findViewById<TextView>(R.id.tvBlocked)
      .text = blockedText(intent?.data?.toString())
  }
}
