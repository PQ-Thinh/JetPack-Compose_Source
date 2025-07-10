package com.example.ggsouresjetpack.Nagvigation.ui.checkout


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

fun createCheckoutScreenRoute(cartId: String,customerId: String): String{
    return "checkout/$cartId/$customerId"
}

@Composable
fun CheckoutScreen(
    cartId: String, customerId: String,
    placeOrderAction: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Text("Processing cart with id: $cartId \nFor customer with id: $customerId")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            placeOrderAction()
        }) {
            Text(text = "Place order")
        }
    }
}