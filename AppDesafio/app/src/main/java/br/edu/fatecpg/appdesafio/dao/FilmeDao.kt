package br.edu.fatecpg.appdesafio.dao

import br.edu.fatecpg.appdesafio.model.Filme

class FilmeDao {
    companion object {
        private val filmes = mutableListOf<Filme>()
        fun salvar(titulo:String,genero:String,poster:String):String {
            filmes.add(Filme(titulo,genero,poster))
            return "Filme adicionado com sucesso!"
        }
        fun buscar():List<Filme>{
            return filmes
        }
        fun deletar(indice: Int):String {
            filmes.removeAt(indice)
            return "Filme removido com sucesso!"
        }
    }
}