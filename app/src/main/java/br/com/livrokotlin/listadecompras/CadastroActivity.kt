package br.com.livrokotlin.listadecompras

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.livrokotlin.listadecompras.Utils.Companion.produtosGlobal
import br.com.livrokotlin.listadecompras.databinding.ActivityCadastroBinding

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnInserir.setOnClickListener {

            val nome = binding.txtProduto.text.toString()
            val qtd = binding.txtQtd.text.toString()
            val valor = binding.txtValor.text.toString()

            if (nome.isNotEmpty() && qtd.isNotEmpty() && valor.isNotEmpty()) {
                val produto = Produto(nome, qtd.toInt(), valor.toDouble())
                produtosGlobal.add(produto)

                binding.txtProduto.text.clear()
                binding.txtQtd.text.clear()
                binding.txtValor.text.clear()

                finish() // Volta para MainActivity
            } else {
                if (nome.isEmpty()) binding.txtProduto.error = "Preencha o nome do produto"
                if (qtd.isEmpty()) binding.txtQtd.error = "Preencha a quantidade"
                if (valor.isEmpty()) binding.txtValor.error = "Preencha o valor"
            }
        }
    }
}
