package com.example.peludosdicas

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.peludosdicas.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var googleSinInCliente: GoogleSignInClient
    private lateinit var auth: FirebaseAuth;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        auth = Firebase.auth

        binding.botaoEntrar.setOnClickListener {

            if (binding.editTextTextUsuario.text.isNullOrEmpty()) {
                Toast.makeText(
                    baseContext, "Por favor,preencha o nome de usuário",
                    Toast.LENGTH_SHORT
                ).show()

            } else if (binding.editTextSenha.text.isNullOrEmpty()) {
                Toast.makeText(
                    baseContext, "Por favor,preencha a senha",
                    Toast.LENGTH_SHORT
                ).show()
            } else {

                loginEusuarioEsenha(
                    binding.editTextTextUsuario.text.toString(),
                    binding.editTextSenha.text.toString()
                )

            }

        }
    }

    private fun loginEusuarioEsenha(usuario:String,senha:String) {
        auth.signInWithEmailAndPassword(
            usuario,
            senha
        )
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser

                    abrePrincipal()

                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(
                        baseContext, "erro de autenticação.",
                        Toast.LENGTH_SHORT
                    ).show()
                    // updateUI(null)
                }
            }
    }

    fun abrePrincipal (){
       Toast.makeText(
           baseContext, "autenticação efetuada.",
           Toast.LENGTH_SHORT).show()
       binding.editTextTextUsuario.text.clear()
       binding.editTextSenha.text.clear()
       val intent = Intent(this,PrincipalActivity::class.java)
       startActivity(intent)
       finish()
   }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        //val currentUser = auth.currentUser
        // updateUI(currentUser)
    }
}
