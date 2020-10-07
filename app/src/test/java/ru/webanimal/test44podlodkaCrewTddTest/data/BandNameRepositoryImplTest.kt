package ru.webanimal.test44podlodkaCrewTddTest.data

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.*
import org.junit.Test
import ru.webanimal.test44podlodkaCrewTddTest.domain.model.BandName
import java.lang.IllegalStateException

class BandNameRepositoryImplTest {

    private val localDataSource: BandDataSource = mock()
    private val remoteDataSource: BandDataSource = mock()
    private val repository: BandRepository = BandRepositoryImpl(
        localDataSource = localDataSource,
        remoteDataSource = remoteDataSource
    )

    @Test
    fun `get band EXPECT band from remote`() {
        val expected = BandName("remoteName")

        whenever(localDataSource.getBand()).thenThrow(IllegalStateException())
        whenever(remoteDataSource.getBand()).thenReturn(expected)

        val result = repository.getBand()

        assertEquals(expected, result)
    }

    @Test
    fun `get band EXPECT band from local`() {
        val expected = BandName("localName")

        whenever(localDataSource.getBand()).thenReturn(expected)

        val result = repository.getBand()

        assertEquals(expected, result)
    }
}