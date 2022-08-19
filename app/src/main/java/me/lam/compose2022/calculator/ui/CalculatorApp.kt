package me.lam.compose2022.calculator.ui

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import me.lam.compose2022.calculator.DisplayArea
import me.lam.compose2022.calculator.InputArea
import me.lam.compose2022.calculator.ui.theme.CalculatorTheme
import java.math.BigDecimal

/**
 * <pre>
 *     author : Lam
 *     e-mail : yunhay.lam@gmail.com
 *     time   : 2022/08/19
 *     desc   :
 *     version: 1.0
 * </pre>
 */
@Composable
fun CalculatorApp() {
    CalculatorTheme {
        val systemUiController = rememberSystemUiController()
        val darkIcons = MaterialTheme.colors.isLight
        SideEffect {
            systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = darkIcons)
        }
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            ParentLayout()
        }
    }
}

enum class RecentPress {
    Operator, Dec, AC, Delete, Cal, None
}

@Composable
fun ParentLayout() {
    //当前录入或最新计算结果
    var currentInput by rememberSaveable { mutableStateOf("") }
    //最后计算结果
    var recentResult by rememberSaveable { mutableStateOf("") }
    //当前的操作符
    var operator by rememberSaveable { mutableStateOf("") }
    //最后的点击按钮
    var recentPress by rememberSaveable { mutableStateOf(RecentPress.None) }

    BoxWithConstraints {
        //是否竖屏
        val isPortrait = maxWidth < 600.dp

        Column(modifier = Modifier.fillMaxSize()) {
            DisplayArea(currentInput, modifier = Modifier.weight(1f))
            InputArea(
                modifier = Modifier.weight(if(isPortrait) 2f else 2f),
                dec = {
                    if (recentPress == RecentPress.Operator) {
                        currentInput = it
                    } else {
                        currentInput += it
                    }
                    recentPress = RecentPress.Dec
                }, operator = { op ->
                    if (currentInput.isNotEmpty()) {
                        //如果之前已经输入过或者有计算结果，直接进行计算
                        if (recentPress == RecentPress.Dec && recentResult.isNotEmpty()) {
                            calResult(
                                currentInput = currentInput,
                                recentResult = recentResult,
                                operator = operator
                            ) { result ->
                                currentInput = result
                            }
                        }
                        operator = op
                        recentResult = currentInput
                        recentPress = RecentPress.Operator
                    }
                }, others = {
                    when (it) {
                        "<" -> {
                            currentInput = currentInput.dropLast(1)
                            recentPress = RecentPress.Delete
                        }
                        "AC" -> {
                            currentInput = ""
                            recentResult = ""
                            operator = ""
                            recentPress = RecentPress.AC
                        }
                        "=" -> {
                            if (recentPress == RecentPress.Dec && recentResult.isNotEmpty() && currentInput.isNotEmpty() && operator.isNotEmpty()) {
                                calResult(
                                    currentInput = currentInput,
                                    recentResult = recentResult,
                                    operator = operator
                                ) { result ->
                                    currentInput = result
                                    recentResult = currentInput
                                    recentPress = RecentPress.Cal
                                }
                            }
                        }
                    }
                })
        }
    }
}

/**
 * 计算结果
 */
private fun calResult(currentInput: String, recentResult: String, operator: String, result: (String) -> Unit) {
    if(recentResult.isNotEmpty() && currentInput.isNotEmpty() && operator.isNotEmpty()) {
        when(operator) {
            "+" -> {
                result((recentResult.toBigDecimal().plus(currentInput.toBigDecimal())).toPlainString())
            }
            "-" -> {
                result((recentResult.toBigDecimal().minus(currentInput.toBigDecimal())).toPlainString())
            }
            "×" -> {
                result((recentResult.toBigDecimal().multiply(currentInput.toBigDecimal())).toPlainString())
            }
            "÷" -> {
                if(currentInput.toBigDecimal() != BigDecimal.ZERO) {//除数不能为0
                    result(
                        (recentResult.toBigDecimal().divide(currentInput.toBigDecimal(), 6, BigDecimal.ROUND_DOWN).stripTrailingZeros().toPlainString())
                    )
                }
            }
        }
    } else {
        result("")
    }
}