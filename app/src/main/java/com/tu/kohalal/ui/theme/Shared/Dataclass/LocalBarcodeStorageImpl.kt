package com.tu.kohalal.ui.theme.Shared.Dataclass

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

interface LocalBarcodeStorage {
    fun saveBarcodes(barcodes: Map<String, Boolean>)
    fun addBarcode(barcode: String, isHalal: Boolean)
    fun getBarcodes(): Map<String, Boolean>
}

@Serializable
data class BarcodeData(val barcodes: Map<String, Boolean>)

class JsonBarcodeStorage(private val file: File) : LocalBarcodeStorage {

    private val json = Json { prettyPrint = true; ignoreUnknownKeys = true }

    override fun saveBarcodes(barcodes: Map<String, Boolean>) {
        CoroutineScope(Dispatchers.IO).launch {
            val data = BarcodeData(barcodes)
            file.writeText(json.encodeToString(data))
        }
    }

    override fun addBarcode(barcode: String, isHalal: Boolean) {
        CoroutineScope(Dispatchers.IO).launch {
            val current = getBarcodes().toMutableMap()
            current[barcode] = isHalal
            saveBarcodes(current)
        }
    }

    override fun getBarcodes(): Map<String, Boolean> {
        return try {
            if (file.exists()) {
                val text = file.readText()
                json.decodeFromString<BarcodeData>(text).barcodes
            } else emptyMap()
        } catch (e: Exception) {
            emptyMap()
        }
    }
}
