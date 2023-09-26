package com.example.assignment.Event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.assignment.R
import com.example.assignment.databaseEvent.EventDatabase
import com.example.assignment.databinding.FragmentEventTestBinding

class EventFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout using DataBindingUtil
        val binding: FragmentEventTestBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_event_test, container, false
        )

        val application = requireNotNull(this.activity).application

        val dataSource = EventDatabase.getInstance(application).eventDatabaseDao

        val eventViewModel =
            ViewModelProvider(
                this
            ).get(EventViewModel::class.java)

        binding.setLifecycleOwner(this)

        return binding.root

    }

}