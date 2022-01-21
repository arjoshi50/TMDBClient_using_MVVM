package com.finapp.tmdbclient_using_mvvm.data.repository.movie

import android.util.Log
import com.finapp.tmdbclient_using_mvvm.data.model.movie.Movie
import com.finapp.tmdbclient_using_mvvm.data.model.movie.MovieList
import com.finapp.tmdbclient_using_mvvm.data.repository.movie.datasource.MovieCacheDataSource
import com.finapp.tmdbclient_using_mvvm.data.repository.movie.datasource.MovieLocalDataSource
import com.finapp.tmdbclient_using_mvvm.data.repository.movie.datasource.MovieRemoteDataSource
import com.finapp.tmdbclient_using_mvvm.domain.repository.MovieRepository
import retrofit2.Response
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
): MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMovieFromCaChe()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMoviews= getMovieFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMoviews)
        movieCacheDataSource.saveMoviesToCache(newListOfMoviews)
        return newListOfMoviews
    }

    suspend fun getMovieFromAPI():List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            val response: Response<MovieList> = movieRemoteDataSource.getMovies()
            val body=response.body()
            if (body!=null){
                movieList= body.movies
            }
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        return movieList
    }

    suspend fun getMovieFromDB():List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()

        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if (movieList.size>0){
            return movieList
        }else{
            movieList=getMovieFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMovieFromCaChe():List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()

        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if (movieList.size>0){
            return movieList
        }else{
            movieList=getMovieFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}