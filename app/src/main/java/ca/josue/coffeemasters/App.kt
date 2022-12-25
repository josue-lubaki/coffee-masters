package ca.josue.coffeemasters

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import ca.josue.coffeemasters.ui.theme.CoffeeMastersTheme

@Preview
@Composable
fun App_Preview() {
    CoffeeMastersTheme {
        App()
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun App() {
    Scaffold(
        topBar = {
            TopAppBar {
                AppTitle()
            }
        },
        bottomBar = {
            Text("I'am the bottom bar")
        }
    ){
        OfferPage()
    }
}

@Composable
fun AppTitle() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo"
        )
    }
}