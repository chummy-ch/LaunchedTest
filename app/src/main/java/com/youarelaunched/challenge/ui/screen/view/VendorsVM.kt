package com.youarelaunched.challenge.ui.screen.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.youarelaunched.challenge.data.repository.VendorsRepository
import com.youarelaunched.challenge.ui.screen.state.VendorsScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class VendorsVM @Inject constructor(
    private val repository: VendorsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        VendorsScreenUiState(
            vendors = null,
            query = ""
        )
    )
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            uiState
                .map { it.query }
                .filter { it.length >= 3 || it.isEmpty() }
                .distinctUntilChanged()
                .debounce(500L)
                .collect { query ->
                    getVendors(query)
                }
        }
    }

    fun onQueryChanged(newQuery: String) {
        _uiState.update { it.copy(query = newQuery) }
    }

    fun onSearch() {
        getVendors(uiState.value.query)
    }

    fun getVendors(query: String) {
        viewModelScope.launch {
            _uiState.update {
                val vendors = repository.getVendors(query)
                it.copy(
                    vendors = vendors,
                )
            }
        }
    }
}