package br.edu.fatecpg.appdesafio.view

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.appdesafio.R
import br.edu.fatecpg.appdesafio.adapter.FilmeAdapter
import br.edu.fatecpg.appdesafio.dao.FilmeDao
import br.edu.fatecpg.appdesafio.model.Filme
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvUsuarios = findViewById<RecyclerView>(R.id.rv_filmes)
        val fabVolta = findViewById<FloatingActionButton>(R.id.fab_voltar)

        rvUsuarios.adapter = FilmeAdapter(FilmeDao.buscar())
        rvUsuarios.layoutManager = LinearLayoutManager(this)

        fabVolta.setOnClickListener {
            finish()
        }

    }
}