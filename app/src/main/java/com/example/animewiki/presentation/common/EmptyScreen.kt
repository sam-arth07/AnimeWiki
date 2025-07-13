package com.example.animewiki.presentation.common

import android.content.ContentValues
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.LoadState
import com.example.animewiki.R
import com.example.animewiki.ui.theme.DarkGray
import com.example.animewiki.ui.theme.LightGray
import com.example.animewiki.util.NETWORK_ERROR_ICON_HEIGHT
import com.example.animewiki.util.SMALL_PADDING
import java.net.SocketTimeoutException

@Composable
fun EmptyScreen(
    error: LoadState.Error
) {
    val message by remember {
        mutableStateOf(parseErrorMessage(message = error.toString()))
    }
    val icon by remember {
        mutableIntStateOf(R.drawable.network_error)
    }

    var startAnimation by remember {
        mutableStateOf(false)
    }

    val alphaAnim by animateFloatAsState(
        targetValue = if (startAnimation) MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f).alpha else 0f,
        animationSpec = tween(
            durationMillis = 1000
        )
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier
                .alpha(alphaAnim).size(NETWORK_ERROR_ICON_HEIGHT),
            painter = painterResource(icon),
            contentDescription = message,
            tint = if (isSystemInDarkTheme()) LightGray else DarkGray,
        )
        Text(
            modifier = Modifier
                .alpha(alphaAnim).padding(SMALL_PADDING),
            text = message,
            textAlign = TextAlign.Center,
            color = if (isSystemInDarkTheme()) LightGray else DarkGray,
            fontWeight = FontWeight.Medium,
            fontSize = MaterialTheme.typography.titleLarge.fontSize
        )
    }

}

fun parseErrorMessage(message: String): String {
    return when {
        message.contains("SocketTimeoutException") -> {
            "Server Unavailable."
        }

        message.contains("ConnectException") -> {
            "Internet Unavailable."
        }

        else -> {
            "Unknown Error."
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EmptyScreenPreview() {
    EmptyScreen(LoadState.Error(SocketTimeoutException()))
}