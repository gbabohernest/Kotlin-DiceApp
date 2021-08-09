package com.ernest.diceroll2

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button3)
        rollButton.setOnClickListener{rollDice()}
//        rollButton.setOnClickListener{Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT).show()}

//      do a dice  when the app starts
        rollDice()

    }

//    logic for dice rolling and displaying
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()

//      find the imageview in the layout
        val diceImage: ImageView = findViewById(R.id.imageView3)

//      logic for changing dice value to the right value when btn is clicked
        val drawableResource = when(diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
//    update the image view with the correct drawable
        diceImage.setImageResource(drawableResource)

//    update content description for screen readers
        diceImage.contentDescription = diceRoll.toString()

    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}