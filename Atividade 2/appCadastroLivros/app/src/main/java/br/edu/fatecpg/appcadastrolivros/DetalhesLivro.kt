package br.edu.fatecpg.appcadastrolivros

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetalhesLivro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes_livro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txvLivro = findViewById<TextView>(R.id.txv_nome_livro)
        val txvAutor = findViewById<TextView>(R.id.txv_nome_autor)
        val fabVoltar = findViewById<FloatingActionButton>(R.id.fab_voltar)

        txvLivro.setText("Livro: "+intent.getStringExtra("nomeLivro"))
        txvAutor.setText("Autor: "+intent.getStringExtra("nomeAutor"))

        fabVoltar.setOnClickListener {
            finish()
        }
    }
}