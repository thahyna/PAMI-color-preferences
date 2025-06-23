 package android.thayna.etimpamithaynapreferenciasdecores

import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.thayna.etimpamithaynapreferenciasdecores.databinding.ActivityMainBinding
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

 class MainActivity : AppCompatActivity() {
     private lateinit var binding: ActivityMainBinding
     private lateinit var preferencias: SharedPreferences

     companion object {
         const val NOME_ARQ = "arquivo_prefs.xml"
     }


     override fun onCreate(savedInstanceState: Bundle?) {
         binding = ActivityMainBinding.inflate(layoutInflater)
         super.onCreate(savedInstanceState)

         setContentView(binding.root)
         var cor = ""

         binding.btnCor1.setOnClickListener {
             cor = "#C70808"
             salvarCor(cor)
         }

         binding.btnCor2.setOnClickListener {
             cor = "#673AB7"
             salvarCor(cor)
         }

         binding.btnCor3.setOnClickListener {
             cor = "#3A0014"
             salvarCor(cor)
         }

         binding.btnCor4.setOnClickListener {
             cor = "#E91E63"
             salvarCor(cor)
         }

         binding.btnCor5.setOnClickListener {
             cor = "#5D9B4D"
             salvarCor(cor)
         }

     }

     override fun onResume() {
         super.onResume()

         val preferencias = getSharedPreferences(NOME_ARQ, MODE_PRIVATE)
         val cor = preferencias.getString("Cor", "")

         if (cor!!.isNotEmpty()){
             binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
         }


     }

     private fun salvarCor(cor: String) {

         binding.btnTrocar.setOnClickListener { view ->
             if (cor.isNotEmpty()) {
                 binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
                 snackBar(view)
             }

         }

         val preferencias = getSharedPreferences(NOME_ARQ, MODE_PRIVATE)
         val editor = preferencias.edit()
         editor.putString("cor", cor)
         editor.putString("nome", "Thayna")
         editor.putString("email", "thayna@gmail.com")
         editor.apply()


     }


    private fun snackBar(view: View){
        val snackbar = Snackbar.make(view, "Cor de fundo alterada com sucesso!", Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction("OK"){

        }

        snackbar.setActionTextColor(Color.BLUE)
        snackbar.setBackgroundTint(Color.BLACK)
        snackbar.setTextColor(Color.WHITE)
        snackbar.show()

    }
}