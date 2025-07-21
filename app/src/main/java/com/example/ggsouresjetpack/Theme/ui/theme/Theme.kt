package com.example.ggsouresjetpack.Theme.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ggsouresjetpack.CompositionLocal.ui.theme.Typography
import com.example.ggsouresjetpack.Theme.ui.theme.Typography

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)
data class AppColorWaring(
    val waring: Color = Color.Unspecified,
    val onWaring: Color = Color.Unspecified
)
val LocalAppColorWaring = staticCompositionLocalOf {
    AppColorWaring()
}
private  val customTypography = Typography(
    bodySmall = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily.SansSerif
    )
)

@Composable
fun GGSouresJetpackTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val appColorWaring = if(darkTheme){
        AppColorWaring(waring = Color.Magenta, onWaring = Color.White)
    }else{
        AppColorWaring(waring = Color.Blue, onWaring = Color.Yellow)
    }
    CompositionLocalProvider(LocalAppColorWaring provides appColorWaring) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = customTypography,
            content = content
        )
    }

}
//object GGSouresJetpackTheme{
//    val appColorWaring: AppColorWaring
//    @Composable
//    get() = LocalAppColorWaring.current
//}