package com.example.taxapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.taxapp.ui.screen.MainScreen
import com.example.taxapp.ui.screen.TaxViewModel
import com.example.taxapp.ui.theme.TaxAppTheme

class MainActivity : ComponentActivity() {
    private val taxViewModel: TaxViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaxAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(
                        taxViewModel = taxViewModel
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    val taxViewModel = TaxViewModel()
    Surface(color = MaterialTheme.colorScheme.background) {
        MainScreen(taxViewModel = taxViewModel)
    }
}