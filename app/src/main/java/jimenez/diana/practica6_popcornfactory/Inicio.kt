package jimenez.diana.practica6_popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        val button: Button = findViewById<Button>(R.id.btn_start)

        button.setOnClickListener(){
            var intent: Intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}