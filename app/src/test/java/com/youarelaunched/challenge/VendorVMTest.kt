package com.youarelaunched.challenge

import com.youarelaunched.challenge.data.repository.VendorsRepository
import com.youarelaunched.challenge.data.repository.model.Vendor
import com.youarelaunched.challenge.ui.screen.view.VendorsVM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever


@ExperimentalCoroutinesApi
class VendorsVMTest {

    private val testDispatcher = UnconfinedTestDispatcher()
    private lateinit var repository: VendorsRepository
    private lateinit var viewModel: VendorsVM

    @BeforeEach
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        repository = mock()
        viewModel = VendorsVM(repository)
    }

    @Test
    fun getVendors_Success() = runTest {
        val mockVendors = listOf(
            Vendor(
                id = 1,
                companyName = "Test Company 1",
                coverPhoto = "https://example.com/coverPhoto1.jpg",
                area = "Test Area 1",
                favorite = true,
                null,
                tags = "tag1,tag2"
            ),
            Vendor(
                id = 2,
                companyName = "Test Company 2",
                coverPhoto = "https://example.com/coverPhoto2.jpg",
                area = "Test Area 2",
                favorite = false,
                null,
                tags = "tag3,tag4"
            )
        )
        whenever(repository.getVendors("test")) doReturn mockVendors

        viewModel.getVendors("test")

        val uiState = viewModel.uiState.value
        assertTrue(uiState.vendors == mockVendors)
    }

    @Test
    fun getVendors_Error() = runTest {
        whenever(repository.getVendors("")) doReturn listOf()

        viewModel.getVendors("")

        val uiState = viewModel.uiState.value
        assertTrue(uiState.vendors?.isEmpty() == true)
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }
}




