package com.example.notesmvimax.presentation.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notesmvimax.domain.model.NoteModel
import com.example.notesmvimax.presentation.ui.theme.NotesMVIMaxTheme
import java.time.LocalDate
import java.util.Random

@Composable
fun NoteItem(
    note: NoteModel,
    modifier: Modifier
){
    val color = Color(
        Random().nextInt(256),
        Random().nextInt(256),
        Random().nextInt(256),
        alpha = 30
    )
    Box(
        modifier = Modifier
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(color)
                .padding(vertical = 16.dp, horizontal = 24.dp)
        ){
            Column {
                Text(
                    text = note.title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = note.subtitle,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(top = 24.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = note.author,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )
                    Text(
                        text = "${note.data.dayOfMonth} ${note.data.month}",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteItemPreview(){
    NotesMVIMaxTheme {
        val note = NoteModel(
            id = 1,
            title = "Test",
            subtitle = "Subtitle test",
            data = LocalDate.now(),
            author = "Andrii Rubtsov"
        )
        NoteItem(
            note = note,
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 16.dp)
        )
    }
}