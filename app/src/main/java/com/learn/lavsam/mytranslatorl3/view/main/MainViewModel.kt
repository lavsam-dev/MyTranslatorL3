package com.learn.lavsam.mytranslatorl3.view.main

import androidx.lifecycle.LiveData
import com.learn.lavsam.mytranslatorl3.model.data.AppState
import com.learn.lavsam.mytranslatorl3.model.datasource.DataSourceLocal
import com.learn.lavsam.mytranslatorl3.model.datasource.DataSourceRemote
import com.learn.lavsam.mytranslatorl3.model.repository.RepositoryImplementation
import com.learn.lavsam.mytranslatorl3.viewmodel.BaseViewModel
import io.reactivex.observers.DisposableObserver

class MainViewModel(
    private val interactor: MainInteractor = MainInteractor(
        RepositoryImplementation(DataSourceRemote()),
        RepositoryImplementation(DataSourceLocal())
    )
) : BaseViewModel<AppState>() {

    private var appState: AppState? = null

    override fun getData(word: String, isOnline: Boolean): LiveData<AppState> {
        compositeDisposable.add(
            interactor.getData(word, isOnline)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe { liveDataForViewToObserve.value = AppState.Loading(null) }
                .subscribeWith(getObserver())
        )
        return super.getData(word, isOnline)
    }

    private fun getObserver(): DisposableObserver<AppState> {
        return object : DisposableObserver<AppState>() {

            override fun onNext(state: AppState) {
                appState = state
                liveDataForViewToObserve.value = state
            }

            override fun onError(e: Throwable) {
                liveDataForViewToObserve.value = AppState.Error(e)
            }

            override fun onComplete() {
            }
        }
    }
}
