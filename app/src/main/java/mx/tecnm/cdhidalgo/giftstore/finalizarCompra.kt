package mx.tecnm.cdhidalgo.giftstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import mx.tecnm.cdhidalgo.giftstore.DataClass.Compra
import mx.tecnm.cdhidalgo.giftstore.DataClass.Producto
import mx.tecnm.cdhidalgo.giftstore.DataClass.Usuario

class finalizarCompra : AppCompatActivity() {
    private lateinit var textoCompra:TextView
    private lateinit var btnRegresarTienda:Button
    private lateinit var misCompras:ArrayList<Producto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finalizar_compra)

        //Acceso Base de Datos mediante Cloud Firestore
        val db = Firebase.firestore

        val usuario = intent.getParcelableExtra<Usuario>("usuario")
        val total = intent.getStringExtra("total")
        val numeroProductos = intent.getStringExtra("numProductos")
        misCompras = intent.getParcelableArrayListExtra<Producto>("misCompras")
                as ArrayList<Producto>

        textoCompra = findViewById(R.id.tvTexto01)
        btnRegresarTienda = findViewById(R.id.btnRegresarTienda)

        textoCompra.text = "${usuario?.nombre},\n" +
                "agradecemos su preferencia!!"

        btnRegresarTienda.setOnClickListener {
            val intent = Intent(this,Tienda::class.java)
            val compras = Compra(usuario?.correo,total.toString(),
                numeroProductos.toString(),misCompras)

            db.collection("compras")
                .document()
                .set(compras)

            intent.putExtra("usuario",usuario)
            intent.putExtra("misCompras", misCompras)
            startActivity(intent)
        }
    }
}
