package com.tu.kohalal.ui.theme.Iphone

import Shared // Your KMP framework
import androidx.lifecycle.viewmodel.compose.viewModel

class IOSBarcodeViewModel: ObservableObject {
    private let viewModel = BarcodeViewModel()
    @Published var barcode: String? = nil

    init() {
        viewModel.barcode.watch { [weak self] value in
            self?.barcode = value
        }
    }

    func updateBarcode(_ code: String) {
        viewModel.onBarcodeScanned(value: code)
    }

    func reset() {
        viewModel.clear()
    }
}
