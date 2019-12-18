package com.lambda.mnemecards


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home_test.*

class HomeTestFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_destination.setOnClickListener{
            if((!et_first.text.toString().isNullOrEmpty()) && (!et_second.text.toString().isNullOrEmpty())){
                val directions = HomeTestFragmentDirections.actionHomeTestFragmentToDestinationTestFragment(et_first.text.toString(), et_second.text.toString().toInt())
                findNavController().navigate(directions)
            }
        }
    }

}