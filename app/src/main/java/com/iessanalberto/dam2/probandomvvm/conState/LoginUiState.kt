package com.iessanalberto.dam2.probandomvvm.conState

data class LoginUiState(
    // Importante, esto es una data class
    val usuario: String = "",
    val password: String = "",
    val intentos: Int = 0,
    val isConected: Boolean = false
)
