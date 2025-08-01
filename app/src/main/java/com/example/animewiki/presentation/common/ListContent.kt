package com.example.animewiki.presentation.common

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.error
import coil3.request.placeholder
import com.example.animewiki.R
import com.example.animewiki.domain.model.Hero
import com.example.animewiki.navigation.Screens
import com.example.animewiki.presentation.components.RatingWidget
import com.example.animewiki.presentation.components.ShimmerEffect
import com.example.animewiki.ui.theme.topAppBarContentColor
import com.example.animewiki.ui.theme.welcomeScreenBackgroundColor
import com.example.animewiki.util.Constants.BASE_URL
import com.example.animewiki.util.HERO_ITEM_HEIGHT
import com.example.animewiki.util.LARGE_PADDING
import com.example.animewiki.util.MEDIUM_PADDING
import com.example.animewiki.util.SMALL_PADDING

@Composable
fun ListContent(
    navController: NavHostController,
    heroes: LazyPagingItems<Hero>,
    modifier: Modifier,
) {
    val result = handlePagingResult(heroes)
    if (result) {
        LazyColumn(
            modifier = modifier,
            contentPadding = PaddingValues(all = SMALL_PADDING),
            verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
        ) {
            items(heroes.itemCount, key = { it }) { index ->
                val hero = heroes[index]
                hero?.let {
                    HeroItem(
                        navController = navController, hero = it
                    )
                }
            }
        }
    }
}

/**
 * Returns false if data is loading and true if data is ready to be displayed to the users.
 */

@Composable
fun handlePagingResult(
    heroes: LazyPagingItems<Hero>
): Boolean {
    heroes.apply {
        val error = when {
            loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
            loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
            loadState.append is LoadState.Error -> loadState.append as LoadState.Error
            else -> null
        }
        return when {
            loadState.refresh is LoadState.Loading -> {
                ShimmerEffect()
                false
            }

            error != null -> {
                EmptyScreen(error, heroes)
                false
            }

            heroes.itemCount < 1 -> {
                //When we have no heroes to display in the search screen or just entered search screen
                EmptyScreen()
                true
            }

            else -> {
                true
            }
        }
    }
}

@Composable
fun HeroItem(
    navController: NavHostController,
    hero: Hero,
) {
    Box(
        modifier = Modifier
            .height(HERO_ITEM_HEIGHT)
            .clickable {
                navController.navigate(Screens.Details(heroId = hero.id))
            }, contentAlignment = Alignment.BottomStart
    ) {
        Surface(
            shape = RoundedCornerShape(
                bottomStart = LARGE_PADDING, bottomEnd = LARGE_PADDING
            )
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = ImageRequest.Builder(LocalContext.current)
                    .data("$BASE_URL${hero.image}")
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder)
                    .build(),
                contentDescription = stringResource(R.string.hero_image),
                contentScale = ContentScale.Crop
            )
        }
        Surface(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth(),
            color = Color.Black.copy(alpha = 0.5f),
            shape = RoundedCornerShape(
                bottomStart = LARGE_PADDING, bottomEnd = LARGE_PADDING
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(MEDIUM_PADDING)
            ) {
                Text(
                    text = hero.name,
                    color = MaterialTheme.colorScheme.topAppBarContentColor,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = hero.about,
                    color = Color.White.copy(0.7f),
                    fontSize = MaterialTheme.typography.titleSmall.fontSize,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    modifier = Modifier.padding(top = SMALL_PADDING / 2.5f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RatingWidget(
                        modifier = Modifier.padding(end = SMALL_PADDING),
                        rating = hero.rating,
                    )
                    Text(
                        text = "(${hero.rating})",
                        textAlign = TextAlign.Center,
                        color = Color.White.copy(0.7f),
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun HeroPreview() {
    HeroItem(
        navController = rememberNavController(), hero = Hero(
            id = 1,
            name = "Naruto",
            image = "",
            about = "fevryuf bd nebwg cvdjhbknmbhgvfcdxszadxfcgvhbjnkhbgvfcdxszexdfcgvhbjnkmlnbvcfxzsadxfcgv hbjnmknbhgvfcdxsedzxdfcgvhbjnkhbgvfcdxfcgvhbjnkm",
            rating = 4.4,
            power = 5,
            month = "10",
            day = "3",
            abilities = listOf("nwrvjfed"),
            family = listOf("KageBun"),
            natureTypes = listOf("nwrvjfed"),
        )
    )
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun HeroDarkPreview() {
    HeroItem(
        navController = rememberNavController(), hero = Hero(
            id = 1,
            name = "Naruto",
            image = "",
            about = "fevryuf bd nebwg cvdjhbknmbhgvfcdxszadxfcgvhbjnkhbgvfcdxszexdfcgvhbjnkmlnbvcfxzsadxfcgv hbjnmknbhgvfcdxsedzxdfcgvhbjnkhbgvfcdxfcgvhbjnkm",
            rating = 4.4,
            power = 5,
            month = "10",
            day = "3",
            abilities = listOf("nwrvjfed"),
            family = listOf("KageBun"),
            natureTypes = listOf("nwrvjfed"),
        )
    )
}