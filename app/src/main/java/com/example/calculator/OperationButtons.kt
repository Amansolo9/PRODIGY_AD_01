package com.example.calculator

sealed class OperationButtons(val symbol : String) {
    object Add : OperationButtons("+")
    object Subtract : OperationButtons("-")
    object Divide : OperationButtons("/")
    object Multiply : OperationButtons("*")
}
