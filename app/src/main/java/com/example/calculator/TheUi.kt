package com.example.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.Gray
import com.example.calculator.ui.theme.Orange
import com.example.calculator.ui.theme.Black

@Composable
fun Calculator(
    state: CalculatorState,
    modifier: Modifier = Modifier,
    buttonSpacing : Dp = 10.dp,
    onAction : (ButtonActions) -> Unit
    ) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(10.dp)
            ,
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2 ,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 50.dp),
                textAlign = TextAlign.End,
                fontWeight = FontWeight.Light ,
                fontSize = 100.sp ,
                color = Color.White ,
            )
        // First Row
            Row(
                modifier = Modifier
                    .fillMaxWidth() ,
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalcButtons(
                    symbol = "AC",
                    modifier = Modifier
                        .background(Gray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(ButtonActions.Clear)
                    }
                )
                CalcButtons(
                    symbol = "Del",
                    modifier = Modifier
                        .background(Gray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(ButtonActions.Delete)
                    }
                )
                CalcButtons(
                    symbol = "+",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(ButtonActions.Operations(OperationButtons.Add))
                    }
                )
            }
        // Second Row
            Row(
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalcButtons(
                    symbol = "9",
                    modifier = Modifier
                        .background(Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(ButtonActions.TheNumbers(nums = 9))
                    }
                )
                CalcButtons(
                    symbol = "8",
                    modifier = Modifier
                        .background(Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(ButtonActions.TheNumbers(nums = 8))
                    }
                )
                CalcButtons(
                    symbol = "7",
                    modifier = Modifier
                        .background(Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(ButtonActions.TheNumbers(nums = 7))
                    }
                )
                CalcButtons(
                    symbol = "-",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(ButtonActions.Operations(OperationButtons.Subtract))
                    }
                )
            }
        // Third Row
            Row(
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalcButtons(
                    symbol = "6",
                    modifier = Modifier
                        .background(Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(ButtonActions.TheNumbers(nums = 6))
                    }
                )
                CalcButtons(
                    symbol = "5",
                    modifier = Modifier
                        .background(Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(ButtonActions.TheNumbers(nums = 5))
                    }
                )
                CalcButtons(
                    symbol = "4",
                    modifier = Modifier
                        .background(Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(ButtonActions.TheNumbers(nums = 4))
                    }
                )
                CalcButtons(
                    symbol = "*",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(ButtonActions.Operations(OperationButtons.Multiply))
                    }
                )
            }
        // Forth Row
            Row(
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalcButtons(
                    symbol = "3",
                    modifier = Modifier
                        .background(Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(ButtonActions.TheNumbers(nums = 3))
                    }
                )
                CalcButtons(
                    symbol = "2",
                    modifier = Modifier
                        .background(Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(ButtonActions.TheNumbers(nums = 2))
                    }
                )
                CalcButtons(
                    symbol = "1",
                    modifier = Modifier
                        .background(Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(ButtonActions.TheNumbers(nums = 1))
                    }
                )
                CalcButtons(
                    symbol = "/",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(ButtonActions.Operations(OperationButtons.Divide))
                    }
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalcButtons(
                    symbol = "0",
                    modifier = Modifier
                        .background(Black)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(ButtonActions.TheNumbers(nums = 0))
                    }
                )
                CalcButtons(
                    symbol = ".",
                    modifier = Modifier
                        .background(Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(ButtonActions.Dots)
                    }
                )
                CalcButtons(
                    symbol = "=",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(ButtonActions.Calculation)
                    }
                )
            }

        }
    }
}