package mx.tecnm.cdhidalgo.giftstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mx.tecnm.cdhidalgo.giftstore.Adaptadores.*
import mx.tecnm.cdhidalgo.giftstore.DataClass.Producto
import mx.tecnm.cdhidalgo.giftstore.DataClass.Usuario

class Tienda : AppCompatActivity() {

    private lateinit var btnSalir:Button
    private lateinit var btnCarrito:Button

    private lateinit var nombreCliente:TextView

    private lateinit var recyclerViewArtesanias:RecyclerView
    private lateinit var recyclerViewPerfumes:RecyclerView
    private lateinit var recyclerViewBolsos:RecyclerView
    private lateinit var recyclerViewPulseras:RecyclerView
    private lateinit var recyclerViewProductos:RecyclerView

    private lateinit var listaArtesanias:ArrayList<Producto>
    private lateinit var listaPerfumes:ArrayList<Producto>
    private lateinit var listaBolsos:ArrayList<Producto>
    private lateinit var listaPulseras:ArrayList<Producto>
    private lateinit var listaProductos:ArrayList<Producto>

    private lateinit var adaptadorArtesania:AdaptadorArtesania
    private lateinit var adaptadorPerfumes:AdaptadorPerfumes
    private lateinit var adaptadorBolsos:AdaptadorBolsos
    private lateinit var adaptadorPulseras: AdaptadorPulseras
    private lateinit var adaptadorProducto: AdaptadorProducto

