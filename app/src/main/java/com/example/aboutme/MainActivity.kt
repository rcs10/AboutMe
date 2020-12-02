package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //private lateinit var viewBinding: ActivityMainBinding
    private lateinit var binding : ActivityMainBinding
    private var myName : Name = Name("Dhanuesh")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        //setContentView(R.layout.activity_main)
        //viewBinding = ActivityMainBinding.inflate(layoutInflater)
        binding.myName = myName
        val done_button : Button = binding.doneButton

        done_button.setOnClickListener{
            donePressed(it)
        }
    }

    private fun donePressed(view : View){

        binding.apply {
            myName?.nickName = nicknameEdittext.text.toString()
            nicknameEdittext.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
            invalidateAll()
        }
        view.visibility = View.GONE

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}