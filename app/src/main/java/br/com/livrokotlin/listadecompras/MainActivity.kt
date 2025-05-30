package br.com.livrokotlin.listadecompras

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var listView: ListView
    lateinit var btnAdicionar: Button
    lateinit var adapter: ProdutoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list_view_produtos)
        btnAdicionar = findViewById(R.id.btn_inserir)

        adapter = ProdutoAdapter(this)
        listView.adapter = adapter

        btnAdicionar.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

        listView.setOnItemLongClickListener { _, _, position, _ ->
            val item = adapter.getItem(position)
            adapter.remove(item)
            true
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.clear()
        adapter.addAll(produtosGlobal)
    }
}
