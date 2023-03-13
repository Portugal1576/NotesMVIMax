package com.example.notesmvimax.presentation.screen.main

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.notesmvimax.presentation.items.ErrorItem
import com.example.notesmvimax.presentation.items.LoadingItem
import com.example.notesmvimax.presentation.items.MainScreenContent

@Composable
fun MainScreen(navHostController: NavHostController){

    val viewModel = hiltViewModel<MainViewModel>()

    val state by viewModel.state.collectAsState()

    when{
        state.isLoading -> {
            Log.d("checkData", "Loading.....")
            LoadingItem()
        }
        state.data.isNotEmpty() -> {
            Log.d("checkData", "Data size: ${state.data.size}")
            MainScreenContent(state.data)
        }
        state.error != null -> {
            Log.d("checkData", "Error message: ${state.error}")
            ErrorItem(state.error) {
                viewModel.sendEvent(MainScreenEvent.LoadingData)
            }
        }
    }
}