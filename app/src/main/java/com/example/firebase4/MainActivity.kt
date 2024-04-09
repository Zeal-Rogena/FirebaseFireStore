package com.example.firebase4

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.text.style.BackgroundColorSpan
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firebase4.ui.theme.Firebase4Theme
import com.google.firebase.Firebase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.firestore
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Firebase4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyTaskApp(LocalContext.current)
                }
            }
        }
    }
}

@Composable
fun MyTaskApp(context: Context) {
    val taskuno = remember {
        mutableStateOf("")
    }
    val taskdos = remember {
        mutableStateOf("")
    }
    val tasktres = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Black)
            .padding(16.dp),
//            .border(2.dp, Color.White, RoundedCornerShape(8.dp)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        TextField(
            value = taskuno.value,
            onValueChange = { taskuno.value = it },
            placeholder = { Text(text = "Enter text here") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green, RoundedCornerShape(8.dp))
                .padding(10.dp),
            colors = TextFieldDefaults.colors(
               focusedIndicatorColor = Color.Transparent,
               unfocusedIndicatorColor = Color.Transparent,
              disabledIndicatorColor = Color.Transparent
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = taskdos.value,
            onValueChange = { taskdos.value = it },
            placeholder = { Text(text = "Enter text here") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green, RoundedCornerShape(8.dp))
                .padding(10.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = tasktres.value,
            onValueChange = { tasktres.value = it },
            placeholder = { Text(text = "Enter text here") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green, RoundedCornerShape(8.dp))
                .padding(10.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            if(TextUtils.isEmpty(taskuno.value)){
                Toast.makeText(context,"Enter some stuff for taskuno",Toast.LENGTH_LONG).show()
            }else if (
                TextUtils.isEmpty(taskdos.value)){
                Toast.makeText(context,"Enter some stuff for taskdos ",Toast.LENGTH_LONG).show()
            }else if (
                TextUtils.isEmpty(tasktres.value)){
                Toast.makeText(context,"Enter some stuff for tasktres ",Toast.LENGTH_LONG).show()
            }else{
                addDataFirebase(
                    taskuno.value,
                    taskdos.value,
                    tasktres.value,
                    context
                )
            }
        },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(56.dp)
                .background(Color.Black, RoundedCornerShape(8.dp))
                ) {
            Text(text = "add some stuff idek")
        }
    }
}

fun addDataFirebase(taskuno: String, taskdos: String, tasktres: String,context: Context) {
    //create an instance
    val db = Firebase.firestore
    val dbtasks: CollectionReference = db.collection("Tasks")
    val idek = tasks(taskuno,taskdos,tasktres)
    dbtasks.add(idek).addOnSuccessListener {
        Toast.makeText(context,"You have added some stuff ",Toast.LENGTH_LONG).show()
    }
        .addOnFailureListener{
            e ->
            Toast.makeText(context,"You have failed to add stuff  ",Toast.LENGTH_LONG).show()

        }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Firebase4Theme {
        MyTaskApp(LocalContext.current)
    }
}