package com.example.assign2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class DiaFrag : DialogFragment(R.layout.frag_dia) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val cancelbt : Button = view.findViewById(R.id.cancelBT)
        val submitbt : Button = view.findViewById(R.id.submitBT)
        val radioGroup : RadioGroup = view.findViewById(R.id.CategoryRadioGroup)
        cancelbt.setOnClickListener{
            dismiss()
        }
        submitbt.setOnClickListener{
            val selected : Int = radioGroup.checkedRadioButtonId
            val radioButton = view.findViewById<RadioButton>(selected)
            val m1 : MainActivity = getActivity() as MainActivity
            m1.changeCategory(radioButton.text.toString())
            dismiss()
        }
    }
}