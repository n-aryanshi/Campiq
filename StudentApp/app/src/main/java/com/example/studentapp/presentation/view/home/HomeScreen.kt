
package com.example.studentapp.presentation.view.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studentapp.R

import kotlinx.coroutines.launch

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0XFF06919C))
        ) {
            //top
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.BottomCenter
            ){

                Image(
                    painter = painterResource(R.drawable.rect_home_bg),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                        .height(285.dp)
                    ,contentScale = ContentScale.Crop
                )

                PosterCarousel()
            }

            GridBody()

            CustomBottomNav()
        }
        //middle


        //bottom



    }
}


@Composable
//@Preview(showBackground = true)
fun Element(
    painter: Painter,
    text: String,
    backgroundColor: Color = Color.Transparent,

    ) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .width(163.dp)
            .height(117.dp)
            .background(backgroundColor, shape = RoundedCornerShape(12.dp)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painter,
            contentDescription = text,
            modifier = Modifier
                .size(64.dp)
                .padding(8.dp)
        )

        Text(
            text = text,
            color = Color(0XFF06919C),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

    }
}



@Composable
fun GridBody(items: List<GridItem>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // 2 per row
//        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items.size) { index ->
            val item = items[index]
            Element(
                painter = item.painter,
                text = item.text,
                backgroundColor = item.backgroundColor
            )
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun GridBody() {
    val items = listOf(
        GridItem(painterResource(R.drawable.calendr_icon), "Attendance", Color(0xFFE3F2FD)),
        GridItem(painterResource(R.drawable.class_icon), "Class", Color(0xFFFFCDD2)),
        GridItem(painterResource(R.drawable.alarm_icon), "Time Table", Color(0xFFC8E6C9)),
        GridItem(painterResource(R.drawable.email_icon), "Notices", Color(0xFFFFF9C4)),
        GridItem(painterResource(R.drawable.locate_icon), "Room", Color(0xFFD1C4E9)),
        GridItem(painterResource(R.drawable.book_icon), "Diary", Color(0xFFFFE0B2))
    )

    GridBody(items = items)
}




data class GridItem(
    val painter: Painter,
    val text: String,
    val backgroundColor: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun PosterBox() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
//    val userName by userViewModel.userName.collectAsState()
    val userName = "Alex"

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Menu Item 1", modifier = Modifier.padding(16.dp))
                Text("Menu Item 2", modifier = Modifier.padding(16.dp))
            }
        }
    ) {
        Scaffold(
            modifier = Modifier
                .background(color = Color(0XFF06919C)),
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0XFF67C6DC)),
                    title = { Text(
                        text = "Hi, $userName",
                        fontWeight = FontWeight.Bold,
                        color = Color.White)
                    },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu,tint = Color.White, contentDescription = "Menu")
                        }
                    },
                    actions = {
                        IconButton(onClick = { /* handle notifications */ }) {
                            Icon(Icons.Default.Notifications,tint = Color.White, contentDescription = "Notifications")
                        }
                    }
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(
                        PaddingValues(
                            start = innerPadding.calculateStartPadding(LayoutDirection.Ltr),
                            end   = innerPadding.calculateEndPadding(LayoutDirection.Ltr),
                            bottom= innerPadding.calculateBottomPadding(),
                            top   = 0.dp // 🔑 remove top padding
                        )
                    )
                    .fillMaxSize()

            ) {
                HomeScreen()
//                PosterCarousel()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PosterCarousel() {
    val pagerState = rememberPagerState(pageCount = { 3 })

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .padding(8.dp)
        ) { page ->
            Card(
                modifier = Modifier.fillMaxWidth()
                    .wrapContentHeight(),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {
                when (page) {
                    0 -> Image(
                        painter = painterResource(id = R.drawable.notice_demo),
                        contentDescription = "Poster 1",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    1 -> Image(
                        painter = painterResource(id = R.drawable.notice_demo),
                        contentDescription = "Poster 2",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    2 -> Image(
                        painter = painterResource(id = R.drawable.notice_demo),
                        contentDescription = "Poster 3",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }

        // ✅ Custom Pager Indicator for Foundation Pager
        Row(
            modifier = Modifier
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(3) { index ->
                val isSelected = pagerState.currentPage == index
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(if (isSelected) 10.dp else 8.dp)
                        .background(
                            if (isSelected) Color.Black else Color.Gray,
                            CircleShape
                        )
                )
            }
        }
    }
}


@Composable
fun CustomBottomNav() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(114.dp) // adjust height as needed
    ) {
        // 1️⃣ White oval background
        Image(
            painter = painterResource(id = R.drawable.ellipse_home_bg), // your white oval image
            contentDescription = null,
            modifier = Modifier.width(407.dp) .height(114.dp)
                .align(Alignment.BottomCenter).offset(y = 10.dp),
            contentScale = ContentScale.FillBounds,

            )

        // 2️⃣ Left icon
        Icon(
            painter = painterResource(id = R.drawable.calendar_icon2), // left icon
            contentDescription = "Calendar",
            modifier = Modifier
                .size(45.dp)
                .align(Alignment.BottomStart) // stick bottom-left
                .offset(x = 32.dp, y = (-16).dp) // move inward
        )

        // 3️⃣ Right icon
        Icon(
            painter = painterResource(id = R.drawable.profile_icon), // right icon
            contentDescription = "Profile",
            modifier = Modifier
                .size(45.dp)
                .align(Alignment.BottomEnd) // stick bottom-right
                .offset(x = (-32).dp, y = (-16).dp)
        )

        // 4️⃣ Center floating home button
        Box(
            modifier = Modifier
                .size(width = 96.dp, height = 90.dp) // size of circular button
                .align(Alignment.TopCenter)
                .offset(y = (-16).dp) // make it float above background
                .background(
                    color = Color.White.copy(alpha = 0.9f), // optional, or transparent
                    shape = RoundedCornerShape(50) // same as shadow
                )
                .shadow(
                    elevation = 1.dp, // shadow depth
                    shape = RoundedCornerShape(50), // smooth oval corners
                    clip = false,
                    ambientColor = Color.Transparent,
                    spotColor = Color.Black.copy(alpha = 1.25f)
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.home_icon), // home icon
                contentDescription = "Home",
                tint = Color.Unspecified,
                modifier = Modifier.size(62.dp).offset(y = 4.dp)
            )
        }
    }
}
