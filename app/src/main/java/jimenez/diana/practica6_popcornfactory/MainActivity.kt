package jimenez.diana.practica6_popcornfactory

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_detalle_pelicula.view.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.pelicula.view.*

class MainActivity : AppCompatActivity() {
    var adapter: PeliculaAdapter?=null
    var peliculas = ArrayList<Pelicula>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cargarPeliculas()

        adapter= PeliculaAdapter(this,peliculas)
        gv_peliculas.adapter=adapter
    }

    private fun cargarPeliculas() {
        peliculas.add(Pelicula("Big Hero 6",R.drawable.bighero6,R.drawable.headerbighero6,"When a devastating event befalls the city of San Fransokyo and catapults Hiro into the midst of danger, he turns to Baymax and his close friends adrenaline junkie Go Go Tomago, neatnik Wasabi, chemistry whiz Honey Lemon and fanboy Fred. Determined to uncover the mystery, Hiro transforms his friends into a band of high-tech heroes called \"Big Hero 6.\""))
        peliculas.add(Pelicula("1917",R.drawable.p1917,R.drawable.p1917header,"British trenches somewhere in France. World war has been going on for the third year, heroic illusions have dissipated; general mood - boredom and fatigue. Stuff the belly, sleep, return home to Christmas Eve. On another quiet day, when nothing happens, two young soldiers, Blake and Schofield, are summoned to the general, who instructs them to send an important message to Colonel MacKenzie in the Second Devonshire Battalion, whose telephone connection was cut off by the enemy."))
        peliculas.add(Pelicula("Leap year",R.drawable.leapyear,R.drawable.leapyearheader,"A woman who has an elaborate scheme to propose to her boyfriend on Leap Day, an Irish tradition which occurs every time the date February 29 rolls around, faces a major setback when bad weather threatens to derail her planned trip to Dublin. With the help of an innkeeper, however, her cross-country odyssey just might result in her getting engaged."))
        peliculas.add(Pelicula("Men in Black",R.drawable.mib,R.drawable.mibheader,"Based off of the comic book. Unbeknownst to other people, there is a private agency code named MiB. This agency is some kind of extra terrestrial surveillance corporation. Then, one of the agency's finest men only going by the name \"K\" (Tommy Lee Jones) , is recruiting for a new addition to the agency. He has chosen James Edwards (Will Smith) of the N.Y.P.D. Then, one day, a flying saucer crashes into Earth. This was an alien a part of the \"Bug\" race. He takes the body of a farmer (Vincent D'Onofrio) and heads to New York. He is searching for a super energy source called \"The Galaxy\". Now, Agents J and K must stop the bug before it can escape with the galaxy.\n"))
        peliculas.add(Pelicula("Toy Story",R.drawable.toystory,R.drawable.toystoryheader,"Toy Story is about the 'secret life of toys' when people are not around. When Buzz Lightyear, a space-ranger, takes Woody's place as Andy's favorite toy, Woody doesn't like the situation and gets into a fight with Buzz. Accidentaly Buzz falls out the window and Woody is accused by all the other toys of having killed him. He has to go out of the house to look for him so that they can both return to Andys room. But while on the outside they get into all kind of trouble while trying to get home."))
        peliculas.add(Pelicula("Inception",R.drawable.inception,R.drawable.inceptionheader,"Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious during the dream state, when the mind is at its most vulnerable. Cobb's rare ability has made him a coveted player in this treacherous new world of corporate espionage, but it has also made him an international fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at redemption. One last job could give him his life back but only if he can accomplish the impossible, inception. Instead of the perfect heist, Cobb and his team of specialists have to pull off the reverse: their task is not to steal an idea, but to plant one. If they succeed, it could be the perfect crime. But no amount of careful planning or expertise can prepare the team for the dangerous enemy that seems to predict their every move. An enemy that only Cobb could have seen coming."))

    }
}
 class PeliculaAdapter: BaseAdapter{
     var peliculas= ArrayList<Pelicula>()
     var contexto: Context?=null

     constructor(context: Context, peliculas: ArrayList<Pelicula>){
         this.contexto=context
         this.peliculas=peliculas
     }


     /**
      * Get a View that displays the data at the specified position in the data set. You can either
      * create a View manually or inflate it from an XML layout file. When the View is inflated, the
      * parent View (GridView, ListView...) will apply default layout parameters unless you use
      * [android.view.LayoutInflater.inflate]
      * to specify a root view and to prevent attachment to the root.
      *
      * @param position The position of the item within the adapter's data set of the item whose view
      * we want.
      * @param convertView The old view to reuse, if possible. Note: You should check that this view
      * is non-null and of an appropriate type before using. If it is not possible to convert
      * this view to display the correct data, this method can create a new view.
      * Heterogeneous lists can specify their number of view types, so that this View is
      * always of the right type (see [.getViewTypeCount] and
      * [.getItemViewType]).
      * @param parent The parent that this view will eventually be attached to
      * @return A View corresponding to the data at the specified position.
      */
     override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
         var pelicula = peliculas[position]
         var inflator= contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
         var vista= inflator.inflate(R.layout.pelicula, null)

         vista.iv_imagen.setImageResource(pelicula.image)
         vista.tv_title.setText(pelicula.titulo)

         vista.iv_imagen.setOnClickListener(){
             var intent= Intent(contexto,DetallePelicula::class.java)
             intent.putExtra("titulo", pelicula.titulo)
             intent.putExtra("image", pelicula.image)
             intent.putExtra("header", pelicula.header)
             intent.putExtra("sipnosis", pelicula.sipnosis)
             contexto!!.startActivity(intent)
         }
         return vista;
     }

     /**
      * Get the data item associated with the specified position in the data set.
      *
      * @param position Position of the item whose data we want within the adapter's
      * data set.
      * @return The data at the specified position.
      */
     override fun getItem(position: Int): Any {
         return peliculas[position]
     }

     /**
      * Get the row id associated with the specified position in the list.
      *
      * @param position The position of the item within the adapter's data set whose row id we want.
      * @return The id of the item at the specified position.
      */
     override fun getItemId(position: Int): Long {
         return position.toLong()
     }

     /**
      * How many items are in the data set represented by this Adapter.
      *
      * @return Count of items.
      */
     override fun getCount(): Int {
         return peliculas.size
     }


 }
