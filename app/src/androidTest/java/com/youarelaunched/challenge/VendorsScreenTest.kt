package com.youarelaunched.challenge

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.youarelaunched.challenge.data.repository.model.Vendor
import com.youarelaunched.challenge.middle.R
import com.youarelaunched.challenge.ui.screen.state.VendorsScreenUiState
import com.youarelaunched.challenge.ui.screen.view.VendorsScreen
import com.youarelaunched.challenge.ui.theme.VendorAppTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class VendorsScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun emptyVendorList_displaysNoResultItem() {
        val uiState = VendorsScreenUiState(vendors = emptyList(), query = "")

        composeTestRule.setContent {
            VendorAppTheme {
                VendorsScreen(
                    uiState = uiState,
                    onQueryChanged = {},
                    onSearch = {}
                )
            }
        }

        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.title_empty_vendors)).assertIsDisplayed()
    }

    @Test
    fun nonEmptyVendorList_displaysAtLeastOneItem() {
        val testVendor = Vendor(
            id = 1,
            companyName = "Test Vendor",
            coverPhoto = "https://example.com/cover.jpg",
            area = "Test Area",
            favorite = false,
            categories = null,
            tags = "tag"
        )
        val uiState = VendorsScreenUiState(
            vendors = listOf(testVendor),
            query = ""
        )

        composeTestRule.setContent {
            VendorAppTheme {
                VendorsScreen(
                    uiState = uiState,
                    onQueryChanged = {},
                    onSearch = {}
                )
            }
        }

        composeTestRule.run {
            onNodeWithText(testVendor.companyName).assertIsDisplayed()
            onNodeWithText(testVendor.area).assertIsDisplayed()
            onNodeWithText(testVendor.tags!!).assertIsDisplayed()
        }
    }
}
