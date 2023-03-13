package com.example.notesmvimax.presentation.screen.main

import com.example.notesmvimax.domain.usecase.LoadNotesUseCase
import com.example.notesmvimax.presentation.screen.base.Reducer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainScreenReducer(
    initial: MainScreenState,
    val useCase: LoadNotesUseCase,
    val viewModelScope: CoroutineScope
    ): Reducer<MainScreenState, MainScreenEvent>(initial) {
    override fun reduce(oldState: MainScreenState, event: MainScreenEvent) {
        when(event){
            is MainScreenEvent.ShowData -> {
                setState(oldState.copy(isLoading = false, data = event.data))
            }
            is MainScreenEvent.LoadingData -> {
                viewModelScope.launch {
                    setState(oldState.copy(isLoading = true, data = emptyList()))
                    try {
                        useCase.invoke().let {
                            data ->
                            if (data.isNotEmpty()){
                                sendEvent(MainScreenEvent.ShowData(data = data))
                            } else {
                                sendEvent(MainScreenEvent.ShowError(errorMessage = "Data is empty"))
                            }
                        }
                    }catch (e: Exception){
                        sendEvent(MainScreenEvent.ShowError(errorMessage = e.message ?: "Exeption"))
                    }
                }
            }
            is MainScreenEvent.ShowError -> {
                setState(oldState.copy(isLoading = false, data = emptyList(), error = event.errorMessage))
            }
        }
    }

}