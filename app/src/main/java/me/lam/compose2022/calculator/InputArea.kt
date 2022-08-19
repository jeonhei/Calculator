package me.lam.compose2022.calculator

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import me.lam.compose2022.calculator.ui.theme.CalculatorTheme

/**
 * <pre>
 *     author : Lam
 *     e-mail : yunhay.lam@gmail.com
 *     time   : 2022/08/17
 *     desc   : 输入区域Compose
 *     version: 1.0
 * </pre>
 */
@Preview
@Composable
fun InputArea(
    modifier: Modifier = Modifier,
    dec: (String) -> Unit = {},
    operator: (String) -> Unit = {},
    others: (String) -> Unit = {}
) {
    Row(modifier = modifier
        .background(CalculatorTheme.colors.inputAreaBg)
        .navigationBarsPadding()
    ) {

        BoxWithConstraints(
            modifier = Modifier

        ) {
            //是否竖屏
            val isPortrait = maxWidth < 600.dp
            Log.i("Cal", "maxWidth:${maxWidth}")
            val rootPadding = 16.dp

            val textStyle = TextStyle(
                color = CalculatorTheme.colors.inputText,
                fontSize = if (isPortrait) 45.sp else 25.sp,
                fontWeight = FontWeight.Medium
            )

            ConstraintLayout(
                constraintSet = constraintsSet(isPortrait, maxWidth, maxHeight),
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(rootPadding)
            ) {
                TextButton(
                    onClick = { operator("+") },
                    modifier = Modifier
                        .clip(CircleShape)
                        .layoutId("btnPlus")
                        .background(CalculatorTheme.colors.operatorBg)
                ) {
                    Text(text = "+", style = textStyle)
                }

                TextButton(
                    onClick = { operator("-") },
                    modifier = Modifier
                        .clip(CircleShape)
                        .layoutId("btnMinus")
                        .background(CalculatorTheme.colors.operatorBg)
                ) {
                    Text(text = "-", style = textStyle)
                }

                TextButton(
                    onClick = { operator("×") },
                    modifier = Modifier
                        .layoutId("btnMultiply")
                        .clip(CircleShape)
                        .background(CalculatorTheme.colors.operatorBg)
                ) {
                    Text(text = "×", style = textStyle)
                }

                TextButton(
                    onClick = { operator("÷") },
                    modifier = Modifier
                        .clip(CircleShape)
                        .layoutId("btnDivide")
                        .background(CalculatorTheme.colors.operatorBg)
                ) {
                    Text(text = "÷", style = textStyle)
                }

                TextButton(
                    onClick = { dec("7") },
                    modifier = Modifier
                        .clip(CircleShape)
                        .layoutId("btn7")
                        .background(CalculatorTheme.colors.decBg)
                ) {
                    Text(text = "7", style = textStyle)
                }

                TextButton(
                    onClick = { dec("4") },
                    modifier = Modifier
                        .clip(CircleShape)
                        .layoutId("btn4")
                        .background(CalculatorTheme.colors.decBg)
                ) {
                    Text(text = "4", style = textStyle)
                }

                TextButton(
                    onClick = { dec("1") },
                    modifier = Modifier
                        .clip(CircleShape)
                        .layoutId("btn1")
                        .background(CalculatorTheme.colors.decBg)
                ) {
                    Text(text = "1", style = textStyle)
                }

                TextButton(
                    onClick = { dec("0") },
                    modifier = Modifier
                        .clip(CircleShape)
                        .layoutId("btn0")
                        .background(CalculatorTheme.colors.decBg)
                ) {
                    Text(text = "0", style = textStyle)
                }

                TextButton(
                    onClick = { dec("8") },
                    modifier = Modifier
                        .clip(CircleShape)
                        .layoutId("btn8")
                        .background(CalculatorTheme.colors.decBg)
                ) {
                    Text(text = "8", style = textStyle)
                }

                TextButton(
                    onClick = { dec("5") },
                    modifier = Modifier
                        .clip(CircleShape)
                        .layoutId("btn5")
                        .background(CalculatorTheme.colors.decBg)
                ) {
                    Text(text = "5", style = textStyle)
                }

                TextButton(
                    onClick = { dec("2") },
                    modifier = Modifier
                        .clip(CircleShape)
                        .layoutId("btn2")
                        .background(CalculatorTheme.colors.decBg)
                ) {
                    Text(text = "2", style = textStyle)
                }

                TextButton(
                    onClick = { dec(".") },
                    modifier = Modifier
                        .clip(CircleShape)
                        .layoutId("btnDot")
                        .background(CalculatorTheme.colors.decBg)
                ) {
                    Text(text = ".", style = textStyle)
                }

                TextButton(
                    onClick = { dec("9") },
                    modifier = Modifier
                        .clip(CircleShape)
                        .layoutId("btn9")
                        .background(CalculatorTheme.colors.decBg)
                ) {
                    Text(text = "9", style = textStyle)
                }

                TextButton(
                    onClick = { dec("6") },
                    modifier = Modifier
                        .clip(CircleShape)
                        .layoutId("btn6")
                        .background(CalculatorTheme.colors.decBg)
                ) {
                    Text(text = "6", style = textStyle)
                }

                TextButton(
                    onClick = { dec("3") },
                    modifier = Modifier
                        .clip(CircleShape)
                        .layoutId("btn3")
                        .background(CalculatorTheme.colors.decBg)
                ) {
                    Text(text = "3", style = textStyle)
                }

                TextButton(
                    onClick = { others("=") },
                    modifier = Modifier
                        .clip(CircleShape)
                        .layoutId("btnCal")
                        .background(CalculatorTheme.colors.calBg)
                ) {
                    Text(
                        modifier = Modifier
                            .background(Color.Transparent)
                            .padding(0.dp),
                        text = "=",
                        color = CalculatorTheme.colors.inputText,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = if (isPortrait) 65.sp else 30.sp
                    )
                }

                TextButton(
                    onClick = { others("<") },
                    modifier = Modifier
                        .clip(CircleShape)
                        .layoutId("btnDelete")
                        .background(CalculatorTheme.colors.deleteBg)
                ) {
                    Text(
                        modifier = Modifier.background(Color.Transparent),
                        text = "<", style = textStyle
                    )
                }

                TextButton(
                    onClick = { others("AC") },
                    modifier = Modifier
                        .clip(CircleShape)
                        .layoutId("btnAC")
                        .background(CalculatorTheme.colors.acBg)
                ) {
                    Text(
                        modifier = Modifier
                            .background(Color.Transparent),
                        text = "AC",
                        color = CalculatorTheme.colors.inputText,
                        fontSize = if (isPortrait) 38.sp else 25.sp
                    )
                }
            }
        }

    }
}

