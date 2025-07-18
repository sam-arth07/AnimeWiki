package com.example.animewiki.presentation.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.animewiki.ui.theme.AnimeWikiTheme
import com.example.animewiki.ui.theme.ShimmerDarkGray
import com.example.animewiki.ui.theme.ShimmerLightGray
import com.example.animewiki.ui.theme.ShimmerMediumGray
import com.example.animewiki.ui.theme.welcomeScreenBackgroundColor
import com.example.animewiki.util.ABOUT_PLACEHOLDER_HEIGHT
import com.example.animewiki.util.EXTRA_SMALL_PADDING
import com.example.animewiki.util.HERO_ITEM_HEIGHT
import com.example.animewiki.util.LARGE_PADDING
import com.example.animewiki.util.MEDIUM_PADDING
import com.example.animewiki.util.NAME_PLACEHOLDER_HEIGHT
import com.example.animewiki.util.SMALL_PADDING
import com.example.animewiki.util.STAR_PLACEHOLDER_HEIGHT

@Composable
fun ShimmerEffect() {
    LazyColumn(
        modifier = Modifier
            .padding(top = WindowInsets.safeDrawing.asPaddingValues().calculateTopPadding() + LARGE_PADDING),
        contentPadding = PaddingValues(all = SMALL_PADDING),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
    ) {
        items(3) {
            AnimatedShimmerItem()
        }
    }
}

@Composable
fun AnimatedShimmerItem() {
    val transition = rememberInfiniteTransition()
    val alphaAnimation by transition.animateFloat(
        initialValue = 1f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 500, easing = FastOutLinearInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    ShimmerItem(alpha = alphaAnimation)
}

@Composable
fun ShimmerItem(alpha: Float) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(HERO_ITEM_HEIGHT),
        color = if (isSystemInDarkTheme()) Color.Black else ShimmerLightGray,
        shape = RoundedCornerShape(size = LARGE_PADDING)
    ) {
        Column(modifier = Modifier.padding(MEDIUM_PADDING), verticalArrangement = Arrangement.Bottom) {
            Surface(
                modifier = Modifier
                    .alpha(alpha = alpha)
                    .fillMaxWidth(0.5f)
                    .height(NAME_PLACEHOLDER_HEIGHT),
                color = if (isSystemInDarkTheme()) ShimmerDarkGray else ShimmerMediumGray,
                shape = RoundedCornerShape(size = SMALL_PADDING)
            ) {}
            Spacer(modifier = Modifier.padding(all = SMALL_PADDING))
            repeat(3) {
                Surface(
                    modifier = Modifier
                        .alpha(alpha = alpha)
                        .fillMaxWidth()
                        .height(ABOUT_PLACEHOLDER_HEIGHT),
                    color = if (isSystemInDarkTheme()) ShimmerDarkGray else ShimmerMediumGray,
                    shape = RoundedCornerShape(size = SMALL_PADDING)
                ) {}
                Spacer(modifier = Modifier.padding(all = EXTRA_SMALL_PADDING))
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                repeat(5) {
                    Surface(
                        modifier = Modifier
                            .alpha(alpha = alpha)
                            .size(STAR_PLACEHOLDER_HEIGHT),
                        color = if (isSystemInDarkTheme()) ShimmerDarkGray else ShimmerMediumGray,
                        shape = RoundedCornerShape(size = SMALL_PADDING)
                    ) {}
                    Spacer(modifier = Modifier.padding(all = SMALL_PADDING))
                }
            }
        }
    }
}

@Preview
@Composable
fun ShimmerItemPreview() {
    AnimatedShimmerItem()
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ShimmerItemDarkPreview() {
    AnimatedShimmerItem()
}