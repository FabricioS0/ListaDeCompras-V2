package br.com.livrokotlin.listadecompras

import ProdutoAdapter
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.list_view_produtos)
        val btnInserir = findViewById<Button>(R.id.btn_inserir)
        val txtProduto = findViewById<EditText>(R.id.txt_produto


        val	produtosAdapter	=	ProdutoAdapter(this)

        list_view_produtos	: override	fun	onResume()	{
            super.onResume()
            val	adapter	=	list_view_produtos.adapter	as	ProdutoAdapter
            adapter.clear()
            adapter.addAll(produtosGlobal)
        }


        btn_adicionar.setOnClickListener	{
            //Criando	a	Intent	explícita
            val	intent	=	Intent(this,	CadastroActivity::class.java)
            //iniciando	a	atividade
            startActivity(intent)
        }

        listView.setOnItemLongClickListener{
            adapterview: AdapterView<*>, view: View, position: Int, id: Long ->

            val item = produtosAdapter.getItem(position)

            produtosAdapter.remove(item)

            true
        }
    }
}
