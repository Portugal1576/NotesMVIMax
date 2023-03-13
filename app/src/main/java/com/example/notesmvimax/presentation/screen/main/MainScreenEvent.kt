package com.example.notesmvimax.presentation.screen.main

import com.example.notesmvimax.domain.model.NoteModel
import com.example.notesmvimax.presentation.screen.base.UiEvent
import javax.annotation.concurrent.Immutable

@Immutable
sealed class MainScreenEvent: UiEvent {
    object LoadingData: MainScreenEvent()
    data class ShowData(val data: List<NoteModel>): MainScreenEvent()
    data class ShowError(val errorMessage: String): MainScreenEvent()
}