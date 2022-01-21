package com.finapp.tmdbclient_using_mvvm.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.finapp.tmdbclient_using_mvvm.data.model.movie.Movie
import com.finapp.tmdbclient_using_mvvm.data.repository.movie.FakeMovieRepository
import com.finapp.tmdbclient_using_mvvm.domain.usecase.GetMoviesUseCase
import com.finapp.tmdbclient_using_mvvm.domain.usecase.UpdateMoviesUsecase
import com.finapp.tmdbclient_using_mvvm.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieViewModelTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        val fakeMovieRepository = FakeMovieRepository()
        val getMoviesUseCase = GetMoviesUseCase(fakeMovieRepository)
        val updateMoviesUseCase = UpdateMoviesUsecase(fakeMovieRepository)
        viewModel = MovieViewModel(getMoviesUseCase, updateMoviesUseCase)
    }

    @Test
    fun getMovies_returnsCurrentList() {
         val movies = mutableListOf<Movie>()
            movies.add(Movie(1,"overview1","path1","data1","title1"))
            movies.add(Movie(2,"overview2","path2","data2","title2"))

        val currentList = viewModel.getMovies().getOrAwaitValue()
        assertThat(currentList).isEqualTo(movies)
    }

    @Test
    fun updatedMovies_returnsUpdatedList() {
        val movies = mutableListOf<Movie>()
        movies.add(Movie(3,"overview3","path3","data3","title3"))
        movies.add(Movie(4,"overview4","path4","data4","title4"))

        val updatedList = viewModel.updateMovies().getOrAwaitValue()
        assertThat(updatedList).isEqualTo(movies)
    }
}