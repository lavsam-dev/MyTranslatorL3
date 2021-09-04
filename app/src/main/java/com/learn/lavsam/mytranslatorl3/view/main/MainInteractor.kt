package com.learn.lavsam.mytranslatorl3.view.main

import com.learn.lavsam.mytranslatorl3.model.data.AppState
import com.learn.lavsam.mytranslatorl3.model.data.DataModel
import com.learn.lavsam.mytranslatorl3.model.repository.Repository
import com.learn.lavsam.mytranslatorl3.viewmodel.Interactor

class MainInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: Repository<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}
