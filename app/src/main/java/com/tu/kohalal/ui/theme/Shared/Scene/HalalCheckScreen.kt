package com.tu.kohalal.ui.theme.Shared.Scene

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tu.kohalal.ui.theme.android.BarcodeScannerScreen

@Composable
fun HalalCheckScreen() {
    var scannedCode by remember { mutableStateOf<String?>(null) }

    if (scannedCode == null) {
        BarcodeScannerScreen { barcode ->
            scannedCode = barcode
            // TODO: trigger halal lookup with barcode
        }
    } else {
        Column(Modifier.padding(16.dp)) {
            Text("Scanned Barcode: $scannedCode")
            // TODO: Show results or continue workflow
        }
    }
}
