package com.example.apptender2.view.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apptender2.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegistroActivity : AppCompatActivity() {

    lateinit var registrarbutton: Button
    private lateinit var firebaseAuth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        firebaseAuth = Firebase.auth

        registrarbutton = findViewById(R.id.BRegistrar)

        val correo = findViewById<EditText>(R.id.editTextEmail)
        val contraseña = findViewById<EditText>(R.id.editTextContraseña)
        registrarbutton.setOnClickListener {
            crearcuenta(correo.text.toString(), contraseña.text.toString())
        }

    }

    private fun crearcuenta(correo: String, contraseña: String) {
        firebaseAuth.createUserWithEmailAndPassword(correo, contraseña)
            .addOnCompleteListener(this) { Task ->
                if (Task.isSuccessful) {
                    Toast.makeText(baseContext, "Cuenta Creada", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, HomeActivity::class.java))
                } else {
                    Toast.makeText(baseContext, "Error creación", Toast.LENGTH_SHORT).show()

                }

            }
    }
}
