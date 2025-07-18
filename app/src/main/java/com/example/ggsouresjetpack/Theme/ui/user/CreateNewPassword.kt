package com.example.ggsouresjetpack.Theme.ui.user

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ggsouresjetpack.Theme.ui.theme.AppTheme

@Composable
fun CreateNewPasswordScreen(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(24.dp)
        .background(color = AppTheme.appColor.backgroundColor)) {
        Text("Create New Password \uD83D\uDD10",
            style = AppTheme.appTypography.largeTitle.copy(fontSize = 56.sp, color = AppTheme.appColor.textBodyColor))
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "Enter your new password. If you forget it, then you have to do forgot password.",
            style = TextStyle())
        Spacer(modifier = Modifier.height(24.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = true, onCheckedChange = {

            })
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Remember me",
                style = AppTheme.appTypography.subTitle)
        }
    }
}
@Preview(showBackground = true, showSystemUi = true, name = "light Theme")
@Composable
fun CreateNewPasswordScreenPreview(){
   AppTheme(isDark = false) {
        CreateNewPasswordScreen()
    }
}
@Preview(showBackground = true, showSystemUi = true, name = "dark Theme")
@Composable
fun CreateNewPasswordScreenPreviewDark(){
    AppTheme(isDark = true) {
        CreateNewPasswordScreen()
    }
}