package com.chirikualii.materi_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.chirikualii.materi_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    lateinit var listAdapter: ListProfileAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listAdapter = ListProfileAdapter()

        listAdapter.addlist(DataDummy.ListProfile)

        binding.rvProfile.adapter = listAdapter
    }
}