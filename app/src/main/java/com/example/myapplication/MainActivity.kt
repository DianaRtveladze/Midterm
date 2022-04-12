package com.example.myapplication

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.registerButton.setOnClickListener {
            if (checkName(binding.nameET) && checkPhoneNumber(binding.emailET) && checkPasswords(
                    binding.passwordET,
                    binding.repeatPasswordET
                )
            ) {
                Toast.makeText(this, "Check Email", Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(this, "Error occurred", Toast.LENGTH_SHORT).show()

            }
        }

    }

    private fun checkName(editText: EditText): Boolean {
        return editText.text.isNotEmpty()
    }

    private fun checkPhoneNumber(editText: EditText): Boolean {
        return editText.text.startsWith("5") && editText.text.length == 9
    }

    private fun checkPasswords(password: EditText, repeatPassword: EditText): Boolean {
        return password.text.isNotEmpty() && repeatPassword.text.isNotEmpty() && password.text == repeatPassword.text
    }
}