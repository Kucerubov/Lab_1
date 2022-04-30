package com.example.lab_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TaskActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.task_1)
    }
}