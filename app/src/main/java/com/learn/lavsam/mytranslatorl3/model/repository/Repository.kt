package com.learn.lavsam.mytranslatorl3.model.repository

import io.reactivex.Observable

interface Repository<T> {

    fun getData(word: String): Observable<T>
}