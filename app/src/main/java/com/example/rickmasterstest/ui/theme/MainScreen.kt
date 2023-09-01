package com.example.rickmasterstest.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickmasterstest.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


val circeFont = Font(R.font.circe)


@Composable
fun MainScreen() {

    Box(modifier = Modifier.padding(top = 60.dp)) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Мой дом",
                style = TextStyle(
                    fontSize = 21.sp, fontFamily = FontFamily(circeFont), fontWeight = FontWeight.W400
                )
            )

        }
    }


}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout() {

    val tabList = listOf("Камеры", "Двери")

    val pagerState = rememberPagerState()  // сохранение переключения между страницами
    val tabIndex = pagerState.currentPage // запись открытой страницы
    val coroutineScope = rememberCoroutineScope() // запуск анимации


    Column(modifier = Modifier.padding(top = 106.dp)) {

        TabRow(
            selectedTabIndex = tabIndex,//тут создаю 2 кнопки Камеры и Двери
            backgroundColor = Color.White,
            contentColor = colorResource(id = R.color.MyBlue),
            indicator = { pos ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, pos)
                )
            }
        ) {
            tabList.forEachIndexed { index, text ->
                Tab(
                    selected = false,
                    onClick = {

                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index) //добавляет корутин скоп так как анимация делается на вторстепенном потоке
                        }

                    },
                    text = {
                        Text(
                            text = text,
                            style = TextStyle(fontSize = 17.sp, fontFamily = FontFamily(circeFont), fontWeight = FontWeight.W400),
                            color = Color.Black
                        )
                    }
                )
            }
        }


        HorizontalPager(
            count = tabList.size, //количество элементов
            state = pagerState,
            modifier = Modifier.weight(1.0f),
        ) {

                index ->

        }
    }
}