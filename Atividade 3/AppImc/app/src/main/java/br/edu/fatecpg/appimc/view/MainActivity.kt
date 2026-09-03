package br.edu.fatecpg.appimc.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.appimc.R
import br.edu.fatecpg.appimc.dao.UsuarioDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtAltura = findViewById<EditText>(R.id.edt_altura)
        val edtPeso = findViewById<EditText>(R.id.edt_peso)
        val btnSalvar = findViewById<Button>(R.id.btn_salvar)
        val fabCalcula = findViewById<FloatingActionButton>(R.id.fab_calcular)

        btnSalvar.setOnClickListener {
            var altura = edtAltura.text.toString().toDouble()
            var peso = edtPeso.text.toString().toDouble()

            UsuarioDao.salvar(altura,peso)
            Toast.makeText(this, "Dados salvos com sucesso", Toast.LENGTH_SHORT).show()
        }

        fabCalcula.setOnClickListener {
            val intent = Intent(this,TelaIMC::class.java)

            startActivity(intent)
        }
    }
}