package com.example.animewiki.presentation.common

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.LazyPagingItems
import coil3.compose.rememberAsyncImagePainter
import com.example.animewiki.R
import com.example.animewiki.domain.model.Hero
import com.example.animewiki.navigation.Screens
import com.example.animewiki.presentation.components.RatingWidget
import com.example.animewiki.ui.theme.topAppBarContentColor
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

@Composable
fun HeroItem(
    navController: NavHostController,
    hero: Hero,
) {

    val painter = rememberAsyncImagePainter(
        model = "$BASE_URL${hero.image}",
        placeholder = painterResource(R.drawable.placeholder),
        error = painterResource(R.drawable.placeholder)
    )

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
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painter,
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