package com.example.taxapp.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taxapp.R
import com.example.taxapp.ui.theme.EXTRA_LARGE_PADDING
import com.example.taxapp.ui.theme.LARGE_PADDING
import com.example.taxapp.ui.theme.TOP_HEADER_HEIGHT
import com.example.taxapp.ui.theme.topHeaderBackground
import com.example.taxapp.ui.theme.topHeaderTextColor
import java.text.NumberFormat
import java.util.Locale

@Composable
fun TaxHeader(
    incomeAfterTax: Double = 0.0
) {
    val totalAfterTaxFormat = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("nb-NO"))
        .format(incomeAfterTax)/*"%.2f".format(incomeAfterTax)*/
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(EXTRA_LARGE_PADDING)
            .height(TOP_HEADER_HEIGHT)
            .clip(shape = CircleShape.copy(all = CornerSize(12.dp))),
        color = MaterialTheme.colorScheme.topHeaderBackground
    ) {
        Column(
            modifier = Modifier
                .padding(LARGE_PADDING),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.total_per_person),
                color = MaterialTheme.colorScheme.topHeaderTextColor,
                style = MaterialTheme.typography.titleSmall // h5
            )
            Text(
                text = totalAfterTaxFormat,
                color = MaterialTheme.colorScheme.topHeaderTextColor,
                style = MaterialTheme.typography.titleMedium, //h4
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}

@Preview
@Composable
fun TopHeaderPreview() {
    TaxHeader()
}