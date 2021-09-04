package com.learn.lavsam.mytranslatorl3.model.repository

import io.reactivex.Observable

interface Repository<T> {

    suspend fun getData(word: String): T
}