package com.example.proguardapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.proguardapplication.databinding.ActivityMainBinding
import com.example.proguardapplication.model.Response
import com.example.proguardapplication.utils.SpaceItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.getPhotos()

        setupUI()
    }

    private fun setupUI() {
        binding.apply {
            rv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            rv.addItemDecoration(SpaceItemDecoration(20))
        }
        observer()
    }

    private fun observer() {
        mainViewModel.photos.observe(this) {
            Log.d("TAG", "observer: $it")
            binding.rv.adapter = HomePhotoAdapter(it)
        }
    }
}