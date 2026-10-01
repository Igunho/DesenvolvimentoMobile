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

        val edt_usuario = findViewById<EditText>(R.id.edt_usuario)
        val edt_senha = findViewById<EditText>(R.id.edt_senha)
        val btn_entrar = findViewById<Button>(R.id.btn_entrar)

        val user = "admin"
        val senha = "admin"

        val intent = Intent(this, CadastroActivity::class.java)

        btn_entrar.setOnClickListener {
            var usu = edt_usuario.text.toString()
            var sen = edt_senha.text.toString()

            if (usu.equals(user) && sen.equals(senha)) {
                Toast.makeText(this, "Usuário correto", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuário ou senha invalido", Toast.LENGTH_LONG).show()
            }
        }
    }
}