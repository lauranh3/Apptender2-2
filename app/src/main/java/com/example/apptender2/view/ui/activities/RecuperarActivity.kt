package com.example.apptender2.view.ui.activities

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

class RecuperarActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    lateinit var recuperar1button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperar)

        firebaseAuth = Firebase.auth
        recuperar1button = findViewById(R.id.BRecuEmail)
        val correo=findViewById<EditText>(R.id.correorecuperar)

        recuperar1button.setOnClickListener {
            cambiocontrasena(correo.text.toString())
        }
    }
    private fun cambiocontrasena (correo:String){
        firebaseAuth.sendPasswordResetEmail(correo)
            .addOnCompleteListener(this){ task->
                if (task.isSuccessful) {
                Toast.makeText(
                    baseContext, "Cambio de contraseña enviado",Toast.LENGTH_SHORT ).show ()
                startActivity(Intent(this, LoginActivity::class.java))
            } else {
            Toast.makeText(baseContext, "Error en correo no existe  por favor validar", Toast.LENGTH_SHORT).show()
    }

    }
}
}