package com.amar.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel;
    private lateinit var tvCounter: TextView;
    private lateinit var btnAdd: AppCompatButton;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCounter = findViewById(R.id.tvCounter);
        btnAdd = findViewById(R.id.btnAdd);

        // ---->> if you don't want to pass parameter to MainViewModel
        //mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java);

        // ----->> if you want to pass parameter to MainViewModel then you have to create Factory class
        // that provide the instance of MainViewModel class and can easily pass parameters as well
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(5)).get(MainViewModel::class.java);

        setText();

        btnAdd.setOnClickListener {
            mainViewModel.increment();
            setText();
        }

    }

    private fun setText(){
        tvCounter.text = mainViewModel.count.toString();
    }

}