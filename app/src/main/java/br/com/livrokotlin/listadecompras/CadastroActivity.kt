package br.com.livrokotlin.listadecompras

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import	android.support.v7.app.AppCompatActivity
import	kotlinx.android.synthetic.main.activity_cadastro.*

class	CadastroActivity	:	AppCompatActivity()	{
    override	fun	onCreate(savedInstanceState:	Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)


        btn_inserir.setOnClickListener {

            val	produto	=	txt_produto.text.toString()
            val	qtd	=	txt_qtd.text.toString()
            val	valor	=	txt_valor.text.toString()

            if	(produto.isNotEmpty()	&&	qtd.isNotEmpty()		&&	valor.isNotEmpty())	{
            val	prod	=	Produto(produto,	qtd.toInt(),	valor.toDouble())
            produtosGlobal.add(prod)
            txt_produto.text.clear()
            txt_qtd.text.clear()
            txt_valor.text.clear()
        }else{
            txt_produto.error	=	if	(txt_produto.text.isEmpty())	"Preencha	o	nome	do	produto"	else	null
            txt_qtd.error	=	if	(txt_qtd.text.isEmpty())	"Preencha	a	quantidade"	else	null
            txt_valor.error	=	if	(txt_valor.text.isEmpty())	"Preencha o	valor"	else	null
        }
        }
        }
    }
}

