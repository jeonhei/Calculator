package me.lam.compose2022.calculator.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200


)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200


)

@Composable
fun CalculatorTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val themeColors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val calColors = if(darkTheme) {
        CalDarkColorPalette
    } else {
        CalLightColorPalette
    }

    ProvideCalColors(colors = calColors) {
        MaterialTheme(
            colors = themeColors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

object CalculatorTheme {
    val colors: CalculatorColors
    @Composable
    get() = LocalCalColors.current
}

@Composable
fun ProvideCalColors(
    colors: CalculatorColors,
    content: @Composable () -> Unit
) {
    val colorPalette = remember {
        colors
    }

    CompositionLocalProvider(
        LocalCalColors provides colorPalette,
        content = content)
}

private val LocalCalColors = staticCompositionLocalOf<CalculatorColors> {
    error("No ColorPalette provided")
}

private val CalLightColorPalette = CalculatorColors(
    displayAreaBg = DisplayAreaBgLight,
    displayText = DisplayTextLight,
    inputAreaBg = InputAreaBgLight,
    inputText = InputTextLight,
    operatorBg = OperatorBgLight,
    decBg = DecBgLight,
    deleteBg = DeleteBgLight,
    acBg = ACBgLight,
    calBg = CalBgLight
)

private val CalDarkColorPalette = CalculatorColors(
    displayAreaBg = DisplayAreaBgDark,
    displayText = DisplayTextDark,
    inputAreaBg = InputAreaBgDark,
    inputText = InputTextDark,
    operatorBg = OperatorBgDark,
    decBg = DecBgDark,
    deleteBg = DeleteBgDark,
    acBg = ACBgDark,
    calBg = CalBgDark
)

/**
 * 自定义颜色
 */
@Stable
class CalculatorColors(
    val displayAreaBg: Color,
    val displayText: Color,
    val inputAreaBg: Color,
    val inputText: Color,
    val operatorBg: Color,
    val decBg: Color,
    val deleteBg: Color,
    val acBg: Color,
    val calBg: Color
)