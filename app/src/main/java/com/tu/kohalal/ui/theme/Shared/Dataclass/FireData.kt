// File: FirebaseRepository.kt

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.tu.kohalal.ui.theme.Shared.Dataclass.LocalBarcodeStorage

class FireData(private val localStorage: LocalBarcodeStorage) {
    private val database = FirebaseDatabase.getInstance().getReference("Halal")

    fun fetchBarcodeList(onComplete: (Map<String, Boolean>) -> Unit) {
        database.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val result = mutableMapOf<String, Boolean>()
                for (child in snapshot.children) {
                    val barcode = child.key ?: continue
                    val isHalal = child.getValue(Boolean::class.java) ?: false
                    result[barcode] = isHalal
                }
                localStorage.saveBarcodes(result)
                onComplete(result)
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
            }
        })
    }

    fun addBarcode(barcode: String, isHalal: Boolean) {
        database.child(barcode).setValue(isHalal).addOnCompleteListener {
            if (it.isSuccessful) {
                localStorage.addBarcode(barcode, isHalal)
            }
        }
    }
}
