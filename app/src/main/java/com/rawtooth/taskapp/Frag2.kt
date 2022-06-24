package com.rawtooth.taskapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rawtooth.taskapp.databinding.FragmentFrag2Binding
import com.zjun.widget.RuleView


class Frag2 : Fragment(), RuleView.OnValueChangedListener {
var frag2binding:FragmentFrag2Binding?=null
    val binding get() = frag2binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            frag2binding=FragmentFrag2Binding.inflate(inflater,container,false)

        binding.rulerFloat.setOnValueChangedListener(this)

        return binding.root

    }

    override fun onValueChanged(value: Float) {
        binding.tv2.text = (value.toString()) + " foot"
    }

}