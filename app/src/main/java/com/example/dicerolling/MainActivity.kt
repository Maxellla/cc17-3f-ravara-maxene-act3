package com.example.dicerolling

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.core.animation.doOnEnd
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_B)
        val diceImage: ImageView = findViewById(R.id.dice_Image)

        rollButton.setOnClickListener {
            // Start the roll effect before showing the final dice number
            rollDiceWithEffect(diceImage)
        }
    }

    private fun rollDiceWithEffect(diceImage: ImageView) {
        // Add a rotation animation to simulate the dice roll effect
        val animator = ObjectAnimator.ofFloat(diceImage, "rotation", 0f, 360f)
        animator.duration = 500 // Animation duration in milliseconds (0.5 seconds)
        animator.start()

        // Once the animation is done, change the image
        animator.doOnEnd {
            rollDice(diceImage)
        }
    }

    private fun rollDice(diceImage: ImageView) {
        // Generate a random number between 1 and 6
        val diceRoll = Random.nextInt(1, 7)

        // Choose the correct dice image based on the roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the new dice image
        diceImage.setImageResource(drawableResource)
    }
}