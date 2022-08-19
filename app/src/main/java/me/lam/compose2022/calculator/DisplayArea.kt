package me.lam.compose2022.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.lam.compose2022.calculator.ui.theme.CalculatorTheme

/**
 * <pre>
 *     author : Lam
 *     e-mail : yunhay.lam@gmail.com
 *     time   : 2022/08/17
 *     desc   : 显示区域Compose
 *     version: 1.0
 * </pre>
 */
@Composable
fun DisplayArea(input: String, modifier: Modifier = Modifier) {
    Surface(modifier = modifier
        .fillMaxSize()
        .background(color = CalculatorTheme.colors.displayAreaBg)
        .statusBarsPadding()
        .windowInsetsPadding(
            WindowInsets
                .navigationBars
                .only(WindowInsetsSides.Horizontal + WindowInsetsSides.Top)
        )) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = CalculatorTheme.colors.displayAreaBg),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = input,
                fontWeight = FontWeight.Bold,
                fontSize = 50.sp,
                color = CalculatorTheme.colors.displayText,
            )
        }
    }
}
