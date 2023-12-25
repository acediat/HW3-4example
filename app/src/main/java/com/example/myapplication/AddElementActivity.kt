package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityAddElementBinding

class AddElementActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddElementBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddElementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addElementButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra(EXTRA_NAME, binding.nameInput.text.toString())
            intent.putExtra(EXTRA_DESCRIPTION, binding.descriptionInput.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    companion object {
        const val EXTRA_NAME = "name"
        const val EXTRA_DESCRIPTION = "description"
    }
}