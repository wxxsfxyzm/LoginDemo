package com.carlyu.logindemo.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ToDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    companion object {
        fun startActivity(ctx: Context) {
            val intent = Intent(ctx, ToDetailActivity::class.java)
            intent.putExtra()
        }
    }
}