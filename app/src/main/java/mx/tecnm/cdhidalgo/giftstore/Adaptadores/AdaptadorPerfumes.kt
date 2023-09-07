package mx.tecnm.cdhidalgo.giftstore.Adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.tecnm.cdhidalgo.giftstore.DataClass.Producto
import mx.tecnm.cdhidalgo.giftstore.R

class AdaptadorPerfumes (private val listaProductos: ArrayList<Producto>) :
    RecyclerView.Adapter<AdaptadorPerfumes.ProductoViewHolder>() {

    var onProductoClick: ((Producto) -> Unit)? = null

    class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val vistaImagen: ImageView = itemView.findViewById(R.id.vistaImagen)
        val vistaNombre: TextView = itemView.findViewById(R.id.vistaNombreProducto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ProductoViewHolder {

        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_producto, parent, false)

        return ProductoViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = listaProductos[position]
        holder.vistaImagen.setImageResource(producto.imagen)
        holder.vistaNombre.text = producto.nombreCorto

        holder.itemView.setOnClickListener {
            onProductoClick?.invoke(producto)
        }
    }

    override fun getItemCount(): Int {
        return listaProductos.size
    }
}
