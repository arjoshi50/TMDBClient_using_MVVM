package com.finapp.tmdbclient_using_mvvm.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.finapp.tmdbclient_using_mvvm.data.model.movie.Movie
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MovieDaoTest {

    private lateinit var dao: MovieDao
    private lateinit var database: TMDBatabase

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TMDBatabase::class.java
        ).build()
        dao = database.movieDao()

    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun saveMoviesTest() = runBlocking {
        val movies = listOf(
            Movie(1, "overview1","posterPath1","date1","title1"),
            Movie(2, "overview2","posterPath2","date2","title2"),
            Movie(3, "overview3","posterPath3","date3","title3")
        )
        dao.saveMovies(movies)

        val allMovies = dao.getMovies()
        assertThat(allMovies).isEqualTo(movies)
    }

    @Test
    fun deleteMoviesTest() = runBlocking {
        val movies = listOf(
            Movie(1, "overview1","posterPath1","date1","title1"),
            Movie(2, "overview2","posterPath2","date2","title2"),
            Movie(3, "overview3","posterPath3","date3","title3")
        )
        dao.saveMovies(movies)
        dao.deleteAllMovies()
        val moviesResult = dao.getMovies()
        assertThat(moviesResult).isEmpty()
    }
}
