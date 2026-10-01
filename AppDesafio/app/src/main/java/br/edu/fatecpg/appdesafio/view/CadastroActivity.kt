package br.edu.fatecpg.appdesafio.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.appdesafio.R
import br.edu.fatecpg.appdesafio.dao.FilmeDao
import br.edu.fatecpg.appdesafio.model.Filme
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val titulo = findViewById<EditText>(R.id.edt_titulo)
        val genero = findViewById<EditText>(R.id.edt_genero)
        val poster = findViewById<EditText>(R.id.edt_poster)
        val btn_salvar = findViewById<Button>(R.id.btn_salvar)
        val fab_lista = findViewById<FloatingActionButton>(R.id.fab_lista)

        btn_salvar.setOnClickListener {
            FilmeDao.salvar(titulo.text.toString(),genero.text.toString(),poster.text.toString())

            Toast.makeText(this, "Filme adicionado com sucesso!", Toast.LENGTH_SHORT).show()
        }

        fab_lista.setOnClickListener {
            val intent = Intent(this, ListaActivity::class.java)
            startActivity(intent)
        }
    }
}