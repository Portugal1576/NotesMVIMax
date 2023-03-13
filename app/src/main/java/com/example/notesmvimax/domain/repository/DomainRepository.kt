package com.example.notesmvimax.domain.repository

import com.example.notesmvimax.domain.model.NoteModel

interface DomainRepository {
    suspend fun getAllNotes(): List<NoteModel>
}