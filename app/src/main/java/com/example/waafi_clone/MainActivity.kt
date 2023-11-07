package com.example.waafi_clone

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Colors
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.waafi_clone.ui.theme.Waafi_cloneTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.project.Screens


data class BottomNavigationItem(
    val title: String,
    val selectedIcon: Painter,
    val unselectedIcon: Painter,
    val hasNews: Boolean,
//    val badgeCount: Int? = null
)

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController();
            Waafi_cloneTheme {
                val items = listOf(
                    BottomNavigationItem(
                        title = "Chat",
                        selectedIcon = painterResource(id = R.drawable.chat),
                        unselectedIcon = painterResource(id = R.drawable.chat),
                        hasNews = false,
                    ),
                    BottomNavigationItem(
                        title = "Calls",
                        selectedIcon = painterResource(id = R.drawable.calls),
                        unselectedIcon = painterResource(id = R.drawable.calls),
                        hasNews = false,
//                        badgeCount = 4
                    ),
                    BottomNavigationItem(
                        title = "",
                        selectedIcon = painterResource(id = R.drawable.qr_code,),
                        unselectedIcon = painterResource(id = R.drawable.qr_code),
                        hasNews = false,
                    ),
                    BottomNavigationItem(
                        title = "Money",
                        selectedIcon = painterResource(id = R.drawable.settings),
                        unselectedIcon = painterResource(id = R.drawable.settings),
                        hasNews = false,
                    ),
                    BottomNavigationItem(
                        title = "Settings",
                        selectedIcon = painterResource(id = R.drawable.calls),
                        unselectedIcon = painterResource(id = R.drawable.calls),
                        hasNews = false,
                    )
                )
                var selectedItemIndex by rememberSaveable {
                    mutableStateOf(0)
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        bottomBar = {
                            NavigationBar(
                                containerColor = Color.White,
                                modifier = Modifier
                                    .padding(bottom = 10.dp)


                            ) {

                                items.forEachIndexed { index, item ->
                                    NavigationBarItem(
                                        
                                        selected = selectedItemIndex == index,
                                        onClick = {
                                            selectedItemIndex = index
                                            navController.navigate(item.title)
                                        },
                                        colors = NavigationBarItemDefaults.colors(
                                            indicatorColor = Color.White,
                                            selectedIconColor = Color(0xFF1FB289),
                                            selectedTextColor = Color(0xFF1FB289)
                                        ),
                                        label = { Text(text = item.title) },

                                        icon = {


                                                if(index == 2){

                                                    Box(
                                                        modifier = Modifier
                                                            .size(50.dp)
                                                            .clip(CircleShape)
                                                            .background(Color(0xFF13BF8F)),
                                                        contentAlignment = Alignment.Center
                                                    ) {
                                                        Icon(
                                                            tint= Color.White,
                                                            painter = items[2].selectedIcon,
                                                            contentDescription = "Home icon",

                                                            modifier = Modifier
                                                                .size(28.dp)
//                                                                .tint(Color.White)
                                                        )
                                                    }

                                                }else{
                                                    Icon(


                                                        painter = if (index == selectedItemIndex) {
                                                            item.selectedIcon


                                                        } else item.unselectedIcon,
                                                        contentDescription = item.title,
                                                        modifier = Modifier
                                                            .size(20.dp)
                                                    )
                                                }







                                            }

                                    )
                                }
                            }

                        }

                    )
                    {
                        NavHost(
                            navController = navController,
                            startDestination = Screens.Chat.route
                        ) {

                            composable(Screens.Chat.route) { ChatsScreen() }
                            composable(Screens.Calls.route) { callsScreen() }
                            composable(Screens.Money.route) { Money() }

                        }
                    }
                }
            }
                }
            }
    }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Waafi_cloneTheme {
        Greeting("Android")
    }
}