    private lateinit var misCompras:ArrayList<Producto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tienda)

        btnSalir = findViewById(R.id.btnSalir)
        btnCarrito = findViewById(R.id.btnCarrito)

        nombreCliente = findViewById(R.id.tvNombreCliente)

        val usuario = intent.getParcelableExtra<Usuario>("usuario")
        val comprarProducto = intent.getParcelableExtra<Producto>("compraProducto")
        val listaCompras = intent.getParcelableArrayListExtra<Producto>("misCompras")

        nombreCliente.text = "${usuario?.nombre} ${usuario?.apaterno}" +
                " ${usuario?.amaterno}"

        recyclerViewArtesanias = findViewById(R.id.rvArtesanias)
        recyclerViewArtesanias.setHasFixedSize(true)

        recyclerViewPerfumes = findViewById(R.id.rvPerfumes)
        recyclerViewPerfumes.setHasFixedSize(true)

        recyclerViewBolsos = findViewById(R.id.rvBolsos)
        recyclerViewBolsos.setHasFixedSize(true)

        recyclerViewPulseras = findViewById(R.id.rvPulseras)
        recyclerViewPulseras.setHasFixedSize(true)

        recyclerViewProductos = findViewById(R.id.rvProductos)
        recyclerViewProductos.setHasFixedSize(true)

        //Recyclerview Horizontal
        recyclerViewArtesanias.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)

        recyclerViewPerfumes.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)

        recyclerViewBolsos.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)

        recyclerViewPulseras.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)

        recyclerViewProductos.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)

        listaArtesanias = ArrayList()
        listaPerfumes = ArrayList()
        listaBolsos = ArrayList()
        listaPulseras = ArrayList()
        listaProductos = ArrayList()

        misCompras = ArrayList()

        if(comprarProducto!=null){
            if(listaCompras!=null){
                misCompras = listaCompras
            }
            misCompras.add(comprarProducto)
        }

        listaArtesanias.add(Producto(
            R.drawable.artesania01,
            "Xico Hoja",
            "Xico-Talavera Hoja",
            3309.0,
            "XICO es un personaje que busca generar un cambio " +
                    "positivo a través del arte y la cultura. " +
                    "Respalda el talento emergente y provee una " +
                    "plataforma comercial de impulso creativo.",
            "Artesanía"))
        listaArtesanias.add(Producto(
            R.drawable.artesania02,
            "Xico Rojo",
            "Xico-Piel de Alebrije Rojo",
            2959.0,
            "XICO es un personaje que busca generar un cambio " +
                    "positivo a través del arte y la cultura. " +
                    "Respalda el talento emergente y provee una " +
                    "plataforma comercial de impulso creativo.",
            "Artesanía"))
        listaArtesanias.add(Producto(
            R.drawable.artesania03,
            "Alebrije Liebre",
            "Alebrije Liebre Chico Azul/Rojo",
            1180.0,
            "Los alebrijes surgen de un sueño del artesano " +
                    "don Pedro Linares: \"Me morí y anduve por montañas," +
                    " barrancas y en un lugar de ésos, donde había un bosque," +
                    " de ahí salían los alebrijes\"... Forma y color se integran" +
                    " armoniosa e intensamente. Bello dentro de su fealdad, " +
                    "diabólico, horroroso, simpático e incluso tierno, el alebrije" +
                    " es símbolo del monstruo mexicano. Revoloteo incesante, remolino" +
                    " de garras, crestas y cuernos de colores vibrantes. Cuanto más " +
                    "extraña sea la figura, más alebrije será.",
            "Artesanía"))
        listaArtesanias.add(Producto(
            R.drawable.artesania04,
            "Alebrije Camaleón",
            "Alebrije Camaleón Mediano",
            5189.0,
            "Los alebrijes surgen de un sueño del artesano " +
                    "don Pedro Linares: \"Me morí y anduve por montañas," +
                    " barrancas y en un lugar de ésos, donde había un bosque," +
                    " de ahí salían los alebrijes\"... Forma y color se integran" +
                    " armoniosa e intensamente. Bello dentro de su fealdad, " +
                    "diabólico, horroroso, simpático e incluso tierno, el alebrije" +
                    " es símbolo del monstruo mexicano. Revoloteo incesante, remolino" +
                    " de garras, crestas y cuernos de colores vibrantes. Cuanto más " +
                    "extraña sea la figura, más alebrije será.",
            "Artesanía"))
        listaArtesanias.add(Producto(
            R.drawable.artesania05,
            "Catrina Rosa",
            "Catrina Arrecifes Rosa",
            4540.0,
            "Pieza artesanal con la figura de una catrina cuyo elegante " +
                    "vestir plasma las tradiciones de la cultura mexicana.",
            "Artesanía"))

        listaPerfumes.add(Producto(
            R.drawable.perfume01,
            "DIOR Sauvage",
            "Eau de parfum DIOR Sauvage Eau de Parfum para hombre",
            4390.0,
            "Libera tu instinto más salvaje con Sauvage de Dior. " +
                    "Deja una estela poderosa y noble con Sauvage eau de parfum " +
                    "de Christian Dior. Esta fragancia relucirá una masculinidad " +
                    "verdadera e inconfundible, inspirada en el desierto a la hora " +
                    "mágica del crepúsculo en el que las noches aproximan frescura. " +
                    "Su recipiente representa el cielo azul ozono que se extiende sobre" +
                    " el desierto rocoso y guarda en su poderoso interior un hombre " +
                    "auténtico y sincero. La composición de Sauvage de Dior lleva " +
                    "consigo fuerza, entrelaza la jugosidad arrolladora de la bergamota " +
                    "de Reggio y la atracción irresistible de los acentos ahumados del " +
                    "absoluto de vainilla de Papúa Nueva Guinea. Su perfumista François " +
                    "Demachy, decidió crear una firma reconocible, enriqueciendo cada " +
                    "una de sus notas dominantes para aportar nuevos colores. " +
                    "Te recomendamos empezar tus mañanas con el gel de ducha vigorizante " +
                    "Sauvage. Luego, vaporiza Sauvage eau de parfum de forma generosa " +
                    "en los puntos de pulso (cuello, muñecas e interior de los codos). " +
                    "Por último, completa tu rutina con el desodorante en spray de " +
                    "fórmula fresca y protección duradera Sauvage",
            "Perfumes"))
        listaPerfumes.add(Producto(
            R.drawable.perfume02,
            "Tom Ford Ombré",
            "Eau de parfum Tom Ford Ombré Leather unisex",
            4440.0,
            "La libertad viene de dentro, el corazón del desierto del " +
                    "oeste envuelto en cuero. El polvo en el viento, la piel en la" +
                    " piel, Ombré Leather se revela como un paisaje en las capas",
            "Perfumes"))
        listaPerfumes.add(Producto(
            R.drawable.perfume03,
            "Dolce&Gabbana The One",
            "Fragancia Dolce&Gabbana The One para hombre",
            2900.0,
            "The One for Men es el nuevo aroma del icónico mundo de " +
                    "The One, que ofrece una experiencia de fragancia más profunda" +
                    " para los expertos en perfumes. Esta fragancia de gran " +
                    "intensidad, masculina y magnética es una declaración de " +
                    "carisma y sofisticación",
            "Perfumes"))
        listaPerfumes.add(Producto(
            R.drawable.perfume04,
            "Gucci Guilty",
            "Eau de parfum Gucci Guilty para hombre",
            3600.0,
            "El universo #ForeverGuilty continúa buscando una noción" +
                    " liberada de pasión con Gucci Guilty Parfum For Him. El aroma" +
                    " reinterpreta el clásico Gucci Guilty For Him en un movimiento" +
                    " que eleva el jugo a niveles más altos de intensidad. Para " +
                    "aquellos que buscan una declaración de amor libre de las " +
                    "reglas y definiciones de la sociedad, el aroma está diseñado " +
                    "para actuar como emblema de la conexión entre amantes excéntricos" +
                    " y de ideas afines. Gucci Guilty Parfum For Him es una fragancia " +
                    "amaderada aromática que magnifica la verdadera esencia de la " +
                    "línea Gucci Guilty For Him",
            "Perfumes"))
        listaPerfumes.add(Producto(
            R.drawable.perfume05,
            "Salvatore Ferragamo Uomo",
            "Eau de toilette Salvatore Ferragamo Uomo para hombre",
            2140.0,
            "La mezcla de cedro, madera y un toque de comino logran " +
                    "crear un perfume ideal para llevarlo de día o de noche ",
            "Perfumes"))

        listaBolsos.add(Producto(
            R.drawable.bolso01,
            "Bolso Guess",
            "Bolso Guess mini satchel con animal skin",
            1992.00,
            "Bolso mini Guess tipo satchel Katey Croc; elaborado en " +
                    "material sintético, textura tipo animal skin de cocodrilo, " +
                    "doble asa, correa ajustable para hombro, compartimento " +
                    "principal con cierre y logo a contraste.",
            "bolso"))
        listaBolsos.add(Producto(
            R.drawable.bolso02,
            "Bolso tote",
            "Bolso tote Lacoste",
            2190.00,
            "Bolso Lacoste tipo tote elaborado en material sintético " +
                    "color negro, textura semicorrugada, doble asa rígida, " +
                    "compartimento principal con cierre y logotipo de la marca " +
                    "bordado al frente. Confeccionadas en piel ante.",
            "bolso"))
        listaBolsos.add(Producto(
            R.drawable.bolso03,
            "Bolso Bandolera",
            "Bolso Bandolera Piel Detalle Costuras",
            2795.00,
            "Confeccionado en piel bovina\n" +
                    "Un compartimento principal\n" +
                    "Correa de hombro ajustable\n" +
                    "Cierre mediante imán oculto\n" +
                    "Forro interior en algodón\n",
            "bolso"))
        listaBolsos.add(Producto(
            R.drawable.bolso04,
            "Bolso Trapecio",
            "Bolso Trapecio Mini Piel Pouch Y Bandolera",
            2595.00,
            "Se puede utilizar como pouch de mano o como bolso tipo bandolera\n" +
                    "Confeccionado en piel ovina en acabado acharolado \"roto\"\n" +
                    "Un compartimento principal\n" +
                    "Asa extraíble regulable\n" +
                    "Forro interior en algodón\n",
            "bolso"))
        listaBolsos.add(Producto(
            R.drawable.bolso05,
            "Bolso Sobre",
            "Bolso Sobre Bandolera Piel",
            2295.00,
            "Confeccionado en piel bovina\n" +
                    "Un compartimento principal\n" +
                    "Correa de hombro\n",
            "bolso"))

        listaPulseras.add(Producto(
            R.drawable.pulsera01,
            "Pulsera Amalfi",
            "Amalfi Colore Acero Inoxidable",
            795.00,
            "Pulsera Ajustable a cualquier muñeca\n" +
                    "Cilindro Acero Inoxidable\n" +
                    "Cordón 100% Algodón Tibetano\n",
            "pulsera"))
        listaPulseras.add(Producto(
            R.drawable.pulsera02,
            "Pulsera Bonassola",
            "Bonassola 6 mm Blue / Yellow",
            1495.00,
            "Broche con Imán de Acero Inoxidable\n" +
                    "Cuerda Alto Grado Marítimo\n",
            "pulsera"))
        listaPulseras.add(Producto(
            R.drawable.pulsera03,
            "Pulsera Amalfi",
            "Amalfi Cotton 44",
            795.00,
            "Cilindro Acero Inoxidable\n" +
                    "Cordón 100% Algodón\n",
            "pulsera"))
        listaPulseras.add(Producto(
            R.drawable.pulsera04,
            "Pulsera Piel",
            "Pulsera Piel Doble Trenza",
            749.00,
            "Pulsera trenza tubular\n" +
                    "Pulsera de triple tira\n" +
                    "Confeccionada en piel bovina\n" +
                    "Cierre metálico\n",
            "pulsera"))
        listaPulseras.add(Producto(
            R.drawable.pulsera05,
            "Pulsera Trenzada",
            "Pulsera Trenzada Piel Dos Colores",
            749.00,
            "Pulsera con doble vuelta\n" +
                    "Confeccionada en piel bovina\n" +
                    "Cierre metálico\n",
            "pulsera"))

        listaProductos.add(
            Producto(R.drawable.producto011,
                "Talavera",
                "Xico-Talavera Hoja",
                3950.0,
                "Compañero de sueños y travesias.",
                "otros regalos"))
        listaProductos.add(
            Producto(R.drawable.producto021,
                "Bolsa",
                "Bolsa Cross - Mexpop",
                1800.0,
                "Bolsa de mujer con diseño inspirado en las calaveras de azúcar y " +
                        "los textiles mexicanos.",
                "otros regalos"))
        listaProductos.add(
            Producto(R.drawable.producto031,
                "Carcarsa",
                "Carcasa Xiaomi - Petri Rayada",
                570.0,
                "Carcasa con diseño único inspirado en la cultura y tradiciones " +
                        "de México.",
                "otros regalos"))
        listaProductos.add(
            Producto(R.drawable.producto041,
                "Jarra",
                "Jarra Josefina",
                1250.0,
                "Moldeada en barro y decorada mediante la técnica al negativo, " +
                        "por maestros artesanos de la comunidad de Zinapecuaro, Michoacán.",
                "otros regalos"))
        listaProductos.add(
            Producto(R.drawable.producto051,
                "Máscara",
                "Máscara moldeada",
                4670.0,
                "Máscara moldeada  100% a mano por una de las artesanas más reconocidas " +
                        "de la Comunidad purépecha de Ocumicho, Michoacán.",
                "otros regalos"))
        listaProductos.add(
            Producto(R.drawable.producto061,
                "Taza",
                "Taza Alarzón",
                1970.0,
                "Set de taza + plato moldeados 100% a mano por la maestra artesana " +
                        "Ana Beatriz, en la comunidad zapoteca de Santa María Atzompa, Oaxaca.",
                "otros regalos"))
        listaProductos.add(
            Producto(R.drawable.producto071,
                "Bowl",
                "Bowl Vidrio Pez",
                159.0,
                "Bowl de vidrio en forma de pez en color verde degradado.",
                "otros regalos"))
        listaProductos.add(
            Producto(R.drawable.producto081,
                "Vasija",
                "Vasija Esmaltada con Asas",
                399.0,
                "Vasija en metal esmaltado con asas apta para decorar cualquier " +
                        "estancia de tu casa.",
                "otros regalos"))
        listaProductos.add(
            Producto(R.drawable.producto091,
                "Florero",
                "Florero de barro",
                1199.0,
                "Florero de barro bruñido moldeado y pintado 100% a mano por " +
                        "artesanos purépechas, en la comunidad de Huáncito Chilchota, Michoacán.",
                "otros regalos"))
        listaProductos.add(
            Producto(R.drawable.producto101,
                "Máscara",
                "Máscara Guerrero Purépecha",
                2495.0,
                "Tallada 100 % a mano en madera, por Agustín, maestro artesano de " +
                        "la comunidad de Nuevo San Juan Parangaricutiro, Michoacán.",
                "otros regalos"))

        adaptadorArtesania = AdaptadorArtesania(listaArtesanias)
        recyclerViewArtesanias.adapter = adaptadorArtesania

        adaptadorPerfumes = AdaptadorPerfumes(listaPerfumes)
        recyclerViewPerfumes.adapter = adaptadorPerfumes

        adaptadorBolsos = AdaptadorBolsos(listaBolsos)
        recyclerViewBolsos.adapter = adaptadorBolsos

        adaptadorPulseras = AdaptadorPulseras(listaPulseras)
        recyclerViewPulseras.adapter = adaptadorPulseras

        adaptadorProducto = AdaptadorProducto(listaProductos)
        recyclerViewProductos.adapter = adaptadorProducto

        adaptadorArtesania.onProductoClick = {
            val intent = Intent(this,DetalleProducto::class.java)
            intent.putExtra("producto",it)
            intent.putExtra("usuario",usuario)
            intent.putExtra("misCompras",misCompras)
            startActivity(intent)
        }

        adaptadorPerfumes.onProductoClick = {
            val intent = Intent(this,DetalleProducto::class.java)
            intent.putExtra("producto",it)
            intent.putExtra("usuario",usuario)
            intent.putExtra("misCompras",misCompras)
            startActivity(intent)
        }

        adaptadorBolsos.onProductoClick = {
            val intent = Intent(this,DetalleProducto::class.java)
            intent.putExtra("producto",it)
            intent.putExtra("usuario",usuario)
            intent.putExtra("misCompras",misCompras)
            startActivity(intent)
        }

        adaptadorPulseras.onProductoClick = {
            val intent = Intent(this,DetalleProducto::class.java)
            intent.putExtra("producto",it)
            intent.putExtra("usuario",usuario)
            intent.putExtra("misCompras",misCompras)
            startActivity(intent)
        }

        adaptadorProducto.onProductoClick = {
            val intent = Intent(this,DetalleProducto::class.java)
            intent.putExtra("producto",it)
            intent.putExtra("usuario",usuario)
            intent.putExtra("misCompras",misCompras)
            startActivity(intent)
        }

        btnSalir.setOnClickListener {
            val intent = Intent(this,Login::class.java)
            startActivity(intent)
        }

        btnCarrito.setOnClickListener {
            val intent = Intent(this,Carrito::class.java)
            intent.putExtra("usuario",usuario)
            intent.putExtra("misCompras",misCompras)
            startActivity(intent)
        }
    }
}


