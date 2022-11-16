package com.example.apptender2.view.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apptender2.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

        lateinit var iniciobutton: Button
        lateinit var registrobutton: Button
        lateinit var recuperarbutton: TextView
        private lateinit var firebaseAuth: FirebaseAuth
        @SuppressLint("MissingInflatedId")

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_login)
            firebaseAuth = Firebase.auth

            iniciobutton = findViewById(R.id.BInicio)
            registrobutton = findViewById(R.id.BRegistro)
            recuperarbutton = findViewById(R.id.BRecuperar)

            val correo = findViewById<EditText>(R.id.correologin)
            val contrasena = findViewById<EditText>(R.id.contrasenalogin)

            iniciobutton.setOnClickListener{
                login(correo.text.toString(),contrasena.text.toString())
            }

            registrobutton.setOnClickListener {
                startActivity(Intent( this, RegistroActivity::class.java))
            }

            recuperarbutton.setOnClickListener{
                startActivity(Intent(this, RecuperarActivity::class.java))
            }
    }
    private fun login (correo:String, contrasena:String){
        firebaseAuth.signInWithEmailAndPassword(correo,contrasena)
            .addOnCompleteListener(this) {
                    task ->if (task.isSuccessful) {
                    val user = firebaseAuth.currentUser
                    Toast.makeText(baseContext,user?.uid.toString(),Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, HomeActivity::class.java))
                } else {
                    Toast.makeText(baseContext, "Error en usuario y contraseña por favor validar", Toast.LENGTH_SHORT).show()
                }
            }
    }
}

