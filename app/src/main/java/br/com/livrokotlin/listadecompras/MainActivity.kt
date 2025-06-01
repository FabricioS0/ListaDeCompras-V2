package br.com.livrokotlin.listadecompras

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import br.com.livrokotlin.listadecompras.data.AppDatabase
import br.com.livrokotlin.listadecompras.data.ProdutoEntity
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var btnAdicionar: Button
    private lateinit var adapter: ProdutoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list_view_produtos)
        btnAdicionar = findViewById(R.id.btn_inserir)

        adapter = ProdutoAdapter(this)
        listView.adapter = adapter

        btnAdicionar.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
        }

        listView.setOnItemLongClickListener { _, _, position, _ ->
            val item = adapter.getItem(position)
            if (item != null) {
                lifecycleScope.launch {
                    AppDatabase.getDatabase(this@MainActivity).produtoDao().deletar(item)
                    carregarProdutos()
                }
            }
            true
        }
    }

    override fun onResume() {
        super.onResume()
        carregarProdutos()
    }

    private fun carregarProdutos() {
        val dao = AppDatabase.getDatabase(this).produtoDao()
        lifecycleScope.launch {
            val produtos = dao.listarTodos()
            adapter.clear()
            adapter.addAll(produtos)
        }
    }
}
