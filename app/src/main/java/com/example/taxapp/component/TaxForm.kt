package com.example.taxapp.component

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import com.example.taxapp.ui.screen.TaxViewModel
import com.example.taxapp.ui.screen.TaxViewState

@SuppressLint("RememberReturnType")
@Composable
fun TaxForm(
    viewState: TaxViewState,
    taxViewModel: TaxViewModel
) {
    // Validate if the TotalBillState is empty
    val validState = remember(viewState.netSalaryString) {
        viewState.netSalaryString
            .trim()
            .isNotEmpty()
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    TaxHeader()
}
