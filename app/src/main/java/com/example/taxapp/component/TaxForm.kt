package com.example.taxapp.component

import android.annotation.SuppressLint
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import com.example.taxapp.R
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
    // Salary Input Field
    SalaryInputField(
        inputValueState = viewState.netSalaryString,
        labelId = stringResource(id = R.string.input_field_label),
        valueChanged = { newInputVal -> taxViewModel.onInputValueChange(newInputVal) },
        valueReset = { taxViewModel.onResetInputValueChange() },
        enabled = true,
        isSingleLine = true,
        onAction = KeyboardActions {
            if (!validState) return@KeyboardActions
            // Todo - onValuedChanged
            // onValChange(viewState.totalSalaryAmountState.trim())
            keyboardController?.hide()
        }
    )
    // Tax Info Section
    TaxInfo(viewState = viewState)
}
