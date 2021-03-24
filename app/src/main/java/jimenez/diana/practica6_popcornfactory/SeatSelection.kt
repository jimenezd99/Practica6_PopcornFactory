package jimenez.diana.practica6_popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_seat_selection.*

class SeatSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)

        val bundle= intent.extras
        var posMovie=-1
        //var seat=-1
        var seat: RadioButton? =null

        if(bundle!=null){
            tv_titleSeats.setText(bundle.getString("name"))
            posMovie=bundle.getInt("id")
        }

        btn_confirm.setOnClickListener() {
            //to do añadir lógica para reservar el lugar por el usuario
            val intent: Intent = Intent(this, ConfirmActivity::class.java)

            rg_row1.setOnCheckedChangeListener { group, checkedId ->
                if(checkedId>-1){
                    rg_row2.clearCheck()
                    rg_row3.clearCheck()
                    rg_row4.clearCheck()
                    seat=findViewById(checkedId)
                    rg_row1.check(checkedId)
                }
            }

            rg_row2.setOnCheckedChangeListener { group, checkedId ->
                if(checkedId>-1){
                    rg_row1.clearCheck()
                    rg_row3.clearCheck()
                    rg_row4.clearCheck()
                    seat=findViewById(checkedId)
                    rg_row2.check(checkedId)
                }
            }

            rg_row3.setOnCheckedChangeListener { group, checkedId ->
                if(checkedId>-1){
                    rg_row1.clearCheck()
                    rg_row2.clearCheck()
                    rg_row3.clearCheck()
                    seat=findViewById(checkedId)
                    rg_row3.check(checkedId)
                }
            }

            rg_row4.setOnCheckedChangeListener { group, checkedId ->
                if(checkedId>-1){
                    rg_row1.clearCheck()
                    rg_row2.clearCheck()
                    rg_row3.clearCheck()
                    seat=findViewById(checkedId)
                    rg_row4.check(checkedId)
                }
            }


            //seat=7
            intent.putExtra("seat", seat?.text)
            intent.putExtra("id",posMovie)
            intent.putExtra("name", tv_titleSeats.text)
            //Toast.makeText(this, tv_titleSeats.text, Toast.LENGTH_LONG)
            this.startActivity(intent)
        }

    }
}