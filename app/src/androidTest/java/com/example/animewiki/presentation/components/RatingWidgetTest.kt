package com.example.animewiki.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import com.example.animewiki.util.SMALL_PADDING
import org.junit.Rule
import org.junit.Test

class RatingWidgetTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun passZeroPointZeroValue_Assert_FiveEmptyStars() {
        composeTestRule.setContent {
            RatingWidget(
                modifier = Modifier.padding(all = SMALL_PADDING),
                rating = 0.0,
            )
        }
        composeTestRule.onAllNodesWithContentDescription("EmptyStar")
            .assertCountEquals(5)
        composeTestRule.onAllNodesWithContentDescription("HalfFilledStar")
            .assertCountEquals(0 )
        composeTestRule.onAllNodesWithContentDescription("FilledStar")
            .assertCountEquals(0)
    }

    @Test
    fun passTwoPointFiveValue_Assert_TwoEmptyStars_OneHalfFilledStars_TwoFilledStars() {
        composeTestRule.setContent {
            RatingWidget(
                modifier = Modifier.padding(all = SMALL_PADDING),
                rating = 2.5,
            )
        }
        composeTestRule.onAllNodesWithContentDescription("FilledStar")
            .assertCountEquals(2)
        composeTestRule.onAllNodesWithContentDescription("HalfFilledStar")
            .assertCountEquals(1)
        composeTestRule.onAllNodesWithContentDescription("EmptyStar")
            .assertCountEquals(2)
    }
    @Test
    fun passOnePointSevenValue_Assert_ThreeEmptyStars_ZeroHalfFilledStars_TwoFilledStars() {
        composeTestRule.setContent {
            RatingWidget(
                modifier = Modifier.padding(all = SMALL_PADDING),
                rating = 1.7,
            )
        }
        composeTestRule.onAllNodesWithContentDescription("FilledStar")
            .assertCountEquals(2)
        composeTestRule.onAllNodesWithContentDescription("HalfFilledStar")
            .assertCountEquals(0)
        composeTestRule.onAllNodesWithContentDescription("EmptyStar")
            .assertCountEquals(3)
    }

    @Test
    fun passNegativeValue_Assert_FiveEmptyStars() {
        composeTestRule.setContent {
            RatingWidget(
                modifier = Modifier.padding(all = SMALL_PADDING),
                rating = -1.7,
            )
        }
        composeTestRule.onAllNodesWithContentDescription("FilledStar")
            .assertCountEquals(0)
        composeTestRule.onAllNodesWithContentDescription("HalfFilledStar")
            .assertCountEquals(0)
        composeTestRule.onAllNodesWithContentDescription("EmptyStar")
            .assertCountEquals(5)
    }

    @Test
    fun passInvalidValue_Assert_FiveEmptyStars() {
        composeTestRule.setContent {
            RatingWidget(
                modifier = Modifier.padding(all = SMALL_PADDING),
                rating = 5.2,
            )
        }
        composeTestRule.onAllNodesWithContentDescription("FilledStar")
            .assertCountEquals(0)
        composeTestRule.onAllNodesWithContentDescription("HalfFilledStar")
            .assertCountEquals(0)
        composeTestRule.onAllNodesWithContentDescription("EmptyStar")
            .assertCountEquals(5)
    }
}