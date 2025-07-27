package com.example.animewiki.presentation.screens.search

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animewiki.ui.theme.topAppBarBackgroundColor
import com.example.animewiki.util.TOP_APP_BAR_HEIGHT
import com.example.animewiki.R
import com.example.animewiki.ui.theme.topAppBarContentColor
import com.example.animewiki.util.LARGE_PADDING
import com.example.animewiki.util.SMALL_PADDING

@Composable
fun SearchTopBar(
    text: String,
    onTextChange: (String) -> Unit,
    onSearchClicked: (String) -> Unit,
    onCloseClicked: () -> Unit,
) {
    SearchWidget(
        text = text,
        onTextChange = onTextChange,
        onSearchClicked = onSearchClicked,
        onCloseClicked = onCloseClicked
    )
}

@Composable
fun SearchWidget(
    text: String,
    onTextChange: (String) -> Unit,
    onSearchClicked: (String) -> Unit,
    onCloseClicked: () -> Unit,
) {
    Surface(
        modifier = Modifier
            .padding(top = WindowInsets.safeDrawing.asPaddingValues().calculateTopPadding())
            .fillMaxWidth()
            .height(TOP_APP_BAR_HEIGHT)
            .semantics {
                contentDescription = "SearchWidget"
            },
        //add elevation
        tonalElevation = 4.dp,
        shadowElevation = 8.dp,
        color = MaterialTheme.colorScheme.topAppBarBackgroundColor,
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .semantics {
                    contentDescription = "TextField"
                },
            value = text,
            onValueChange = { onTextChange(it) },
            leadingIcon = {
                IconButton(
                    modifier = Modifier
                        .alpha(MaterialTheme.colorScheme.onSurfaceVariant.alpha),
                    onClick = { onSearchClicked(text) }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = stringResource(R.string.search_icon),
                        tint = MaterialTheme.colorScheme.topAppBarContentColor
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    modifier = Modifier.semantics {
                        contentDescription = "CloseIcon"
                    },
                    onClick = {
                        if (text.isNotEmpty()) {
                            onTextChange("")
                        } else {
                            onCloseClicked()
                        }
                    }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = stringResource(R.string.close_icon),
                        tint = MaterialTheme.colorScheme.topAppBarContentColor
                    )
                }
            },
            placeholder = {
                Text(
                    modifier = Modifier
                        .alpha(MaterialTheme.colorScheme.onSurfaceVariant.alpha),
                    text = "Search Here...",
                    color = Color.White
                )
            },
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.topAppBarContentColor
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = { onSearchClicked(text) }
            ),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                cursorColor = MaterialTheme.colorScheme.topAppBarContentColor
            )
        )
    }
}

@Preview
@Composable
fun SearchWidgetPreview() {
    SearchWidget(
        text = "",
        onTextChange = {},
        onSearchClicked = {},
        onCloseClicked = {})
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SearchWidgetDarkPreview() {
    SearchWidget(
        text = "",
        onTextChange = {},
        onSearchClicked = {},
        onCloseClicked = {})
}