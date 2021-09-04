package com.learn.lavsam.mytranslatorl3.viewmodel

interface Interactor<T> {

    fun getData(word: String, fromRemoteSource: Boolean): T
}