private fun constraintsSet(isPortrait: Boolean = true, maxWidth: Dp, maxHeight: Dp): ConstraintSet {
    return ConstraintSet {
        val btn0 = createRefFor("btn0")
        val btn1 = createRefFor("btn1")
        val btn2 = createRefFor("btn2")
        val btn3 = createRefFor("btn3")
        val btn4 = createRefFor("btn4")
        val btn5 = createRefFor("btn5")
        val btn6 = createRefFor("btn6")
        val btn7 = createRefFor("btn7")
        val btn8 = createRefFor("btn8")
        val btn9 = createRefFor("btn9")
        val btnDot = createRefFor("btnDot")
        val btnPlus = createRefFor("btnPlus")
        val btnMinus = createRefFor("btnMinus")
        val btnMultiply = createRefFor("btnMultiply")
        val btnDivide = createRefFor("btnDivide")
        val btnCal = createRefFor("btnCal")
        val btnDelete = createRefFor("btnDelete")
        val btnAC = createRefFor("btnAC")

        val dividerSpacerSize = 8.dp
        val rootPadding = 16.dp
        val startPosition = if (isPortrait) {
            0.dp
        } else {
            maxWidth / 3
        }
        val buttonWidth = if (isPortrait) {
            (maxWidth - rootPadding * 2 - dividerSpacerSize * 3) / 4
        } else {
            (maxWidth - rootPadding * 2 - dividerSpacerSize * 4) / 5
        }
        val buttonHeight = if (isPortrait) {
            (maxHeight - rootPadding * 2 - dividerSpacerSize * 4) / 5
        } else {
            (maxHeight - rootPadding * 2 - dividerSpacerSize * 3) / 4
        }
        val buttonWidthDim = Dimension.value(buttonWidth)
        val buttonHeightDim = Dimension.value(buttonHeight)

        if (isPortrait) {
            createHorizontalChain(
                btnPlus,
                btnMinus,
                btnMultiply,
                btnDivide,
                chainStyle = ChainStyle.SpreadInside
            )
            createVerticalChain(
                btnPlus,
                btn7,
                btn4,
                btn1,
                btn0,
                chainStyle = ChainStyle.SpreadInside
            )

            // "+"
            constrain(btnPlus) {
                top.linkTo(parent.top)
                bottom.linkTo(btn7.top)
                start.linkTo(parent.start)
                end.linkTo(btnMinus.start)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "-"
            constrain(btnMinus) {
                top.linkTo(btnPlus.top)
                bottom.linkTo(btnPlus.bottom)
                start.linkTo(btnPlus.end)
                end.linkTo(btnMultiply.start)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "x"
            constrain(btnMultiply) {
                top.linkTo(btnPlus.top)
                bottom.linkTo(btnPlus.bottom)
                start.linkTo(btnMinus.end)
                end.linkTo(btnMultiply.start)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "÷"
            constrain(btnDivide) {
                top.linkTo(btnPlus.top)
                bottom.linkTo(btnPlus.bottom)
                start.linkTo(btnMultiply.end)
                end.linkTo(parent.end)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "7"
            constrain(btn7) {
                top.linkTo(btnPlus.bottom)
                bottom.linkTo(btn4.top)
                start.linkTo(btnPlus.start)
                end.linkTo(btnPlus.end)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "4"
            constrain(btn4) {
                top.linkTo(btn7.bottom)
                bottom.linkTo(btn1.top)
                start.linkTo(btnPlus.start)
                end.linkTo(btnPlus.end)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "1"
            constrain(btn1) {
                top.linkTo(btn7.bottom)
                bottom.linkTo(btn0.top)
                start.linkTo(btnPlus.start)
                end.linkTo(btnPlus.end)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "0"
            constrain(btn0) {
                top.linkTo(btn1.bottom)
                bottom.linkTo(parent.bottom)
                start.linkTo(btnPlus.start)
                end.linkTo(btnPlus.end)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "8"
            constrain(btn8) {
                top.linkTo(btn7.top)
                bottom.linkTo(btn7.bottom)
                start.linkTo(btnMinus.start)
                end.linkTo(btnMinus.end)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "5"
            constrain(btn5) {
                top.linkTo(btn4.top)
                bottom.linkTo(btn4.bottom)
                start.linkTo(btnMinus.start)
                end.linkTo(btnMinus.end)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "2"
            constrain(btn2) {
                top.linkTo(btn1.top)
                bottom.linkTo(btn1.bottom)
                start.linkTo(btnMinus.start)
                end.linkTo(btnMinus.end)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "."
            constrain(btnDot) {
                top.linkTo(btn0.top)
                bottom.linkTo(btn0.bottom)
                start.linkTo(btnMinus.start)
                end.linkTo(btnMinus.end)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "9"
            constrain(btn9) {
                top.linkTo(btn8.top)
                bottom.linkTo(btn8.bottom)
                start.linkTo(btnMultiply.start)
                end.linkTo(btnMultiply.end)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "6"
            constrain(btn6) {
                top.linkTo(btn9.bottom)
                bottom.linkTo(btn3.top)
                start.linkTo(btnMultiply.start)
                end.linkTo(btnMultiply.end)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "3"
            constrain(btn3) {
                top.linkTo(btn2.top)
                bottom.linkTo(btn2.bottom)
                start.linkTo(btnMultiply.start)
                end.linkTo(btnMultiply.end)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "="
            constrain(btnCal) {
                top.linkTo(btn3.top)
                bottom.linkTo(btnDot.bottom)
                start.linkTo(btnDivide.start)
                end.linkTo(btnDivide.end)
                width = buttonWidthDim
                height = Dimension.value(buttonHeight * 2 + dividerSpacerSize)
            }

            // "<"
            constrain(btnDelete) {
                top.linkTo(btnDot.top)
                bottom.linkTo(btnDot.bottom)
                start.linkTo(btn3.start)
                end.linkTo(btn3.end)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "AC"
            constrain(btnAC) {
                top.linkTo(btn9.top)
                bottom.linkTo(btn6.bottom)
                start.linkTo(btnDivide.start)
                end.linkTo(btnDivide.end)
                width = buttonWidthDim
                height = Dimension.value(buttonHeight * 2 + dividerSpacerSize)
            }
        } else {
            createHorizontalChain(
                btn7,
                btn8,
                btn9,
                btnPlus,
                btnMinus,
                chainStyle = ChainStyle.Spread
            )
            createVerticalChain(btn7, btn4, btn1, btn0, chainStyle = ChainStyle.SpreadInside)

            // "7"
            constrain(btn7) {
                top.linkTo(parent.top)
                bottom.linkTo(btn4.top)
                start.linkTo(parent.start)
                end.linkTo(btn8.start)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "4"
            constrain(btn4) {
                top.linkTo(btn7.bottom)
                bottom.linkTo(btn1.top)
                start.linkTo(btn7.start)
                end.linkTo(btn7.end)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "1"
            constrain(btn1) {
                top.linkTo(btn7.bottom)
                bottom.linkTo(btn0.top)
                start.linkTo(btn7.start)
                end.linkTo(btn7.end)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "0"
            constrain(btn0) {
                top.linkTo(btn1.bottom)
                bottom.linkTo(parent.bottom)
                start.linkTo(btn7.start)
                end.linkTo(btn7.end)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "8"
            constrain(btn8) {
                top.linkTo(btn7.top)
                bottom.linkTo(btn7.bottom)
                start.linkTo(btn7.end)
                end.linkTo(btn9.start)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "5"
            constrain(btn5) {
                top.linkTo(btn4.top)
                bottom.linkTo(btn4.bottom)
                start.linkTo(btn4.end)
                end.linkTo(btn6.start)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "2"
            constrain(btn2) {
                top.linkTo(btn1.top)
                bottom.linkTo(btn1.bottom)
                start.linkTo(btn1.end)
                end.linkTo(btn3.start)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "."
            constrain(btnDot) {
                top.linkTo(btn0.top)
                bottom.linkTo(btn0.bottom)
                start.linkTo(btn0.end)
                end.linkTo(btnDelete.start)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "9"
            constrain(btn9) {
                top.linkTo(btn8.top)
                bottom.linkTo(btn8.bottom)
                start.linkTo(btn8.end)
                end.linkTo(btnPlus.start)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "6"
            constrain(btn6) {
                top.linkTo(btn4.top)
                bottom.linkTo(btn4.bottom)
                start.linkTo(btn9.start)
                end.linkTo(btn9.end)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "3"
            constrain(btn3) {
                top.linkTo(btn1.top)
                bottom.linkTo(btn1.bottom)
                start.linkTo(btn9.start)
                end.linkTo(btn9.end)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "+"
            constrain(btnPlus) {
                top.linkTo(parent.top)
                bottom.linkTo(btn7.bottom)
                start.linkTo(btn9.end)
                end.linkTo(btnMinus.start)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "-"
            constrain(btnMinus) {
                top.linkTo(btn7.top)
                bottom.linkTo(btn7.bottom)
                start.linkTo(btnPlus.end)
                end.linkTo(parent.end)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "x"
            constrain(btnMultiply) {
                top.linkTo(btn4.top)
                bottom.linkTo(btn4.bottom)
                start.linkTo(btnPlus.start)
                end.linkTo(btnPlus.end)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "÷"
            constrain(btnDivide) {
                top.linkTo(btn4.top)
                bottom.linkTo(btn4.bottom)
                start.linkTo(btnMinus.start)
                end.linkTo(btnMinus.end)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "="
            constrain(btnCal) {
                top.linkTo(btn0.top)
                bottom.linkTo(btn0.bottom)
                start.linkTo(btnPlus.start)
                end.linkTo(btnMinus.end)
                width = Dimension.fillToConstraints
                height = buttonHeightDim
            }

            // "<"
            constrain(btnDelete) {
                top.linkTo(btn0.top)
                bottom.linkTo(btn0.bottom)
                start.linkTo(btn3.start)
                end.linkTo(btn3.end)
                width = buttonWidthDim
                height = buttonHeightDim
            }

            // "AC"
            constrain(btnAC) {
                top.linkTo(btn1.top)
                bottom.linkTo(btn1.bottom)
                start.linkTo(btnPlus.start)
                end.linkTo(btnMinus.end)
                width = Dimension.fillToConstraints
                height = buttonHeightDim
            }
        }
    }
}