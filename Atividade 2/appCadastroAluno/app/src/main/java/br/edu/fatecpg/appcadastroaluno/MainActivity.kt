package br.edu.fatecpg.appcadastroaluno

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

        val edtNome = findViewById<EditText>(R.id.edt_aluno)
        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)
        val fabCadastrado = findViewById<FloatingActionButton>(R.id.fab_cadastrado)

        var nomeAluno = ""

        val intent = Intent(this,DetalhesAluno::class.java)

        btnCadastrar.setOnClickListener {
            nomeAluno = edtNome.text.toString()
            intent.putExtra("nomeAluno",nomeAluno)
            Toast.makeText(this, "Aluno cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
        }

        fabCadastrado.setOnClickListener {
            if (nomeAluno == "") {
                Toast.makeText(this, "Nome invalido!", Toast.LENGTH_SHORT).show()
            } else {
                startActivity(intent)
            }
        }
    }
}