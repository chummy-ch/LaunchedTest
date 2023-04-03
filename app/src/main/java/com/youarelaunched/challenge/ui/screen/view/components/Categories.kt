package com.youarelaunched.challenge.ui.screen.view.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.youarelaunched.challenge.data.repository.model.VendorCategory
import com.youarelaunched.challenge.middle.R
import com.youarelaunched.challenge.ui.theme.VendorAppTheme

@Composable
fun CategoriesLayout(
    categories: List<VendorCategory>,
    modifier: Modifier = Modifier
) {
    FlowRow(
        modifier = modifier.fillMaxWidth(),
        mainAxisSpacing = 14.dp,
        crossAxisSpacing = 4.dp
    ) {
        categories.forEach { category ->
            CategoryInfoItem(
                category = category
            )
        }
    }
}

@Composable
private fun CategoryInfoItem(
    category: VendorCategory,
    modifier: Modifier = Modifier,
    tint: Color = VendorAppTheme.colors.textDark,
    textStyle: TextStyle = VendorAppTheme.typography.body2
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        UrlImage(
            modifier = Modifier.size(22.dp),
            url = category.imgUrl,
            placeholderRes = R.drawable.ic_category_placeholder,
            colorFilter = ColorFilter.tint(tint)
        )
        Spacer(
            modifier = Modifier.width(6.dp)
        )
        Text(
            text = category.title,
            color = tint,
            style = textStyle
        )
    }
}