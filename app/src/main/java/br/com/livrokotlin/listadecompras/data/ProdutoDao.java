package br.com.livrokotlin.listadecompras.data

import androidx.room.*

@Dao
interface ProdutoDao {
    @Insert
    suspend fun inserir(produto: ProdutoEntity)

    @Delete
    suspend fun deletar(produto: ProdutoEntity)

    @Query("SELECT * FROM produtos")
    suspend fun listarTodos(): List<ProdutoEntity>
}
