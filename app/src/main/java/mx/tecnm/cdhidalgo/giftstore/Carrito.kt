package mx.tecnm.cdhidalgo.giftstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mx.tecnm.cdhidalgo.giftstore.Adaptadores.AdaptadorCarrito
import mx.tecnm.cdhidalgo.giftstore.DataClass.Producto
import mx.tecnm.cdhidalgo.giftstore.DataClass.Usuario
import mx.tecnm.cdhidalgo.giftstore.R

class Carrito : AppCompatActivity() {
    private lateinit var recyclerViewCarrito: RecyclerView
    private lateinit var adapatadorCarrito: AdaptadorCarrito
    private lateinit var nombreCliente: TextView
    private lateinit var totalCompra: TextView
    private lateinit var btnRegresar: Button
    private lateinit var btnFinalizar: Button

    private lateinit var listaCompras: ArrayList<Producto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrito)

        recyclerViewCarrito = findViewById(R.id.rvCarrito)
        recyclerViewCarrito.setHasFixedSize((true))

        btnRegresar = findViewById(R.id.btnRegresar)
        btnFinalizar = findViewById(R.id.btnFinalizar)

        nombreCliente = findViewById(R.id.tvNombreCliente)
        totalCompra = findViewById(R.id.txtTotal)

        val usuario = intent.getParcelableExtra<Usuario>("usuario")
        val misCompras = intent.getParcelableArrayListExtra<Producto>("misCompras")

        val numeroProductos = misCompras?.size
        if (misCompras != null) {
            listaCompras = misCompras
        }

        var totalPagar = 0.0
        if (misCompras != null) {
            for (i in misCompras.indices) {
                totalPagar += misCompras[i].precio
            }
        }
        totalCompra.text = "TOTAL $ ${totalPagar.toString()}"

        nombreCliente.text = "Cliente: ${usuario?.nombre} ${usuario?.apaterno} " +
                "${usuario?.amaterno}"

        //Recycler vesrtical
        recyclerViewCarrito.layoutManager = LinearLayoutManager(this)

        adapatadorCarrito = AdaptadorCarrito(listaCompras)
        recyclerViewCarrito.adapter = adapatadorCarrito

        btnRegresar.setOnClickListener {
            finish()
        }

        btnFinalizar.setOnClickListener {
            if (totalPagar > 0) {
                val intent = Intent(this, finalizarCompra::class.java)
                intent.putExtra("usuario", usuario)
                intent.putExtra("misCompras", misCompras)
                intent.putExtra("total", totalPagar.toString())
                intent.putExtra("numProductos", numeroProductos.toString())
                startActivity(intent)
            } else {
                Toast.makeText(
                    this, "Debe agregar productos al carrito de compras",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
