package br.com.livrokotlin.listadecompras.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "produtos")
data class ProdutoEntity(
        @PrimaryKey(autoGenerate = true) val id: Int = 0,
        val nome: String,
        val quantidade: Int,
        val valor: Double
)
