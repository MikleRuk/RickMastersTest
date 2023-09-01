package com.example.rickmasterstest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.rickmasterstest.ui.theme.MainScreen
import com.example.rickmasterstest.ui.theme.RickMastersTestTheme
import com.example.rickmasterstest.ui.theme.TabLayout

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickMastersTestTheme {
            Column() {
                MainScreen()
                TabLayout()
            }
            }
        }
    }
}
