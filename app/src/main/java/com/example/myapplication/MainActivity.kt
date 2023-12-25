package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val elementsAdapter = ElementsAdapter()

    private val contract = registerForActivityResult(CreateElementContract()) {
        elementsAdapter.addItem(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addElementButton.setOnClickListener {
            moveOnAddElementActivity()
        }
        binding.goFragmentsButton.setOnClickListener {
            startActivity(Intent(this, FragmentsActivity::class.java))
        }

        binding.elementsList.adapter = elementsAdapter
    }

    private fun moveOnAddElementActivity() {
        contract.launch(Unit)
    }
}