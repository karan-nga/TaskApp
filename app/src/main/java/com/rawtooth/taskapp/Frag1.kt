package com.rawtooth.taskapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rawtooth.taskapp.databinding.FragmentFrag1Binding
import com.zjun.widget.RuleView


class Frag1 : Fragment(), RuleView.OnValueChangedListener {
var frag1Binding:FragmentFrag1Binding?=null
    val _binding1 get()=frag1Binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        frag1Binding=FragmentFrag1Binding.inflate(inflater,container,false)

        _binding1.rulerFloat.setValue(0F,275f,150f, 1F,10)
        _binding1.rulerFloat.setOnValueChangedListener(this)
        return _binding1.root
    }

    override fun onValueChanged(value: Float) {

        _binding1.tv2.text=(value.toInt().toString())+" cm"
    }

}