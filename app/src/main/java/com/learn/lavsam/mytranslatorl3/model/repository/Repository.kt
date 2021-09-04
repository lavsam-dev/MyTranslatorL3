package com.learn.lavsam.mytranslatorl3.model.repository

interface Repository<T> {

    suspend fun getData(word: String): T
}