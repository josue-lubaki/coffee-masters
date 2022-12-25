package ca.josue.coffeemasters

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.josue.coffeemasters.ui.theme.Alternative1
import ca.josue.coffeemasters.ui.theme.Primary
import ca.josue.coffeemasters.ui.theme.onPrimary

data class NavPage(var name: String, var icon: ImageVector, var route: String)

object Routes {
    val MENU = NavPage("Menu", Icons.Outlined.Menu, "menu")
    val OFFERS = NavPage("Offer", Icons.Outlined.Star, "offer")
    val ORDERS = NavPage("Order", Icons.Outlined.ShoppingCart, "order")
    val INFO = NavPage("Profile", Icons.Outlined.Info, "info")

    val pages = listOf(MENU, OFFERS, ORDERS, INFO)
}

@Preview
@Composable
fun NavBar_Preview() {
    NavBarItem(
        page = Routes.MENU,
        modifier = Modifier.padding(8.dp),
    )
}

@Preview(showBackground = true, widthDp = 400)
@Composable
fun NavBar(selectedRoute: String = Routes.MENU.route, onChange: (String) -> Unit = {}) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .background(Primary)
            .padding(bottom = 0.dp)
    ) {
        for (page in Routes.pages) {
            NavBarItem(
                page = page,
                selected = page.route == selectedRoute,
                modifier = Modifier
                    .clickable {
                        onChange(page.route)
                    }
            )
        }
    }
}

@Composable
fun NavBarItem(modifier: Modifier = Modifier, page: NavPage, selected: Boolean = false) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(start = 12.dp, top= 3.dp, end = 12.dp, bottom = 7.dp)
    ) {
        Image(
            imageVector = page.icon,
            contentDescription = page.name,
            colorFilter = ColorFilter.tint(
                if (selected) onPrimary else Alternative1
            ),
            modifier = Modifier
                .padding(bottom = 8.dp)
                .size(24.dp)
        )
        Text(page.name,
            fontSize = 12.sp,
            color = if (selected) onPrimary else Alternative1
        )
    }
}