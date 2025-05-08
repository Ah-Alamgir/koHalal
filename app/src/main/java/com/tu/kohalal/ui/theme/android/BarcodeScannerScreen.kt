package com.tu.kohalal.ui.theme.android

import android.util.Log
import android.view.ViewGroup
import androidx.annotation.OptIn
import androidx.camera.core.CameraSelector
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage
import com.tu.kohalal.ui.theme.Shared.Model.BarcodeViewModel

@Composable
fun BarcodeScannerScreen(viewModel: BarcodeViewModel = remember { BarcodeViewModel() }) {
    val barcode by viewModel.barcode.collectAsState()

    if (barcode == null) {
        BarcodeScannerScreen(
            onBarcodeScanned = { result ->
                viewModel.onBarcodeScanned(result)
            }
        )
    } else {
        Column(Modifier.padding(16.dp)) {
            Text("Scanned: $barcode")
            Button(onClick = { viewModel.clear() }) {
                Text("Scan Again")
            }
        }
    }
}
