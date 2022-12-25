package ca.josue.coffeemasters.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.josue.coffeemasters.R
import ca.josue.coffeemasters.ui.theme.Alternative1
import ca.josue.coffeemasters.ui.theme.Alternative2

@Composable
private fun OfferPage_Preview() {
    Offer(
        title = "Café de la semaine",
        description = "Café de la semaine",
    )
}

@Preview(showBackground = true)
@Composable
fun OfferPage() {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Offer(title = "Early Coffee", description = "10% off. Offer valid from 6am to 9am.")
        Offer(title = "Welcome Gift", description = "25% off on your first order.")
        Offer(title = "Welcome Gift", description = "25% off on your first order.")
        Offer(title = "Early Coffee", description = "10% off. Offer valid from 6am to 9am.")
    }
}

@Composable
fun Offer(title: String, description: String) {
    Box(
        modifier = Modifier.padding(16.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.background_pattern),
            contentScale = ContentScale.FillWidth,
            contentDescription = "Background pattern",
            modifier = Modifier.matchParentSize()
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(16.dp)
                    .background(Alternative1)
                    .padding(16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .padding(16.dp)
                    .background(Alternative2)
                    .padding(16.dp)
            )
        }
    }
}