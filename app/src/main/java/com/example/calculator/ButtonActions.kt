package com.example.calculator

sealed class ButtonActions {
    data class TheNumbers(var nums: Int) : ButtonActions()
    data class Operations(val ops: OperationButtons) : ButtonActions()
    object Clear : ButtonActions()
    object Delete : ButtonActions()
    object Dots : ButtonActions()
    object Calculation : ButtonActions()
}
