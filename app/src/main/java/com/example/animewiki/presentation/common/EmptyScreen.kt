package com.example.animewiki.presentation.common

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.animewiki.R
import com.example.animewiki.domain.model.Hero
import com.example.animewiki.ui.theme.DarkGray
import com.example.animewiki.ui.theme.LightGray
import com.example.animewiki.util.NETWORK_ERROR_ICON_HEIGHT
import com.example.animewiki.util.SMALL_PADDING
import java.net.ConnectException
import java.net.SocketTimeoutException

@Composable
fun EmptyScreen(
    error: LoadState.Error? = null,
    heroes: LazyPagingItems<Hero>? = null
) {
    var message by remember {
        mutableStateOf("Find Your Favourite Hero!")
    }
    var icon by remember {
        mutableIntStateOf(R.drawable.search_document)
    }

    if (error != null) {
        message = parseErrorMessage(error = error)
        icon = R.drawable.network_error
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
    EmptyContent(alphaAnim, icon, message, heroes, error)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun EmptyContent(
    alphaAnim: Float,
    icon: Int,
    message: String,
    heroes: LazyPagingItems<Hero>? = null,
    error: LoadState.Error? = null,
) {

    var isRefreshing by remember {
        mutableStateOf(false)
    }
    PullToRefreshBox(
        modifier = Modifier.padding(top = WindowInsets.safeDrawing.asPaddingValues().calculateTopPadding()),
        isRefreshing = isRefreshing,
        onRefresh = {
            isRefreshing = true
            heroes?.refresh()
            isRefreshing = false
        },
        state = rememberPullToRefreshState(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier
                    .alpha(alphaAnim)
                    .size(NETWORK_ERROR_ICON_HEIGHT),
                painter = painterResource(icon),
                contentDescription = message,
                tint = if (isSystemInDarkTheme()) LightGray else DarkGray,
            )
            Text(
                modifier = Modifier
                    .alpha(alphaAnim)
                    .padding(SMALL_PADDING),
                text = message,
                textAlign = TextAlign.Center,
                color = if (isSystemInDarkTheme()) LightGray else DarkGray,
                fontWeight = FontWeight.Medium,
                fontSize = MaterialTheme.typography.titleLarge.fontSize
            )
        }
    }
}

fun parseErrorMessage(error: LoadState.Error): String {
    return when (error.error) {
        is SocketTimeoutException -> {
            "Server Unavailable."
        }

        is ConnectException -> {
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