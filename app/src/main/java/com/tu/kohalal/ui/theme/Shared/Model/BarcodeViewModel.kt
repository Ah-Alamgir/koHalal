package com.tu.kohalal.ui.theme.Shared.Model

import com.rickclephas.kmp.viewmodel.KMPViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * ViewModel for managing barcode scanning and its state.
 *
 * This ViewModel holds the scanned barcode value and provides functions to update and clear it.
 * It's designed for use in scenarios where barcode scanning is involved, such as in a mobile app or a KMP application.
 */
class BarcodeViewModel : KMPViewModel() {
    private val _barcode = MutableStateFlow<String?>(null)
    val barcode: StateFlow<String?> = _barcode

    fun onBarcodeScanned(value: String) {
        _barcode.value = value
    }

    fun clear() {
        _barcode.value = null
    }
}
