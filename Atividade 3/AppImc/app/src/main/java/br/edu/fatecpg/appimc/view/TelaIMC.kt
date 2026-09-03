package br.edu.fatecpg.appimc.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.appimc.R
import br.edu.fatecpg.appimc.dao.UsuarioDao
import br.edu.fatecpg.appimc.model.Usuario
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TelaIMC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_imc)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txvAltura = findViewById<TextView>(R.id.txv_altura)
        val txvPeso = findViewById<TextView>(R.id.txv_peso)
        val txvIMC = findViewById<TextView>(R.id.txv_imc)
        val txvStatus = findViewById<TextView>(R.id.txv_status)
        val fabVoltar = findViewById<FloatingActionButton>(R.id.fab_voltar)

        val altura = UsuarioDao.buscar().altura
        val peso = UsuarioDao.buscar().peso
        val imc = UsuarioDao.buscar().imc
        val status = UsuarioDao.buscar().status

        txvAltura.setText("Altura: ${altura}")
        txvPeso.setText("Peso: ${peso}")
        txvIMC.setText("IMC: ${imc}")
        txvStatus.setText("${status}")

        fabVoltar.setOnClickListener {
            finish()
        }
    }
}