package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityFragmentsBinding

interface DataProvider {
    var result: String?
}

class FragmentsActivity : AppCompatActivity(), DataProvider {

    override var result: String? = null

    private lateinit var binding: ActivityFragmentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MyFragment.newInstance())
            .commit()
    }
}