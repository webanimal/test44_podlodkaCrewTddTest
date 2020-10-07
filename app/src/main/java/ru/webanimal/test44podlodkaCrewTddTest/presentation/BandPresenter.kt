package ru.webanimal.test44podlodkaCrewTddTest.presentation

import ru.webanimal.test44podlodkaCrewTddTest.domain.usecase.BandUseCase

class BandPresenter(
    private val useCase: BandUseCase
) {

    fun onAttach(view: BandView) {
        val fullInfo = useCase()

        view.setName(fullInfo.name)
        view.setInfo(fullInfo.info)
    }
}