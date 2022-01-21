package com.finapp.tmdbclient_using_mvvm.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.finapp.tmdbclient_using_mvvm.R
import com.finapp.tmdbclient_using_mvvm.databinding.ActivityHomeBinding
import com.finapp.tmdbclient_using_mvvm.presentation.artist.ArtistActivity
import com.finapp.tmdbclient_using_mvvm.presentation.movie.MovieActivity
import com.finapp.tmdbclient_using_mvvm.presentation.tvshow.TvShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.movieButton.setOnClickListener {
            startActivity(Intent(this, MovieActivity::class.java))
        }
        binding.tvButton.setOnClickListener {
            startActivity(Intent(this, TvShowActivity::class.java))
        }
        binding.artistsButton.setOnClickListener {
            startActivity(Intent(this, ArtistActivity::class.java))
        }
    }
}