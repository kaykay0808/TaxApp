package com.example.taxapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.taxapp.ui.theme.LARGE_PADDING

@Composable
fun MainScreen(taxViewModel: TaxViewModel) {
    val viewState = taxViewModel.viewState
    Column(modifier = Modifier.padding(all = LARGE_PADDING)) {

    }
}
