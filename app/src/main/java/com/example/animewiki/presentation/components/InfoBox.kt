package com.example.animewiki.presentation.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animewiki.R
import com.example.animewiki.ui.theme.AnimeWikiTheme
import com.example.animewiki.ui.theme.titleColor
import com.example.animewiki.util.INFO_ICON_SIZE
import com.example.animewiki.util.SMALL_PADDING

@Composable
fun InfoBox(
    icon: Painter,
    iconColor: Color,
    bigText: String,
    smallText: String,
    textColor: Color
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            modifier = Modifier
                .padding(end = SMALL_PADDING)
                .size(INFO_ICON_SIZE),
            painter = icon,
            contentDescription = stringResource(R.string.info_icon),
            tint = iconColor
        )
        Column {
            Text(
                text = bigText,
                color = textColor,
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                fontWeight = FontWeight.Black
            )
            Text(
                modifier = Modifier.alpha(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f).alpha),
                text = smallText,
                color = textColor,
                fontSize = MaterialTheme.typography.labelLarge.fontSize
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun InfoBoxPreview() {
    AnimeWikiTheme {
        InfoBox(
            icon = painterResource(R.drawable.bolt),
            iconColor = MaterialTheme.colorScheme.primary,
            bigText = "92",
            smallText = "Power",
            textColor = MaterialTheme.colorScheme.titleColor
        )
    }
}

@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
private fun InfoBoxDarkPreview() {
    AnimeWikiTheme {
        InfoBox(
            icon = painterResource(R.drawable.bolt),
            iconColor = MaterialTheme.colorScheme.primary,
            bigText = "92",
            smallText = "Power",
            textColor = MaterialTheme.colorScheme.titleColor
        )
    }
}