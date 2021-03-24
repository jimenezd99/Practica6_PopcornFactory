package jimenez.diana.practica6_popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalle_pelicula.*

class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        val bundle= intent.extras
        var ns=0
        var id=-1
        var title=""

        if(bundle!=null){
            ns=bundle.getInt("numberSeats")
            title=bundle.getString("titulo")!!
            iv_pelicula_imagen.setImageResource(bundle.getInt("header"))
            tv_pelicula_titulo.setText(bundle.getString("titulo"))
            tv_pelicula_desc.setText(bundle.getString("sipnosis"))
            seatsLeft.setText("$ns seats avalible")
            id=bundle.getInt("pos")
        }

        if(ns==0){
            buyTicket.isEnabled=false
        }else{
            buyTicket.setOnClickListener {
                buyTicket.isEnabled=true
                val intent: Intent = Intent(this, SeatSelection::class.java)

                intent.putExtra("id",id)
                intent.putExtra("name", title)
                this.startActivity(intent)
            }
        }

    }
}