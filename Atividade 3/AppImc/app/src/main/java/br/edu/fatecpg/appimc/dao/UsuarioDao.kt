package br.edu.fatecpg.appimc.dao

import br.edu.fatecpg.appimc.model.Usuario

class UsuarioDao {
    companion object {
        private var novoUsuario = Usuario()

        fun salvar(altura:Double, peso:Double):String {

            var imc:Double = peso/(altura*altura)
            var status:String

            if (imc <= 18.5) {
                status  = "Abaixo do peso"
            } else if (imc >= 18.6 && imc <= 24.9) {
                status  = "Peso normal"
            } else if (imc >= 25.0 && imc <= 29.9) {
                status  = "Acima do peso"
            } else {
                status = "Obeso(a)"
            }

            novoUsuario = Usuario(peso,altura,imc,status)

            return "Usuario salvo com sucesso!"
        }

        fun buscar():Usuario {
            return novoUsuario
        }
    }
}