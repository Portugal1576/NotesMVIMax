package com.example.notesmvimax.presentation.items

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notesmvimax.domain.model.NoteModel

@Composable
fun MainScreenContent(data: List<NoteModel>){
Column(
    modifier = Modifier
        .fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ){
        item {
            Text(
                text = "My Notes App",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .padding(top = 16.dp)
                )
        }
        items(data){
            note ->
            NoteItem(
                note,
                modifier = Modifier
                    .padding(vertical = 16.dp, horizontal = 24.dp)
            )
        }
    }
}
}