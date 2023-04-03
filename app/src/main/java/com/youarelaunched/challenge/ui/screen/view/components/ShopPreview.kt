package com.youarelaunched.challenge.ui.screen.view.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.youarelaunched.challenge.middle.R
import com.youarelaunched.challenge.ui.theme.VendorAppTheme

@Composable
fun ShopPreview(
    url: String,
    favorite: Boolean,
    area: String,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .height(170.dp)
    ) {
        val (image, favoriteBtn, shopDistance) = createRefs()

        UrlImage(
            url = url,
            placeholderRes = R.drawable.placeholder_image_loading,
            modifier = Modifier
                .constrainAs(image) {
                    linkTo(
                        top = parent.top,
                        bottom = parent.bottom,
                        start = parent.start,
                        end = parent.end
                    )
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                },
            shape = RoundedCornerShape(10.dp)
        )

        FavoriteButton(
            favorite = favorite,
            onClick = { },
            modifier = Modifier.constrainAs(favoriteBtn) {
                end.linkTo(
                    anchor = parent.end, margin = 10.dp
                )
                top.linkTo(
                    anchor = parent.top, margin = 10.dp
                )
            }
        )

        TextChips(
            text = area,
            modifier = Modifier.constrainAs(shopDistance) {
                start.linkTo(
                    anchor = parent.start,
                    margin = 10.dp
                )
                bottom.linkTo(
                    anchor = parent.bottom,
                    margin = 10.dp
                )
            }
        )
    }
}

@Composable
private fun FavoriteButton(
    favorite: Boolean,
    onClick: (favorite: Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor = if (favorite) {
        VendorAppTheme.colors.buttonSelected
    } else {
        VendorAppTheme.colors.buttonUnselected
    }

    val contentColor = if (favorite) {
        VendorAppTheme.colors.buttonUnselected
    } else {
        VendorAppTheme.colors.buttonSelected
    }

    val icon = if (favorite) {
        R.drawable.ic_bookmark_selected
    } else {
        R.drawable.ic_bookmark
    }

    Card(
        modifier = modifier.size(36.dp),
        shape = RoundedCornerShape(percent = 50),
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        elevation = 2.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable { onClick(favorite) },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(icon),
                contentDescription = null
            )
        }
    }
}

@Composable
private fun TextChips(
    text: String,
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues(
        vertical = 2.dp,
        horizontal = 6.dp
    ),
) {
    Surface(
        modifier = modifier,
        color = Color.White,
        shape = RoundedCornerShape(percent = 50),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(paddingValues)
        ) {
            Text(
                text = text,
                color = VendorAppTheme.colors.textDark,
                style = VendorAppTheme.typography.body2,
            )
        }
    }
}
