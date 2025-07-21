package com.example.ggsouresjetpack.Theme.ui.home

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ggsouresjetpack.Theme.ui.theme.GGSouresJetpackTheme
import com.example.ggsouresjetpack.Theme.ui.theme.LocalAppColorWaring

@Composable
fun HomeScreen(){
    Column {
        CartItem(title = "First card")
        Spacer(modifier = Modifier.height(12.dp))
        Surface(color = Color.Black, contentColor = MaterialTheme.colorScheme.onError) {
            CartItem(title = "Surface card")
        }
        Spacer(modifier = Modifier.height(12.dp))
        Surface(color = LocalAppColorWaring.current.waring, contentColor = LocalAppColorWaring.current.onWaring) {
            Text("Waring")
        }
    }
}
@Composable
fun CartItem(title: String){
    Row(){
        Icon( Icons.Default.Add,contentDescription = "")
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = title, style =  MaterialTheme.typography.bodySmall)
    }
}
@Preview(name = "preview", showSystemUi = true, showBackground = true)
@Composable
fun HomeScreenPreview(){
    GGSouresJetpackTheme {
        HomeScreen()
    }
}