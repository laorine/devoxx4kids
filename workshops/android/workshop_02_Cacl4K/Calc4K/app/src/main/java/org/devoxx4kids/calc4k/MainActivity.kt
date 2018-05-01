package org.devoxx4kids.calc4k

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var editText: EditText = findViewById(R.id.editText) as EditText
        editText.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                validate(editText.text.toString())
                return@OnKeyListener true
            }
            false
        })

        var question: TextView = findViewById(R.id.textView3) as TextView
        question.text = genQuestion()

    }

    var answer = 0

    fun genQuestion(): String {
        val value1 = Random().nextInt(10)
        val value2 = Random().nextInt(10)
        answer = value1 + value2
        return "${value1} + $value2"
    }

    fun validate(value: String) {
        if (value.equals(answer.toString())) {

            var question: TextView = findViewById(R.id.textView3) as TextView
            question.text = genQuestion()

            var editText: EditText = findViewById(R.id.editText)
            editText.setText("")
        }
        else if (!value.equals("")){
            Toast.makeText(this@MainActivity,"Loser!", Toast.LENGTH_SHORT).show()
        }
    }
}









