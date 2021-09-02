package com.learn.lavsam.mytranslatorl3.model.repository

import com.learn.lavsam.mytranslatorl3.model.data.DataModel
import com.learn.lavsam.mytranslatorl3.model.datasource.DataSource

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}
