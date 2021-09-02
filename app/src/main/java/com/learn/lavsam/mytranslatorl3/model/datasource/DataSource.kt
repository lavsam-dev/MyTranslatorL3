package com.learn.lavsam.mytranslatorl3.model.datasource

interface DataSource<T> {

    suspend fun getData(word: String): T
}
