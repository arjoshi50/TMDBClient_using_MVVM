package com.finapp.tmdbclient_using_mvvm.presentation.tvshow

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
import com.finapp.tmdbclient_using_mvvm.data.model.movie.Movie
import com.finapp.tmdbclient_using_mvvm.data.model.tvshow.TvShow
import com.finapp.tmdbclient_using_mvvm.databinding.ActivityMovieBinding
import com.finapp.tmdbclient_using_mvvm.databinding.ActivityTvShowBinding
import com.finapp.tmdbclient_using_mvvm.presentation.di.Injector
import com.finapp.tmdbclient_using_mvvm.presentation.movie.MovieAdapter
import com.finapp.tmdbclient_using_mvvm.presentation.movie.MovieViewModel
import com.finapp.tmdbclient_using_mvvm.presentation.movie.MovieViewModelFactory
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var adapter: TvShowAdapter
    private lateinit var binding : ActivityTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
        (application as Injector).createTvShowSubComponent()
            .inject(this)

        tvShowViewModel= ViewModelProvider(this,factory)
            .get(TvShowViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.tvshowRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TvShowAdapter()
        binding.tvshowRecyclerView.adapter = adapter

        displayPopularTvShow()
    }

    private fun displayPopularTvShow(){
        binding.tvshowProgressBar.visibility = View.VISIBLE
        val responseLiveData = tvShowViewModel.getTvShow()
        responseLiveData.observe(this, Observer {
//            Log.i("MYTAG",it.toString())
            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvshowProgressBar.visibility = View.GONE
            } else {
                binding.tvshowProgressBar.visibility = View.GONE
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
                updateTvShow()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateTvShow(){
        binding.tvshowProgressBar.visibility = View.VISIBLE
        val response : LiveData<List<TvShow>?> = tvShowViewModel.updateTvShow()
        response.observe(this, Observer {
            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvshowProgressBar.visibility = View.GONE

            }else{
                binding.tvshowProgressBar.visibility = View.GONE
            }
        })
    }

}