package com.example.proguardapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proguardapplication.model.Data
import com.example.proguardapplication.model.Response
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repo: Repo) : ViewModel() {
    private val _photos =
        MutableLiveData<Data>()
    val photos = _photos


    fun getPhotos() =
        viewModelScope.launch {
            try {
                val response = repo.getPhotos()
                _photos.value = response
            } catch (e: Exception) {
                _photos.value = Data()
            }
        }
}