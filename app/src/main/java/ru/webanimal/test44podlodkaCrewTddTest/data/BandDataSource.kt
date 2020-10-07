package ru.webanimal.test44podlodkaCrewTddTest.data

import ru.webanimal.test44podlodkaCrewTddTest.domain.model.BandName

interface BandDataSource {
    fun getBand(): BandName
}