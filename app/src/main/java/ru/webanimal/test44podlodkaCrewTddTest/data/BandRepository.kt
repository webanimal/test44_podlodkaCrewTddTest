package ru.webanimal.test44podlodkaCrewTddTest.data

import ru.webanimal.test44podlodkaCrewTddTest.domain.model.BandName

interface BandRepository {
    fun getBand(): BandName
}

class BandRepositoryImpl(
    private val localDataSource: BandDataSource,
    private val remoteDataSource: BandDataSource
): BandRepository {

    override fun getBand(): BandName {
        return try {
            localDataSource.getBand()

        } catch (throwable: IllegalStateException) {
            remoteDataSource.getBand()
        }
    }
}