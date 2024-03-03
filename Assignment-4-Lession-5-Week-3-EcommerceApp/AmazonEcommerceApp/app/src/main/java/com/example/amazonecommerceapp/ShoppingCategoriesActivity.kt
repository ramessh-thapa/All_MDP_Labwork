package com.example.amazonecommerceapp
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ShoppingCategoriesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shopping_categories)

        val loggedInUser = UserData.getLoggedInUser();
        val textToDisplay = "Hello, " + loggedInUser?.fullName +"!";

        val editTextName = findViewById<TextView>(R.id.textViewWelcomeMessage)
        editTextName.text = textToDisplay
    }
}


