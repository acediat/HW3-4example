package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

class CreateElementContract : ActivityResultContract<Unit, Element>() {

    override fun createIntent(context: Context, input: Unit) = Intent(context, AddElementActivity::class.java)

    override fun parseResult(resultCode: Int, result: Intent?): Element {
        return Element(
            result?.getStringExtra(AddElementActivity.EXTRA_NAME) ?: "",
            result?.getStringExtra(AddElementActivity.EXTRA_DESCRIPTION) ?: ""
        )
    }
}