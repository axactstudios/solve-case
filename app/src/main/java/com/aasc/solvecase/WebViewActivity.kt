package com.aasc.solvecase

import android.os.Bundle
import android.os.PersistableBundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_web_view.*
import utils.FileUtils

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        webView.webViewClient = WebViewClient()
        webView.settings.setSupportZoom(true)
        webView.settings.javaScriptEnabled = true
        val url = FileUtils.getPdfUrl()
        webView.loadUrl("https://docs.google.com/gview?embedded=true&url=$url")
    }
}

