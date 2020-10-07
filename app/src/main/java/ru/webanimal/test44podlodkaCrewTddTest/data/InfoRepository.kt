package ru.webanimal.test44podlodkaCrewTddTest.data

import ru.webanimal.test44podlodkaCrewTddTest.domain.model.BandInfo

interface InfoRepository {
    fun getInfo(): BandInfo
}

class InfoRepositoryImpl: InfoRepository {
    override fun getInfo(): BandInfo {
        return BandInfo()
    }
}