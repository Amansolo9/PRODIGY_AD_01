package com.example.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TheViewModel : ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: ButtonActions) {
        when(action) {
            is ButtonActions.TheNumbers -> enterNumber(action.nums)
            is ButtonActions.Operations -> enterOperaton(action.ops)
            is ButtonActions.Dots -> enterDot()
            is ButtonActions.Clear -> state = CalculatorState()
            is ButtonActions.Calculation -> calculateNums()
            is ButtonActions.Delete -> deleteNums()
        }
    }

    private fun deleteNums() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )
            state.operation != null -> state = state.copy(
                operation = null
            )
            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    private fun calculateNums() {
        val num1 = state.number1.toDouble()
        val num2 = state.number2.toDouble()
        val result = when(state.operation){
            is OperationButtons.Add -> num1 + num2
            is OperationButtons.Subtract -> num1 - num2
            is OperationButtons.Multiply -> num1 * num2
            is OperationButtons.Divide -> num1 / num2
            null -> return
        }
        state = state.copy(
            number1 = result.toString().take(10),
            number2 = "",
            operation = null
        )
    }

    private fun enterDot() {
        if(
            state.operation == null &&
            !state.number1.contains(".") &&
            state.number1.isNotBlank()
            ) {
            state = state.copy(number1 = state.number1 + ".")
            return
        }
        if(
            state.number2.isNotBlank() &&
            state.number2.contains(".")
        ) {
            state = state.copy(number2 = state.number2 + ".")
        }
    }

    private fun enterOperaton(operation: OperationButtons) {
        if(state.number1.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun enterNumber(num: Int) {
        if(state.operation == null) {
            if(state.number1.length > 10) {
                return
            }
            state = state.copy(number1 = state.number1 + num)
        }
        else if(state.operation != null){
            if(state.number2.length > 10) {
                return
            }
            state= state.copy(number2 = state.number2 + num)
        }
    }
}