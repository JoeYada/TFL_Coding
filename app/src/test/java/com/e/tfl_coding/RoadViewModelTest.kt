package com.e.tfl_coding

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.e.tfl_coding.common.ApiProgress
import com.e.tfl_coding.models.Road
import com.e.tfl_coding.network.repo.RoadRepository
import com.e.tfl_coding.ui.RoadViewModel
import io.mockk.MockKAnnotations
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import java.lang.RuntimeException

@RunWith(MockitoJUnitRunner::class)
class RoadViewModelTest {
    @JvmField
    @Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var roadRepository: RoadRepository

    lateinit var viewModel: RoadViewModel

    @Before
    fun setup(){
        MockKAnnotations.init(this)
        viewModel = RoadViewModel(roadRepository)
    }

    @Test
    fun apiReturnsEmptyList_getAlbumShouldSetError(){
        `when`(roadRepository.getRoadStatus("a5")).thenReturn(
            Single.just(
                listOf()
            )
        )

        viewModel.getRoadResponse("a5")
        Assert.assertEquals("No Results Found", (viewModel.status.value as ApiProgress.FAILURE).error)
    }

    @Test
    fun apiReturnsNonEmptyList_getAlbumShouldSetData(){
        val roads = listOf(Road("okay", "a2", "good"))
        `when`(roadRepository.getRoadStatus("a2")).thenReturn(
            Single.just(
                roads
            )
        )

        viewModel.getRoadResponse("a2")
        Assert.assertEquals(roads, (viewModel.status.value as ApiProgress.SUCCESS).roads)
    }

    @Test
    fun apiReturnsException_getAlbumShouldSetError(){
        `when`(roadRepository.getRoadStatus("a5")).thenReturn(
            Single.error(
                RuntimeException("Error")
            )
        )

        viewModel.getRoadResponse("a5")
        Assert.assertEquals("Error", (viewModel.status.value as ApiProgress.FAILURE).error)
    }
}