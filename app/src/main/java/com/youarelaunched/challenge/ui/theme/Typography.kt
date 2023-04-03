package com.youarelaunched.challenge.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.youarelaunched.challenge.middle.R

private val SfUiTextFamily = FontFamily(
    listOf(
        Font(R.font.sf_ui_text_regular, FontWeight.Normal),
        Font(R.font.sf_ui_text_bold, FontWeight.Bold),
        Font(R.font.sf_ui_text_semibold, FontWeight.SemiBold)
    )
)

val VendorAppTypography = Typography(
    defaultFontFamily = SfUiTextFamily,
    h1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    ),
    h4 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
    subtitle1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    subtitle2 = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        lineHeight = 22.sp,
        letterSpacing = (-0.41).sp
    ),
    body2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp
    )
)