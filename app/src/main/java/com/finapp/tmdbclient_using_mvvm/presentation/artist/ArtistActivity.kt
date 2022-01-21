package com.finapp.tmdbclient_using_mvvm.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.finapp.tmdbclient_using_mvvm.R
import com.finapp.tmdbclient_using_mvvm.data.model.artist.Artist
import com.finapp.tmdbclient_using_mvvm.data.model.movie.Movie
import com.finapp.tmdbclient_using_mvvm.databinding.ActivityArtistBinding
import com.finapp.tmdbclient_using_mvvm.databinding.ActivityMovieBinding
import com.finapp.tmdbclient_using_mvvm.presentation.di.Injector
import com.finapp.tmdbclient_using_mvvm.presentation.movie.MovieAdapter
import com.finapp.tmdbclient_using_mvvm.presentation.movie.MovieViewModel
import com.finapp.tmdbclient_using_mvvm.presentation.movie.MovieViewModelFactory
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var adapter: ArtistAdapter
    private lateinit var binding : ActivityArtistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)

        (application as Injector).createArtistSubComponent()
            .inject(this)

        artistViewModel= ViewModelProvider(this,factory)
            .get(ArtistViewModel::class.java)
        initRecyclerView()
    }


    private fun initRecyclerView(){
        binding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ArtistAdapter()
        binding.artistRecyclerView.adapter = adapter

        displayPopularMovies()
    }

    private fun displayPopularMovies(){
        binding.artistProgressBar.visibility = View.VISIBLE
        val responseLiveData = artistViewModel.getArtist()
        responseLiveData.observe(this, Observer {
//            Log.i("MYTAG",it.toString())
            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            } else {
                binding.artistProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inference : MenuInflater = menuInflater
        inference.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovies(){
        binding.artistProgressBar.visibility = View.VISIBLE
        val response : LiveData<List<Artist>?> = artistViewModel.updateArtist()
        response.observe(this, Observer {
            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE

            }else{
                binding.artistProgressBar.visibility = View.GONE
            }
        })
    }
}