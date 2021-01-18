package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response ->
            if(response.isSuccessful){

                // Allow nulls ?
                Log.d("Response", response.body()?.eurPrice?.last15m.toString())
                // !! Non-null type
                val price = response.body()?.eurPrice?.buy.toString()
                Log.d("Response", price.toString())
                val displayText = getString(R.string.price_string, price.toString())
                textView.text = displayText

            }else{
                Log.d("Response", response.errorBody().toString())
                textView.text = response.code().toString()
            }
        })


    }
}