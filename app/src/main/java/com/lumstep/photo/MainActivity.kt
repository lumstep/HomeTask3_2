package com.lumstep.photo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {
    private lateinit var buttonSearch: Button
    private lateinit var editTextPictureUri: EditText
    private lateinit var imageView: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSearch = findViewById(R.id.button_search)
        editTextPictureUri = findViewById(R.id.editText_search_uri)
        imageView = findViewById(R.id.imageView)

        buttonSearch.setOnClickListener {

            Picasso.get().load(editTextPictureUri.text.toString())
                .error(showToast()).into(imageView)
            imageView.visibility = View.VISIBLE
        }
    }

    private fun showToast(): Int {
        Toast.makeText(
            this,
            R.string.error,
            Toast.LENGTH_SHORT
        ).show()
        return R.drawable.ic_baseline_error_24
    }
}