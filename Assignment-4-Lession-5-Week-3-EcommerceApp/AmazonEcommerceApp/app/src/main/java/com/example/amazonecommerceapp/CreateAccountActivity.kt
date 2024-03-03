package com.example.amazonecommerceapp
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CreateAccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_createaccount)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextMobileOrEmail = findViewById<EditText>(R.id.editTextMobileOrEmail)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val editTextReenterPassword = findViewById<EditText>(R.id.editTextReenterPassword)
        val buttonContinue = findViewById<Button>(R.id.buttonContinue)

        buttonContinue.setOnClickListener {
            val name = editTextName.text.toString()
            val mobileOrEmail = editTextMobileOrEmail.text.toString()
            val password = editTextPassword.text.toString()
            val reenteredPassword = editTextReenterPassword.text.toString()

            if (password.length < 6) {
                Toast.makeText(this, "Password must be at least 6 characters long", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != reenteredPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val newUser = User(email = mobileOrEmail, fullName = name, password = password, phoneNumber = "")
            UserData.addUser(newUser)

            Toast.makeText(this, "User created successfully", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}


