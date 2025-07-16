package com.example.animewiki.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.palette.graphics.Palette
import coil3.ImageLoader
import coil3.asDrawable
import coil3.request.ImageRequest
import coil3.request.SuccessResult
import coil3.request.allowHardware

object PaletteGenerator {

    /**
     * The image is fetched from the specified `imageUrl`, and corresponding Bitmap value is returned if the image is fetched successfully
     * otherwise null.
     *
     * @param imageUrl The String url of the image from which the color palette is to be generated.
     *
     * @return `Bitmap` The corresponding bitmap of the fetched image.
     * */
    suspend fun convertImageToBitmap(
        imageUrl: String,
        context: Context
    ): Bitmap? {
        val loader = ImageLoader(context = context)
        val request = ImageRequest.Builder(context = context)
            .data(imageUrl)
            .allowHardware(false)
            .build()
        val imageResult = loader.execute(request)
        return if (imageResult is SuccessResult) {
            (imageResult.image.asDrawable(context.resources) as BitmapDrawable).bitmap
        } else {
            null
        }
    }

    /**
     * Extracts colors from the image bitmap provided
     *
     * @param bitmap the image bitmap from which the color is to be extracted.
     *
     * @return a map of the actual color Profile (e.g. Vibrant, Muted, Dark Vibrant, etc...)
     * to the actual color value in String Format
     * */
    fun extractColorsFromBitmap(bitmap: Bitmap): Map<String, String> {
        return mapOf(
            "vibrant" to parseColorSwatch(Palette.from(bitmap).generate().vibrantSwatch),
            "darkVibrant" to parseColorSwatch(Palette.from(bitmap).generate().darkVibrantSwatch),
            "onDarkVibrant" to parseIntColor(Palette.from(bitmap).generate().darkVibrantSwatch?.bodyTextColor),
        )
    }

    private fun parseColorSwatch(color: Palette.Swatch?): String {
        return if (color != null) {
            val parsedColor = Integer.toHexString(color.rgb)
            "#$parsedColor"
        } else {
            "#000000"
        }
    }

    private fun parseIntColor(color: Int?): String {
        return if (color != null) {
            val parsedColor = Integer.toHexString(color)
            "#$parsedColor"
        } else {
            "#FFFFFF"
        }
    }

}