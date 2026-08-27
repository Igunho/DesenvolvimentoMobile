package br.edu.fatecpg.appcadastroaluno

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.random.Random

class DetalhesAluno : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes_aluno)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txvAluno = findViewById<TextView>(R.id.txv_aluno)
        val txvMatricula = findViewById<TextView>(R.id.txv_matricula)
        val fabVoltar = findViewById<FloatingActionButton>(R.id.fab_voltar)

        val matricula = Random.nextInt(0,1000)

        txvAluno.setText("Nome: "+intent.getStringExtra("nomeAluno"))
        txvMatricula.setText("Matricula: "+matricula.toString())

        fabVoltar.setOnClickListener {
            finish()
        }
    }
}