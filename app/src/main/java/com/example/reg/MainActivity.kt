package com.example.reg

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.reg.R.id

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val userLogin: EditText = findViewById(id.user_login)
        val userEmail: EditText = findViewById(id.user_email)
        val userPass: EditText = findViewById(id.user_pass)
        val button = this.findViewById<Button>(id.button2_reg)
        val linkToAuth: TextView= findViewById(id.link_to_auth)
        val LinkToAuth: TextView= this.findViewById(id.link_to_auth)
        LinkToAuth.setOnClickListener{
            val intent = Intent(this,AuthActivity::class.java)
            startActivity(intent)

        }

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if (login == "" || email == "" || pass == "")
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            else {
                val user = User(login,email,pass)
                val db = DbHelper(this, null)
                db.addUser(user)
                Toast.makeText(this, "Пользователь $login добавлен", Toast.LENGTH_LONG).show()
                userLogin.text.clear()
                userEmail.text.clear()
                userPass.text.clear()
            }
        }
    }
}