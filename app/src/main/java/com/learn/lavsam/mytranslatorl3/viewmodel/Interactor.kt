package com.learn.lavsam.mytranslatorl3.viewmodel

interface Interactor<T> {

    suspend fun getData(word: String, fromRemoteSource: Boolean): T
}
