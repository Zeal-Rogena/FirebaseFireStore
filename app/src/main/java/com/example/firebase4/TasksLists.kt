package com.example.firebase4

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.firebase4.ui.theme.Firebase4Theme
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class TasksLists : ComponentActivity() {
    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Firebase4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val taskList = mutableStateListOf<tasks?>()
                    val db = Firebase.firestore
                    db.collection("tasks").get().addOnSuccessListener {

                    }
                    TaskListApp(LocalContext.current, taskList)
                }
            }
        }
    }
}

@Composable
fun TaskListApp(context: Context, taskList:SnapshotStateList<tasks?>) {
Column (modifier = Modifier
    .fillMaxHeight()
    .fillMaxWidth()
    .background(Color.Black),
    verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.CenterHorizontally
){
    LazyColumn {

    }
}
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    Firebase4Theme {
        val taskList = mutableStateListOf<tasks?>()

        TaskListApp(LocalContext.current, taskList)
    }
}