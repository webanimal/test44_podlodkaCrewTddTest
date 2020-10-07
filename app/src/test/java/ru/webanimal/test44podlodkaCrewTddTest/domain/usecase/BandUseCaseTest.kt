package ru.webanimal.test44podlodkaCrewTddTest.domain.usecase

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.*
import org.junit.Test
import ru.webanimal.test44podlodkaCrewTddTest.data.BandRepository
import ru.webanimal.test44podlodkaCrewTddTest.data.InfoRepository
import ru.webanimal.test44podlodkaCrewTddTest.domain.model.BandFullInfo
import ru.webanimal.test44podlodkaCrewTddTest.domain.model.BandInfo
import ru.webanimal.test44podlodkaCrewTddTest.domain.model.BandName

class BandUseCaseTest {

    private val bandRepository: BandRepository = mock()
    private val infoRepository: InfoRepository = mock()
    private val useCase: BandUseCase = BandUseCase(bandRepository, infoRepository)

    @Test
    fun `run band use case EXPECT band full info`() {
        val bandName = BandName("Some band name")
        val bandInfo = BandInfo("Some band info")
        val expected = BandFullInfo(bandName.name, bandInfo.info)

        whenever(bandRepository.getBand()).thenReturn(bandName)
        whenever(infoRepository.getInfo()).thenReturn(bandInfo)

        val fullInfo = useCase()

        assertEquals(expected, fullInfo)
    }
}