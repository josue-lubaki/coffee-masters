package ca.josue.coffeemasters

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ca.josue.coffeemasters.pages.InfoPage
import ca.josue.coffeemasters.pages.MenuPage
import ca.josue.coffeemasters.pages.OfferPage
import ca.josue.coffeemasters.pages.OrderPage


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun App(dataManager : DataManager) {
    val selectedRoute = remember {
        mutableStateOf(Routes.MENU.route)
    }

    Scaffold(
        topBar = {
            TopAppBar {
                AppTitle()
            }
        },
        content = {
            Box(modifier = Modifier.padding(bottom = 56.dp)) {
                when(selectedRoute.value) {
                    Routes.OFFERS.route -> OfferPage()
                    Routes.MENU.route -> MenuPage(dataManager)
                    Routes.ORDERS.route -> OrderPage(dataManager)
                    Routes.INFO.route -> InfoPage()
                }
            }
        },
        bottomBar = {
            BottomAppBar {
                NavBar(
                    selectedRoute = selectedRoute.value,
                    onChange = { newRoute ->
                        selectedRoute.value = newRoute
                    }
                )
            }
        }
    )
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