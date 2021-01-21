package com.example.count_to_asgn1

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.count_to_asgn1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val numKeyName = "numVal"
    private var numDisplayed:Int= 0

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.countDownBtn.setOnClickListener {decrementVal()}
        binding.countUpBtn.setOnClickListener { incrementVal() }
        binding.toastBtn.setOnClickListener { showToast(it) }
    }

    private fun incrementVal(){
        numDisplayed++;
        updateViewData()
    }

    private fun decrementVal(){
        numDisplayed--;
        updateViewData()
    }

    private fun showToast(view : View){
        Toast.makeText(applicationContext,
                "HELLO PLAYER $numDisplayed",
                Toast.LENGTH_SHORT).show()
    }

    private fun updateViewData(){
        binding.apply {
            numberToShowTxtView?.text = numDisplayed.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putInt(numKeyName,numDisplayed)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val savedNum = savedInstanceState.getInt(numKeyName)
        numDisplayed = savedNum
        updateViewData()
    }
}