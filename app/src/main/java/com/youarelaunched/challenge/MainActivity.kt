package com.youarelaunched.challenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.youarelaunched.challenge.ui.screen.view.VendorsRoute
import com.youarelaunched.challenge.ui.screen.view.VendorsVM
import com.youarelaunched.challenge.ui.theme.VendorAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: VendorsVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VendorAppTheme {
                VendorsRoute(viewModel = viewModel)
            }
        }
    }
}
