package br.edu.fatecpg.appdesafio.adapter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.appdesafio.model.Filme
import br.edu.fatecpg.appdesafio.R
import br.edu.fatecpg.appdesafio.dao.FilmeDao
import java.util.concurrent.Executors

class FilmeAdapter(private val filmes:List<Filme>):
    RecyclerView.Adapter<FilmeAdapter.ViewHolder>() {

    //Executor, converte a url de algum modo
    val executor = Executors.newSingleThreadExecutor()
    //Handler carrega a imagem no image view depois de convertido
    val handler = Handler(Looper.getMainLooper())
    //Inicializa a imagem como bitmap
    var image:Bitmap? = null

    class ViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView){
            val txvTitulo = itemView.findViewById<TextView>(R.id.txv_titulo)
            val txvGenero = itemView.findViewById<TextView>(R.id.txv_genero)
            val imageView = itemView.findViewById<ImageView>(R.id.imv_poster)
            val btnDeletar = itemView.findViewById<Button>(R.id.btn_excluir)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_lista,parent,false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return filmes.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.txvTitulo.text = filmes[position].titulo
            holder.txvGenero.text = filmes[position].genero

            holder.btnDeletar.setOnClickListener {
                FilmeDao.deletar(position)
                notifyDataSetChanged()
            }

            //Aparentemente executa processo no background
            executor.execute {
                //Url da imagem
                val imageURL = filmes[position].poster

                try {
                    //define img como openStream de url
                    val img = java.net.URL(imageURL).openStream()
                    //Carrega a url como bitmap
                    image = BitmapFactory.decodeStream(img)

                    //Utiliza o handler para setar o bitmap do image view
                    handler.post {
                        holder.imageView.setImageBitmap(image)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
}
