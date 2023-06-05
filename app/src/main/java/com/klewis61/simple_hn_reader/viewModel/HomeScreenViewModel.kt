package com.klewis61.simple_hn_reader.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.klewis61.simple_hn_reader.data.Story
import com.klewis61.simple_hn_reader.network.HNApi
import kotlinx.coroutines.launch

sealed interface HomeScreenUiState{
    data class Success(val stories: List<Story>) : HomeScreenUiState
    object Error : HomeScreenUiState
    object Loading : HomeScreenUiState
}


class HomeScreenViewModel : ViewModel() {
    var homeScreenUiState: HomeScreenUiState by mutableStateOf(HomeScreenUiState.Loading)
        private set

    init{
        getTopStories()
    }

    fun getTopStories(){

        viewModelScope.launch{
            homeScreenUiState = HomeScreenUiState.Loading
            homeScreenUiState = try{
                HomeScreenUiState.Success(
                    HNApi.retrofitService.getTopStories().hits
                )
            }
            catch(e: Exception){
                //log error to console
                println(e)
                HomeScreenUiState.Error
            }
        }

    }
}