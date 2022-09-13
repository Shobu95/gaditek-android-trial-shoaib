package com.example.gaditek_android_trial_shoaib.ui.screens.components.error_view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gaditek_android_trial_shoaib.R


@Preview
@Composable
fun ErrorViewPrev() {
    ErrorView {

    }
}

@Composable
fun ErrorView(
    onReloadClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.img_error),
            "Error Image"
        )
        Text(
            modifier = Modifier.padding(vertical = 14.dp),
            text = "Something went wrong!",
            style = MaterialTheme.typography.h6
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .padding(horizontal = 14.dp),
            onClick = onReloadClick
        ) {
            Text(text = "Reload")
        }

    }


}
