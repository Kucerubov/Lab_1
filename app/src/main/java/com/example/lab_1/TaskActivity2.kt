package com.example.lab_1

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_1.databinding.Task2Binding

class TaskActivity2 : AppCompatActivity() {

    private lateinit var binding: Task2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        binding = Task2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var indexWord = 0
        val words = this.resources.getStringArray(R.array.array_word).apply { shuffle() }
        var correctWord = words[indexWord]
        var jumbledWord = String(correctWord.toCharArray().apply { shuffle() })
        binding.genWord.text = jumbledWord

        binding.input.setOnKeyListener { _, keyCode, keyEvent ->
            if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)
            ) {
                if (binding.input.text.toString() == correctWord) {
                    Toast.makeText(baseContext, "Правильно!", Toast.LENGTH_SHORT).show()
                    if(indexWord == words.size - 1) {
                        Toast.makeText(baseContext, "Поздравляю, вы победили!", Toast.LENGTH_SHORT).show()
                        binding.genWord.text = ""

                        val intent = Intent(this, Task2Binding::class.java)
                        startActivity(intent)
                    } else {
                        indexWord++
                        correctWord = words[indexWord]
                        jumbledWord = String(correctWord.toCharArray().apply { shuffle() })
                        binding.genWord.text = jumbledWord
                    }
                    binding.input.text?.clear()
                } else { Toast.makeText(baseContext, "НЕ верно!", Toast.LENGTH_SHORT).show() }
                true
            } else { false }
        }
    }
}