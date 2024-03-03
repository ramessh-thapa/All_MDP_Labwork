package com.example.amazonecommerceapp
import android.content.Intent
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val buttonSignIn = findViewById<Button>(R.id.buttonSignIn)
        val buttonCreateAccount = findViewById<Button>(R.id.buttonCreateAccount)
        val checkBoxShowPassword = findViewById<CheckBox>(R.id.checkBoxShowPassword)

        buttonSignIn.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            val user = UserData.find { it.email == email && it.password == password }
            if (user != null) {
                Toast.makeText(this, "Sign in successful", Toast.LENGTH_SHORT).show()
                UserData.setLoggedInUser(user);
                val intent = Intent(this, ShoppingCategoriesActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }

        buttonCreateAccount.setOnClickListener {
            val intent = Intent(this, CreateAccountActivity::class.java)
            startActivity(intent)
        }

        checkBoxShowPassword.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                editTextPassword.transformationMethod = null
            } else {
                editTextPassword.transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }
    }
}

