package com.example.notesmvimax.domain.model

import java.time.LocalDate

data class NoteModel(
    val id: Long,
    val title: String,
    val subtitle: String,
    val data: LocalDate,
    val author: String
)
