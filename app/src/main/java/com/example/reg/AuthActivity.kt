package com.example.reg

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_auth)
        val userLogin: EditText = findViewById(R.id.user_login_auth)
        val userPass: EditText = findViewById(R.id.user_pass_auth)
        val button = this.findViewById<Button>(R.id.button2_reg_auth)
        val LinkToReg: TextView = findViewById(R.id.link_to_reg)


        LinkToReg.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if (login.isEmpty() || pass.isEmpty()) {
                // Проверка на заполненность полей
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            } else {
                val db = DbHelper(this, null)
                val isAuth = db.getUser(login, pass)

                if (isAuth) {
                    // Пользователь авторизован
                    Toast.makeText(this, "Пользователь $login авторизован", Toast.LENGTH_LONG)
                        .show()
                    userLogin.text.clear()
                    userPass.text.clear()

                    // Переход к следующей активности
                    val intent = Intent(this, ItemsActivity::class.java)
                    startActivity(intent)
                } else {
                    // Пользователь не авторизован
                    Toast.makeText(this, "Пользователь $login НЕ авторизован", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
    }
}