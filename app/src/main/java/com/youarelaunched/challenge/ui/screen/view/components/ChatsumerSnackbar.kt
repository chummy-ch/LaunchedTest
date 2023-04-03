package com.youarelaunched.challenge.ui.screen.view.components

import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.youarelaunched.challenge.ui.theme.VendorAppTheme

@Composable
fun ChatsumerSnackbar(hostState: SnackbarHostState) {
    SnackbarHost(hostState) { snackbarData ->
        Snackbar(
            snackbarData = snackbarData,
            modifier = Modifier.systemBarsPadding(),
            backgroundColor = VendorAppTheme.colors.snackBarBackground,
            contentColor = VendorAppTheme.colors.textLight
        )
    }
}