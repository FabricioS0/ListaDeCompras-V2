package br.com.livrokotlin.listadecompras

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import br.com.livrokotlin.listadecompras.data.AppDatabase
import br.com.livrokotlin.listadecompras.data.ProdutoEntity
import br.com.livrokotlin.listadecompras.databinding.ActivityCadastroBinding
import kotlinx.coroutines.launch

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dao = AppDatabase.getDatabase(this).produtoDao()

        binding.btnInserir.setOnClickListener {
            val nome = binding.txtProduto.text.toString()
            val qtd = binding.txtQtd.text.toString().toIntOrNull()
            val valor = binding.txtValor.text.toString().toDoubleOrNull()

            if (nome.isNotEmpty() && qtd != null && valor != null) {
                val produto = ProdutoEntity(nome = nome, quantidade = qtd, valor = valor)

                lifecycleScope.launch {
                    dao.inserir(produto)
                    finish()
                }
            } else {
                if (nome.isEmpty()) binding.txtProduto.error = "Preencha o nome"
                if (qtd == null) binding.txtQtd.error = "Preencha a quantidade"
                if (valor == null) binding.txtValor.error = "Preencha o valor"
            }
        }
    }
}
