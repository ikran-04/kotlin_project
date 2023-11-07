package com.example.waafi_clone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.waafi_clone.ui.theme.Waafi_cloneTheme

data class TabItem(
    val title:String,


    )
class Calls : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Waafi_cloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    callsScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun callsScreen (){
    val tabItems = listOf(
        TabItem(
            title="Recents",
//

            ),
        TabItem(
            title="Contacts",
//

            ),
        TabItem(
            title="Balance",


            )
    )
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }
    val pagerState = rememberPagerState {
        tabItems.size
    }
    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)

    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress) {
            selectedTabIndex = pagerState.currentPage
        }
    }
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)

    ) {
        Text(text = "Chats")
        Icon(painter = painterResource(id = R.drawable.edit), contentDescription = null ,tint = Color.Unspecified)
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 30.dp, start = 10.dp, end = 10.dp)
    ) {
        TabRow(selectedTabIndex = selectedTabIndex) {

            tabItems.forEachIndexed { index, item ->
                Tab(
                    modifier = Modifier
                        .padding(vertical = 5.dp),

                    selected = index == selectedTabIndex,
                    onClick = { selectedTabIndex = index },

                    text = {
                        Text(
                            text = item.title
                        )

                    },

                )
            }

        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
//                .weight(1f)
        ) { index ->
            when (index) {
                0 -> Recents()
                1 -> Text(text = "jee")
                2 -> Balance()
            }

        }
    }

}

@Composable
fun Recents(){
    Column (
        horizontalAlignment =Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ){

        Image(painter = painterResource(id = R.drawable.recents), contentDescription = null , modifier = Modifier.padding(vertical = 10.dp))
        Text(text = "No recent calss" , fontSize = 15.sp)
    }
}

@Composable
fun Balance(){
    val add = painterResource(id = R.drawable.add)
    val buy = painterResource(id = R.drawable.buy)
    Column {
        Row (
            verticalAlignment= Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
//            .fillMaxWidth()
                .padding(20.dp)
        ){
            Column {
                Text(text = "Credit Balance", fontSize = 12.sp , color = Color.Gray)
                Text(text = "C$100.00" , fontSize = 18.sp )
                Text(text = "View History", fontSize = 12.sp , color = Color(0xFF13BF8F))
            }
            Text(text = "WAAFI")
        }

        Row (
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp , horizontal = 20.dp)
        ) {
            IconText(icon = add , text = "Add Credits")
            IconText(icon = buy , text = "Buy Bundle")
        }

        Column (
            horizontalAlignment =Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth().fillMaxHeight()
        ){

            Image(painter = painterResource(id = R.drawable.recents), contentDescription = null , modifier = Modifier.padding(vertical = 10.dp))
            Text(text = "Your active bundles will appear here" , fontSize = 15.sp)
        }
    }


}

@Composable
fun IconText(text:String , icon: Painter) {
    // Create a row that wraps the content size
    Box (modifier = Modifier
        .wrapContentSize()
        .clip(
            RoundedCornerShape(5.dp)
        )
        .fillMaxWidth()
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,

            modifier = Modifier
                .wrapContentSize()
                .fillMaxWidth().width(20.dp)
                .background(Color(0xFFF4F4F4))
                .padding(10.dp)

        ) {
            Image(
                painter = icon,
                contentDescription = "icon",
                // Set the size of the icon
                modifier = Modifier.size(20.dp)
            )
            // Add some horizontal space between the icon and the text
            Spacer(modifier = Modifier.width(8.dp))
            // Create a text with some content and style
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 15.sp,
                    color = Color.Black,
                ),
                // Align the text to the center vertically
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}

