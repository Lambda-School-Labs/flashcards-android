package com.lambda.mnemecards.settings


import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

import com.lambda.mnemecards.R
import com.lambda.mnemecards.databinding.FragmentSettingsBinding

/**
 * A simple [Fragment] subclass.
 */
class SettingsFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private lateinit var viewModel: SettingsViewModel
    private lateinit var viewModelFactory: SettingsViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class.
        val binding: FragmentSettingsBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_settings,
            container,
            false
        )

        val settingsFragmentArgs by navArgs<SettingsFragmentArgs>()

        viewModelFactory = SettingsViewModelFactory(settingsFragmentArgs.name, settingsFragmentArgs.photoUrl)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(SettingsViewModel::class.java)

//       binding.lifecycleOwner = this

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

//        binding.executePendingBindings()

        viewModel.name.observe(this, Observer{newName ->
            binding.tvSettingsName.text =newName.toString()
            Toast.makeText(binding.root.context, "${binding.tvSettingsName.text} ${newName.toString()}", Toast.LENGTH_SHORT).show()
//            binding.executePendingBindings()
        })

        // For the prefer to study spinner
        val preferToStudyByAdapter:ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(binding.root.context, R.array.study_methods, android.R.layout.simple_spinner_item )
        preferToStudyByAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerSettingsPreferToStudyBy.adapter = preferToStudyByAdapter
        binding.spinnerSettingsPreferToStudyBy.onItemSelectedListener = this

        // For the study frequency spinner
        val studyFrequencyAdapter:ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(binding.root.context, R.array.study_frequency, android.R.layout.simple_spinner_item)
        studyFrequencyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerStudyFrequency.adapter = studyFrequencyAdapter
        binding.spinnerStudyFrequency.onItemSelectedListener = this

        // For the notification frequency spinner
        val notificationFrequencyAdapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(binding.root.context, R.array.study_notification_frequency, android.R.layout.simple_spinner_item)
        notificationFrequencyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerNotificationFrequency.adapter = notificationFrequencyAdapter
        binding.spinnerNotificationFrequency.onItemSelectedListener = this

        setHasOptionsMenu(true)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    /**
     * Inflates the overflow menu that contains filtering options.
     */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.settings -> findNavController().navigate(R.id.action_homeFragment_to_settingsFragment)
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//        Toast.makeText(parent?.context, parent?.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show()

        // parent?.getItemAtPosition(position).equals seems like an important function I'll be needing in the future
    }


}
