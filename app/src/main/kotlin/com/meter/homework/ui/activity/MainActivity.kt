package com.meter.homework.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.meter.homework.R
import com.meter.homework.databinding.ActivityMainBinding
import com.meter.homework.data.presenter.Presenter

import com.meter.homework.data.view.CounterView

class MainActivity : AppCompatActivity(R.layout.activity_main), CounterView {
    private val binding by viewBinding(ActivityMainBinding::bind)
    private var presenter = Presenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initClicker()
        presenter.attachView(this)
    }

    private fun initClicker() {
        with(binding) {
            btnInc.setOnClickListener {
                presenter.increment()
            }
            btnDec.setOnClickListener {
                presenter.decrement()
            }
        }
    }

    override fun changeCount(count: Int) {
        binding.counterTv.text = count.toString()
    }

    override fun showToast() {
        Toast.makeText(this,"Congratulations",Toast.LENGTH_SHORT).show()
    }

    override fun changeColor() {
    binding.counterTv.setTextColor(Color.GREEN)
    }

    override fun returnColor() {
        binding.counterTv.setTextColor(Color.BLACK)
    }


}