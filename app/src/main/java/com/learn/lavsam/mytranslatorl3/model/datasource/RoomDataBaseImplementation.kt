package com.learn.lavsam.mytranslatorl3.model.datasource

import com.learn.lavsam.mytranslatorl3.model.data.DataModel

class RoomDataBaseImplementation : DataSource<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
