package com.example.assignment.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.assignment.Event.EventViewModel
import com.example.assignment.R
import com.example.assignment.databaseEvent.EventDatabase
import com.example.assignment.databinding.FragmentTestBinding


class TestFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout using DataBindingUtil
        val binding: FragmentTestBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_test, container, false)

        val application = requireNotNull(this.activity).application

        val dataSource = EventDatabase.getInstance(application).eventDatabaseDao

        val eventViewModel =
            ViewModelProvider(
                this).get(EventViewModel::class.java)

        binding.setLifecycleOwner(this)

        return binding.root
    }
}