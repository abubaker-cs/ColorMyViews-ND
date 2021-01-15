package org.abubaker.colormyviewsnd

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import org.abubaker.colormyviewsnd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // DataBinding Step 3 - Define our central DataBinding Object
    private lateinit var binding: ActivityMainBinding


    // LifeCycle (Event) - onCreate()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // DataBinding Step 4 - Replace our Binding Object with setContentView
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setListeners()
    }

    // Function - setListeners()
    private fun setListeners() {
        // This is the list of View-Elements in the activity_main.xml
        // Note boxOneText = box_one_text ID defined in the XML file.
        // This conversion of IDs to Camel case is auto
        val clickableViews: List<View> = listOf(
            binding.boxOneText,
            binding.boxTwoText,
            binding.boxThreeText,
            binding.boxFourText,
            binding.boxFiveText,
            binding.constraintLayout
        )

        // It will pass the clicked-button to the makeColored() function.
        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }

    // Function - makeColored()
    private fun makeColored(view: View) {

        // When = It is actually Switch Statement in Kotlin Language
        when (view.id) {

            // Color class colors for background = setBackgroundColor()
            binding.boxOneText.id -> view.setBackgroundColor(Color.DKGRAY)
            binding.boxTwoText.id-> view.setBackgroundColor(Color.GRAY)

            // Android color resources = setBackgroundResource()
            binding.boxThreeText.id -> view.setBackgroundResource(android.R.color.holo_blue_light)
            binding.boxFourText.id -> view.setBackgroundResource(android.R.color.holo_green_dark)
            binding.boxFiveText.id -> view.setBackgroundResource(android.R.color.holo_blue_bright)

            // Default
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}