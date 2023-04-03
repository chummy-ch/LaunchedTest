package com.youarelaunched.challenge.ui.screen.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.youarelaunched.challenge.data.repository.model.Vendor
import com.youarelaunched.challenge.middle.R
import com.youarelaunched.challenge.ui.screen.state.VendorsScreenUiState
import com.youarelaunched.challenge.ui.screen.view.components.ChatsumerSnackbar
import com.youarelaunched.challenge.ui.screen.view.components.VendorItem
import com.youarelaunched.challenge.ui.theme.DarkGreen
import com.youarelaunched.challenge.ui.theme.VendorAppTheme

@Composable
fun VendorsRoute(
    viewModel: VendorsVM
) {
    val uiState by viewModel.uiState.collectAsState()

    VendorsScreen(
        uiState = uiState,
        onQueryChanged = viewModel::onQueryChanged,
        onSearch = viewModel::onSearch
    )
}

@Composable
fun VendorsScreen(
    uiState: VendorsScreenUiState,
    onQueryChanged: (String) -> Unit,
    onSearch: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = VendorAppTheme.colors.background,
        snackbarHost = { ChatsumerSnackbar(it) },
        topBar = {
            Column {
                Spacer(modifier = Modifier.height(24.dp))
                SearchField(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    onQueryChanged = onQueryChanged,
                    query = uiState.query,
                    onSearch = onSearch
                )
            }
        }
    ) { paddings ->

        if (!uiState.vendors.isNullOrEmpty()) {
            VendorList(
                modifier = Modifier
                    .padding(paddings)
                    .fillMaxSize(),
                vendors = uiState.vendors
            )
        } else {
            EmptyListItem(
                modifier = Modifier
                    .padding(paddings)
                    .fillMaxSize()
            )
        }
    }
}

@Composable
fun EmptyListItem(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(R.string.title_empty_vendors),
            style = VendorAppTheme.typography.h2.copy(fontWeight = FontWeight.W700, letterSpacing = (-0.42).sp, lineHeight = 30.sp),
            color = DarkGreen,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier
                .padding(horizontal = 28.dp)
                .fillMaxWidth(),
            text = stringResource(R.string.subtitle_empty_vendors),
            style = VendorAppTheme.typography.subtitle2,
            color = VendorAppTheme.colors.textDark,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    query: String,
    onQueryChanged: (String) -> Unit,
    onSearch: () -> Unit
) {
    val focusRequester = remember { FocusRequester() }
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .focusRequester(focusRequester),
        value = query,
        onValueChange = onQueryChanged,
        placeholder = {
            Text(
                text = stringResource(R.string.search_field_placeholder),
                style = VendorAppTheme.typography.subtitle2,
                color = VendorAppTheme.colors.text
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            backgroundColor = Color.Transparent,
            cursorColor = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
        ),
        trailingIcon = {
            IconButton(onClick = onSearch) {
                Icon(
                    painter = painterResource(R.drawable.ic_search),
                    contentDescription = "search",
                    tint = VendorAppTheme.colors.text
                )
            }
        },
        maxLines = 1,
        singleLine = true
    )
}

@Composable
fun VendorList(
    modifier: Modifier = Modifier,
    vendors: List<Vendor>,
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(
            vertical = 24.dp,
            horizontal = 16.dp
        )
    ) {
        items(vendors) { vendor ->
            VendorItem(
                vendor = vendor
            )
        }
    }
}