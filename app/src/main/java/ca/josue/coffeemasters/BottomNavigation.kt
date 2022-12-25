package ca.josue.coffeemasters

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import ca.josue.coffeemasters.ui.theme.onPrimary

data class NavPage(var name: String, var icon: ImageVector, var route: String)

object Routes {
    val MENU = NavPage("Home", Icons.Outlined.Menu, "menu")
    val OFFER = NavPage("Offer", Icons.Outlined.Star, "offer")
    val ORDER = NavPage("Offer", Icons.Outlined.ShoppingCart, "order")
    val INFO = NavPage("Profile", Icons.Outlined.Info, "info")

    val pages = listOf(MENU, OFFER, ORDER, INFO)
}

@Preview
@Composable
fun NavBar_Preview() {
    NavBarItem(
        page = Routes.MENU,
        modifier = Modifier.padding(8.dp),
    )
}

@Composable
fun NavBarItem(modifier: Modifier = Modifier, page: NavPage, selected: Boolean = false) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(horizontal = 12.dp)) {
        Image(
            imageVector = page.icon,
            contentDescription = page.name,
            colorFilter = ColorFilter.tint(
                if (selected) Alternative1 else onPrimary
            ),
            modifier = Modifier
                .padding(bottom = 8.dp)
                .size(24.dp)
        )
        Text(page.name,
            fontSize = 12.sp,
            color = if (selected) Alternative1 else onPrimary
        )
    }
}