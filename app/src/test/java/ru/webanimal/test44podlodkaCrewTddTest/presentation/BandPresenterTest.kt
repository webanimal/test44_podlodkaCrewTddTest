package ru.webanimal.test44podlodkaCrewTddTest.presentation

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Test
import ru.webanimal.test44podlodkaCrewTddTest.domain.model.BandFullInfo
import ru.webanimal.test44podlodkaCrewTddTest.domain.usecase.BandUseCase

class BandPresenterTest {

    private val useCase: BandUseCase = mock()
    private val presenter = BandPresenter(useCase)
    private val view: BandView = mock()

    @Test
    fun `test`() {
        val expected = BandFullInfo("name", "info")

        whenever(useCase.invoke()).thenReturn(expected)

        presenter.onAttach(view)

        verify(view).setName(expected.name)
        verify(view).setInfo(expected.info)
    }
}