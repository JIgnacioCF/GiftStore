package mx.tecnm.cdhidalgo.giftstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import mx.tecnm.cdhidalgo.giftstore.DataClass.Producto
import mx.tecnm.cdhidalgo.giftstore.DataClass.Usuario

class DetalleProducto : AppCompatActivity() {
    private lateinit var btnRegresar: Button
    private lateinit var btnCarrito: Button
    private lateinit var btnComprar: Button
    private lateinit var nombreCliente: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_producto)

        btnRegresar = findViewById(R.id.btnRegresar)
        btnCarrito = findViewById(R.id.btnCarrito)
        btnComprar = findViewById(R.id.btnComprar)

        nombreCliente = findViewById(R.id.tvNombreCliente)

        val usuario = intent.getParcelableExtra<Usuario>("usuario")
        val producto = intent.getParcelableExtra<Producto>("producto")
        val misCompras = intent.getParcelableArrayListExtra<Producto>("misCompras")

        nombreCliente.text = "Cliente: ${usuario?.nombre} ${usuario?.apaterno} " +
                "${usuario?.amaterno}"

        if(producto!=null){
            val vistaImagen:ImageView = findViewById(R.id.detalleImagen)
            val vistaNombre:TextView = findViewById(R.id.detalleNombre)
            val vistaDescripcion:TextView = findViewById(R.id.detalleDescripcion)
            val vistaPrecio:TextView = findViewById(R.id.detallePrecio)

            vistaImagen.setImageResource(producto.imagen)
            vistaNombre.text = producto.nombre
            vistaDescripcion.text = producto.descripcion
            vistaPrecio.text = "$ ${producto.precio.toString()}"
        }

        btnRegresar.setOnClickListener {
            val intent = Intent(this,Tienda::class.java)
            intent.putExtra("usuario",usuario)
            intent.putExtra("misCompras",misCompras)
            startActivity(intent)
        }

        btnCarrito.setOnClickListener {
            val intent = Intent(this,Carrito::class.java)
            intent.putExtra("usuario",usuario)
            intent.putExtra("misCompras",misCompras)
            startActivity(intent)
        }

        btnComprar.setOnClickListener {
            val intent = Intent(this,Tienda::class.java)
            intent.putExtra("usuario",usuario)
            intent.putExtra("compraProducto",producto)
            intent.putExtra("misCompras",misCompras)
            startActivity(intent)
        }
    }
}
