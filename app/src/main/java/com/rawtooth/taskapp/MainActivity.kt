package com.rawtooth.taskapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rawtooth.taskapp.databinding.ActivityMainBinding
import com.zjun.widget.RuleView
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val DEFAULT_SELECTED_VALUE = 150F
    val MAX_INCH_RANGE = 120F
    val MAX_CM_RANGE = 305F
    val INCH_PER_FEET = 12
    val CM_PER_INCH = 2.54F
    val MM_PER_CM = 10
    val MIN_RULER_RANGE = 0F
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
            if(isChecked) {
                when (checkedId){
                    R.id.btn_cm -> initCMView()
                    R.id.btn_foot -> initFootView()
                }
            }
        }

        binding.rvHeightRuler.setValue(MIN_RULER_RANGE, MAX_CM_RANGE, DEFAULT_SELECTED_VALUE, 1F, MM_PER_CM)
        binding.rvHeightRuler.setOnValueChangedListener(RuleView.OnValueChangedListener {
            selectedValue = it
            if(isInFoot) {
                val foot : Int = (selectedValue / INCH_PER_FEET).roundToInt()
                val inches : Int = (selectedValue % INCH_PER_FEET).roundToInt()
                binding.tvSelectedValue.text = getString(R.string.foot_string, foot, inches)
            } else {
                Log.d("Test", " Selected Value is " + it)
                binding.tvSelectedValue.text = getString(R.string.cm_string, (selectedValue).roundToInt())
            }


        })
    }

    fun initCMView() {
        if(isInFoot) {
            selectedValue *= CM_PER_INCH
        }
        isInFoot = false
        Toast.makeText(this, "CM", Toast.LENGTH_SHORT).show()
        binding.rvHeightRuler.setValue(0F, MAX_CM_RANGE, selectedValue, 1F, MM_PER_CM)
    }

    fun initFootView() {
        if(!isInFoot) {
            selectedValue = (selectedValue / CM_PER_INCH)
            if(selectedValue > MAX_INCH_RANGE) selectedValue = MAX_INCH_RANGE
        }
        isInFoot = true
        Toast.makeText(this, "Foot", Toast.LENGTH_SHORT).show()
        binding.rvHeightRuler.setValue(0F, MAX_INCH_RANGE, selectedValue, 1F, INCH_PER_FEET)
    }



}