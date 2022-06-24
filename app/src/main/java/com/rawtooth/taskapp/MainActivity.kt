package com.rawtooth.taskapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import com.rawtooth.taskapp.databinding.ActivityMainBinding
import com.zjun.widget.RuleView

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFrag(Frag1())
        binding.btnAndroid.setOnClickListener {
            Toast.makeText(this,"cm selected",Toast.LENGTH_SHORT).show()
            replaceFrag(Frag1())
        }
        binding.btnFlutter.setOnClickListener {
            Toast.makeText(this,"foot selected",Toast.LENGTH_SHORT).show()
            replaceFrag(Frag2())
        }


    }

    private fun replaceFrag(fragmentt:Fragment) {
        val fragment=supportFragmentManager
        val fragTrans=fragment.beginTransaction()
        fragTrans.replace(R.id.fra_container,fragmentt)
        fragTrans.commit()

    }



}