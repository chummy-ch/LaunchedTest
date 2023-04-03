package com.youarelaunched.challenge.ui.screen.view.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent

@Composable
fun UrlImage(
    url: String?,
    @DrawableRes placeholderRes: Int,
    modifier: Modifier = Modifier,
    scale: ContentScale = ContentScale.Crop,
    shape: Shape = RoundedCornerShape(0.dp),
    colorFilter: ColorFilter? = null
) {
    SubcomposeAsyncImage(
        contentScale = scale,
        contentDescription = null,
        modifier = modifier.clip(shape),
        colorFilter = colorFilter,
        model = url,
    ) {
        val state = painter.state
        if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
            Image(
                modifier = Modifier
                    .fillMaxHeight()
                    .clip(shape),
                contentScale = scale,
                painter = painterResource(placeholderRes),
                contentDescription = null
            )
        } else {
            SubcomposeAsyncImageContent()
        }
    }
}