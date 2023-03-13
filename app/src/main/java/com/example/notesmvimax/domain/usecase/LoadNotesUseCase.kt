package com.example.notesmvimax.domain.usecase

import com.example.notesmvimax.data.DomainRepositoryImpl
import com.example.notesmvimax.domain.model.NoteModel
import javax.inject.Inject

class LoadNotesUseCase @Inject constructor(
    private val domainRepository: DomainRepositoryImpl
): BaseUseCase<List<NoteModel>>() {
    override suspend fun invoke(): List<NoteModel> = domainRepository.getAllNotes()
}