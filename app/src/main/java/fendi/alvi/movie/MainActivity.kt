package fendi.alvi.movie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tombolAksi: Button = findViewById(R.id.buttonGanti)
        tombolAksi.setOnClickListener {
            ubahAngka()
        }
    }

    private fun ubahAngka() {

        //mengubah isi textbox
        val txtHello: TextView = findViewById(R.id.txtdadu1)
        val image1: ImageView = findViewById(R.id.imageView4)
        isiGambar(txtHello, image1)

        val txtDadu2: TextView = findViewById(R.id.txtdadu2)
        val image2: ImageView = findViewById(R.id.imageView5)
        isiGambar(txtDadu2, image2)


        val txtDadu3: TextView = findViewById(R.id.txtdadu3)
        val image3: ImageView = findViewById(R.id.imageView6)
        isiGambar(txtDadu3, image3)

    }

    private fun isiGambar(txtHello: TextView, image1: ImageView) {
        val tes = (1 until 6).random()
        txtHello.text = tes.toString()

        when (tes) {
            1 -> image1.setImageDrawable(getDrawable(R.drawable.ph1))
            2 -> image1.setImageDrawable(getDrawable(R.drawable.ph2))
            3 -> image1.setImageDrawable(getDrawable(R.drawable.ph3))
            4 -> image1.setImageDrawable(getDrawable(R.drawable.ph4))
            5 -> image1.setImageDrawable(getDrawable(R.drawable.ph5))
            else -> { // Note the block
                image1.setImageDrawable(getDrawable(R.drawable.ph6))
            }
        }
        fun pindahPage(view: View) {
            val intent = Intent(this, ListMovie::class.java).apply {
                // putExtra(, message)
            }
            startActivity(intent)
        }

    }
}






