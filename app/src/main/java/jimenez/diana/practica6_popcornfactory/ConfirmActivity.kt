package jimenez.diana.practica6_popcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_confirm.*
import kotlinx.android.synthetic.main.activity_detalle_pelicula.*

class ConfirmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)
        //agregar el nombre de la pelicula y el asiento que se seleccionó

        val bundle= intent.extras
        var seat=-1
        var movie=""
        if(bundle!=null) {
            seat=bundle.getInt("seat")
            movie= bundle.getString("name").toString()
            tv_titleMovie.setText("Película: $movie ")
            tv_NumSeat.setText("Asiento  #$seat ")
        }



    }
}