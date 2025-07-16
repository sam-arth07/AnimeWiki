package com.example.animewiki.presentation.screens.details

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color.parseColor
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.error
import com.example.animewiki.R
import com.example.animewiki.domain.model.Hero
import com.example.animewiki.presentation.components.InfoBox
import com.example.animewiki.presentation.components.OrderedList
import com.example.animewiki.ui.theme.titleColor
import com.example.animewiki.util.*
import com.example.animewiki.util.Constants.BASE_URL
import com.example.animewiki.util.Constants.MIN_BACKGROUND_IMAGE_FRACTION

@SuppressLint("ContextCastToActivity")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsContent(
    navController: NavHostController,
    selectedHero: Hero?,
    colors: Map<String, String>
) {
    val activity = LocalContext.current as Activity

    var vibrant by remember {
        mutableStateOf("#000000")
    }
    var darkVibrant by remember {
        mutableStateOf("#000000")
    }
    var onDarkVibrant by remember {
        mutableStateOf("#FFFFFF")
    }

    LaunchedEffect(selectedHero) {
        colors["vibrant"]?.let { vibrant = it }
        colors["darkVibrant"]?.let { darkVibrant = it }
        colors["onDarkVibrant"]?.let { onDarkVibrant = it }
    }

    SideEffect {
        activity.window.statusBarColor = Color(darkVibrant.toColorInt()).toArgb()
    }

    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(initialValue = SheetValue.Expanded)
    )
    val currentSheetFraction = scaffoldState.currentSheetFraction

    val radiusAnim by animateDpAsState(
        targetValue = if (currentSheetFraction == 1f) EXTRA_LARGE_PADDING else EXPANDED_RADIUS_LEVEL
    )

    BottomSheetScaffold(
        sheetShape = RoundedCornerShape(
            topStart = radiusAnim,
            topEnd = radiusAnim
        ),
        scaffoldState = scaffoldState,
        sheetPeekHeight = BOTTOM_SHEET_PEEK_HEIGHT,
        sheetDragHandle = {},
        sheetContent = {
            selectedHero?.let {
                BottomSheetContent(
                    selectedHero = it,
                    infoBoxIconColor = Color(parseColor(vibrant)),
                    sheetBgColor = Color(parseColor(darkVibrant)),
                    contentColor = Color(parseColor(onDarkVibrant)),
                )
            }
        }
    ) {
        selectedHero?.let { hero ->
            BackgroundContent(
                heroImage = hero.image,
                imageFraction = currentSheetFraction,
                onCloseClicked = {
                    navController.popBackStack()
                },
                backgroundColor = Color(parseColor(darkVibrant))
            )
        }
    }
}


@Composable
fun BottomSheetContent(
    selectedHero: Hero,
    infoBoxIconColor: Color = MaterialTheme.colorScheme.primary,
    sheetBgColor: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = MaterialTheme.colorScheme.titleColor
) {
    Column(
        modifier = Modifier
            .background(sheetBgColor)
            .padding(LARGE_PADDING)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = LARGE_PADDING),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .size(INFO_ICON_SIZE)
                    .weight(2f),
                painter = painterResource(R.drawable.logo),
                contentDescription = stringResource(R.string.app_logo),
                tint = contentColor
            )
            Text(
                modifier = Modifier.weight(8f),
                text = selectedHero.name,
                color = contentColor,
                fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                fontWeight = FontWeight.Bold
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = MEDIUM_PADDING),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            InfoBox(
                icon = painterResource(R.drawable.bolt),
                bigText = "${selectedHero.power}",
                smallText = stringResource(R.string.small_text_power),
                iconColor = infoBoxIconColor,
                textColor = contentColor
            )
            InfoBox(
                icon = painterResource(R.drawable.calendar),
                bigText = selectedHero.month,
                smallText = stringResource(R.string.small_text_month),
                iconColor = infoBoxIconColor,
                textColor = contentColor
            )
            InfoBox(
                icon = painterResource(R.drawable.cake),
                bigText = selectedHero.day,
                smallText = stringResource(R.string.small_text_birthday),
                iconColor = infoBoxIconColor,
                textColor = contentColor
            )
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = SMALL_PADDING),
            text = stringResource(R.string.about_title),
            color = contentColor,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier
                .alpha(
                    alpha = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f).alpha
                )
                .padding(bottom = MEDIUM_PADDING),
            text = selectedHero.about,
            color = contentColor,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            maxLines = ABOUT_MAX_LINES
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OrderedList(
                title = stringResource(R.string.family),
                items = selectedHero.family,
                textColor = contentColor
            )
            OrderedList(
                title = stringResource(R.string.abilities),
                items = selectedHero.abilities,
                textColor = contentColor
            )
            OrderedList(
                title = stringResource(R.string.nature_types),
                items = selectedHero.natureTypes,
                textColor = contentColor
            )

        }
    }
}


@SuppressLint("Range")
@Composable
fun BackgroundContent(
    heroImage: String,
    imageFraction: Float = 1f,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    onCloseClicked: () -> Unit
) {

    val imageUrl = "$BASE_URL$heroImage"
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .padding(top = WindowInsets.safeDrawing.asPaddingValues().calculateTopPadding())
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(imageFraction + MIN_BACKGROUND_IMAGE_FRACTION)
                .align(Alignment.TopStart),
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .error(R.drawable.placeholder)
                .build(),
            contentDescription = stringResource(R.string.hero_image),
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(
                onClick = { onCloseClicked() },
                modifier = Modifier.padding(SMALL_PADDING)
            ) {
                Icon(
                    modifier = Modifier.size(INFO_ICON_SIZE),
                    imageVector = Icons.Default.Close,
                    contentDescription = stringResource(R.string.close_icon),
                    tint = Color.White
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
val BottomSheetScaffoldState.currentSheetFraction: Float
    get() {
        val targetValue = bottomSheetState.targetValue
        val currentValue = bottomSheetState.currentValue

        return when {
            currentValue == SheetValue.Hidden && targetValue == SheetValue.Hidden -> 1f
            currentValue == SheetValue.Expanded && targetValue == SheetValue.Expanded -> 0f
            currentValue == SheetValue.Hidden && targetValue == SheetValue.Expanded -> 1f
            currentValue == SheetValue.Expanded && targetValue == SheetValue.Hidden -> 0f
            else -> 1f
        }
    }


@Preview
@Composable
private fun ContentPreview() {
    BottomSheetContent(
        selectedHero = Hero(
            id = 1,
            name = "Naruto Uzumaki",
            image = "https://example.com/naruto.jpg",
            about = "A ninja from Konoha with dreams of becoming Hokage.",
            month = "October",
            day = "10",
            rating = 5.0,
            power = 9000,
            abilities = listOf("Shadow Clone", "Rasenga n", "Sage Mode"),
            family = listOf("Minato", "Kushina"),
            natureTypes = listOf("Wind", "Earth")
        )
    )
}