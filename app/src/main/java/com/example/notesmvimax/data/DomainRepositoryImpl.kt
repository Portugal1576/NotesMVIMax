package com.example.notesmvimax.data

import com.example.notesmvimax.domain.model.NoteModel
import com.example.notesmvimax.domain.repository.DomainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.net.ConnectException
import java.time.LocalDate
import javax.inject.Inject

class DomainRepositoryImpl @Inject constructor() : DomainRepository {
    companion object {
        var count = 0
    }

    override suspend fun getAllNotes(): List<NoteModel> {
        val list: List<NoteModel>
        withContext(Dispatchers.IO) {
            when (count) {
                0 -> {
                    count++
                    delay(3000)
                    list = emptyList()
                }
                1 -> {
                    count++
                    delay(10000)
                    throw ConnectException("Lost internet connection")
                }
                2 -> {
                    delay(3000)
                    list = listOf(
                        NoteModel(
                            id = 1,
                            title = "Note 1",
                            subtitle = "Subtitle for Note 1",
                            data = LocalDate.now(),
                            author = "Author 1"
                        ),
                        NoteModel(
                            id = 1,
                            title = "Note 2",
                            subtitle = "Subtitle for Note 2",
                            data = LocalDate.now(),
                            author = "Author 2"
                        ),
                        NoteModel(
                            id = 3,
                            title = "Note 3",
                            subtitle = "Subtitle for Note 3",
                            data = LocalDate.now(),
                            author = "Author 3"
                        ),
                        NoteModel(
                            id = 4,
                            title = "Note 4",
                            subtitle = "Subtitle for Note 4",
                            data = LocalDate.now(),
                            author = "Author 4"
                        ),
                        NoteModel(
                            id = 5,
                            title = "Note 5",
                            subtitle = "Subtitle for Note 5",
                            data = LocalDate.now(),
                            author = "Author 5"
                        ),
                        NoteModel(
                            id = 6,
                            title = "Note 6",
                            subtitle = "Subtitle for Note 6",
                            data = LocalDate.now(),
                            author = "Author 6"
                        ),
                        NoteModel(
                            id = 7,
                            title = "Note 7",
                            subtitle = "Subtitle for Note 7",
                            data = LocalDate.now(),
                            author = "Author 7"
                        ),
                    )
                }
                else -> list = emptyList()
            }
            return@withContext
        }
        return list
    }
}