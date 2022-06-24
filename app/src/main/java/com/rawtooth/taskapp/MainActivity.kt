package com.rawtooth.taskapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import com.rawtooth.taskapp.databinding.ActivityMainBinding
import com.zjun.widget.RuleView

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val DEFAULT_SELECTED_VALUE = 150F
    var isInFoot = false
    var selectedValue = DEFAULT_SELECTED_VALUE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUi()
    }

    fun initUi() {
        binding.toggleButtonGroup.addOnButtonCheckedListener { group, checkedId, isChecked ->
            when (checkedId){
                R.id.btn_cm -> initCMView()
                R.id.btn_foot -> initFootView()
            }
        }
        binding.rvHeightRuler.setValue(0F, 300F, DEFAULT_SELECTED_VALUE, 1F, 10)
        binding.rvHeightRuler.setOnValueChangedListener(RuleView.OnValueChangedListener {
            binding.tvSelectedValue.text = it.toString()
            selectedValue = it
        })
    }

    fun initCMView() {
        if(isInFoot) {

        }
        Toast.makeText(this, "CM", Toast.LENGTH_SHORT).show()
        binding.rvHeightRuler.setValue(0F, 300F, selectedValue, 1F, 10)
    }
    
    fun initFootView() {
        if(!isInFoot) {
            selectedValue /= 30.48F
            isInFoot
        }
        Toast.makeText(this, "Foot", Toast.LENGTH_SHORT).show()
        binding.rvHeightRuler.setValue(0F, 9F, selectedValue, 1F, 12)
    }



}