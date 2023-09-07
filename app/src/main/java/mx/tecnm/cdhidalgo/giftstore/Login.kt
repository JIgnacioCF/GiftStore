package mx.tecnm.cdhidalgo.giftstore

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import mx.tecnm.cdhidalgo.giftstore.DataClass.Usuario
import org.w3c.dom.Text

class Login : AppCompatActivity() {
    private lateinit var correo: TextInputLayout
    private lateinit var password: TextInputLayout
    private lateinit var btnIngresar: MaterialButton
    private lateinit var btnNoEstoyRegistrado: MaterialButton
    private lateinit var auth: FirebaseAuth
    private lateinit var usuario: Usuario


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth
        val db = Firebase.firestore

        correo = findViewById(R.id.txtCorreo)
        password = findViewById(R.id.txtPass)

        btnIngresar = findViewById(R.id.btnIngresar)
        btnNoEstoyRegistrado = findViewById(R.id.btnRegistrar)

        btnNoEstoyRegistrado.setOnClickListener {
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }

        btnIngresar.setOnClickListener {
            if (correo.editText?.text.toString().isNotEmpty() &&
                password.editText?.text.toString().isNotEmpty()
            )
                auth.signInWithEmailAndPassword(
                    correo.editText?.text.toString(),
                    password.editText?.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        db.collection("usuarios")
                            .whereEqualTo("correo", correo.editText?.text.toString())
                            .get().addOnSuccessListener { documents ->
                                for (document in documents) {
                                    usuario = Usuario(
                                        "${document.data.get("correo")}",
                                        "${document.data.get("nombre")}",
                                        "${document.data.get("apaterno")}",
                                        "${document.data.get("amaterno")}"
                                    )
                                }
                                val intent = Intent(this, Tienda::class.java)
                                intent.putExtra("usuario", usuario)
                                startActivity(intent)
                            }
                    } else {
                        showAlert()
                    }
                }
        }
    }



    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error en la autentificacion del usuario")
        builder.setPositiveButton("aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}