package com.example.waafi_clone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.waafi_clone.ui.theme.Waafi_cloneTheme

class Chats : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Waafi_cloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ChatsScreen()
                }
            }
        }
    }
}


@Composable
fun ChatsScreen(){
    Row (
        verticalAlignment =Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)

    ) {
        Text(text = "Chats")
        Icon(painter = painterResource(id = R.drawable.edit), contentDescription = null ,tint = Color.Unspecified)
    }
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 60.dp, horizontal = 10.dp)

    ){
        SearchInput( )


    }
    Column (
        horizontalAlignment =Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth().fillMaxHeight()
    ){

        Image(painter = painterResource(id = R.drawable.not_found), contentDescription = null , modifier = Modifier.padding(vertical = 10.dp))
        Text(text = "No Chats Yet" , fontWeight = FontWeight.Bold, fontSize = 15.sp)
        Text(text = "Get Started By messaging a contact.." , color = Color.Gray, fontSize = 12.sp)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchInput(

) {
    var text by remember { mutableStateOf("Search.") }

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(0xFFEDEDED),
            cursorColor = Color.Black,
            disabledLabelColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        value = text,
        textStyle = TextStyle(fontSize = 13.sp) ,
        onValueChange = { text = it },
        shape = RoundedCornerShape(30.dp),
        singleLine = true,
        leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) }

    )


}





@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    Waafi_cloneTheme {
        ChatsScreen()
    }
}