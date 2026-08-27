package br.edu.fatecpg.appcadastrolivros

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtLivro = findViewById<EditText>(R.id.edt_nome_livro)
        val edtAutor = findViewById<EditText>(R.id.edt_autor)
        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)
        val fabDetalhes = findViewById<FloatingActionButton>(R.id.fab_detalhes)
        
        var nomeLivro = ""
        var nomeAutor = ""

        val intent = Intent(this, DetalhesLivro::class.java)
        
        btnCadastrar.setOnClickListener {
            nomeLivro = edtLivro.text.toString()
            nomeAutor = edtAutor.text.toString()

            Toast.makeText(this, "Livro cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
            intent.putExtra("nomeLivro",nomeLivro)
            intent.putExtra("nomeAutor",nomeAutor)
        }

        fabDetalhes.setOnClickListener {
            if (nomeLivro == "" || nomeAutor == "") {
                Toast.makeText(this, "Um ou mais campos não foram preenchidos", Toast.LENGTH_SHORT).show()
            } else {
                startActivity(intent)
            }
        }
        
    }
}