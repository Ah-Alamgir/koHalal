package com.tu.kohalal.ui.theme.Shared.Scene

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tu.kohalal.R

@Composable
fun HomeScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.weight(1f)) {
            // Placeholder for Barcode Scanner View
            Text("[Barcode Scanner Here]", modifier = Modifier.align(Alignment.Center))
        }
        Column(modifier = Modifier.weight(2f)) {
            FeatureCard("Mosque", R.mipmap.mosque) {}
            FeatureCard("Grocery", R.mipmap.basket) {}
            FeatureCard("Add halal/haram product", R.mipmap.working) {
                navController.navigate("scan_ingredients")
            }
        }
    }
}

@Composable
fun FeatureCard(text: String, imageRes: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(16.dp)) {
            Image(painter = painterResource(id = imageRes), contentDescription = text, modifier = Modifier.size(48.dp))
            Spacer(modifier = Modifier.width(16.dp))
            Text(text, style = MaterialTheme.typography.titleMedium)
        }
    }
}
