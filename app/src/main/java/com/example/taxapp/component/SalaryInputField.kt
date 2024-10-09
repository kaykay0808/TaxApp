package com.example.taxapp.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taxapp.R
import com.example.taxapp.ui.theme.MEDIUM_PADDING

@Composable
fun SalaryInputField(
    modifier: Modifier = Modifier,
    inputValueState: String,
    labelId: String,
    isSingleLine: Boolean,
    enabled: Boolean,
    // viewModel: TaxViewModel,
    valueChanged: (String) -> Unit,
    valueReset: () -> Unit,
    keyboardType: KeyboardType = KeyboardType.Number,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default,
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(2.dp),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        border = BorderStroke(width = 1.dp, color = Color.LightGray),
    ) {
        Column(
            modifier = Modifier.padding(6.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            OutlinedTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(all = MEDIUM_PADDING),
                value = inputValueState, // removed.value
                onValueChange = valueChanged, // { newInputVal -> viewModel.onInputValueChange(newInputVal) },
                label = { Text(text = labelId) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.AttachMoney,//AttachMoney,
                        contentDescription = "Money Icon"
                    )
                },
                trailingIcon = {
                    IconButton(
                        onClick = valueReset // { viewModel.onResetInputValueChange() }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = stringResource(id = R.string.close_icon),
                            tint = MaterialTheme.colorScheme.primary//MaterialTheme.colors.primary
                        )
                    }
                },
                textStyle = TextStyle(
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onBackground
                ),
                singleLine = isSingleLine,
                enabled = enabled,
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType,
                    imeAction = imeAction
                ),
                keyboardActions = onAction
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SalaryInputFieldPreview() {
    SalaryInputField(
        // viewModel = taxViewModel,
        valueChanged = {},
        valueReset = {},
        inputValueState = "1000",
        labelId = "Enter the salary",
        enabled = true,
        isSingleLine = true,
    )
}
