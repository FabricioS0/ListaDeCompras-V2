package br.com.livrokotlin.listadecompras

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import br.com.livrokotlin.listadecompras.data.ProdutoEntity
import java.text.NumberFormat
import java.util.*

class ProdutoAdapter(context: Context) : ArrayAdapter<ProdutoEntity>(context, 0) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val v = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_view_item, parent, false)

        val item = getItem(position)
        val txtNome = v.findViewById<TextView>(R.id.txt_item_produto)
        val txtQtd = v.findViewById<TextView>(R.id.txt_item_qtd)
        val txtValor = v.findViewById<TextView>(R.id.txt_item_valor)

        item?.let {
            txtNome.text = it.nome
            txtQtd.text = it.quantidade.toString()
            txtValor.text = NumberFormat.getCurrencyInstance(Locale("pt", "BR")).format(it.valor)
        }

        return v
    }
}
