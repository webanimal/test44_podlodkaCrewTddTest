package ru.webanimal.test44podlodkaCrewTddTest.domain.usecase

import ru.webanimal.test44podlodkaCrewTddTest.data.BandRepository
import ru.webanimal.test44podlodkaCrewTddTest.data.InfoRepository
import ru.webanimal.test44podlodkaCrewTddTest.domain.model.BandFullInfo

class BandUseCase(
    private val bandRepository: BandRepository,
    private val infoRepository: InfoRepository
) {

    operator fun invoke(): BandFullInfo {
        val bandName = bandRepository.getBand().name
        val bandInfo = infoRepository.getInfo().info
        return BandFullInfo(bandName, bandInfo)
    }
}