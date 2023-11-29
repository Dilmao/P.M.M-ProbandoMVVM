package com.iessanalberto.dam2.probandomvvm

data class LoginUiState(
    val usuario: String = "",
    val password: String = "",
    val intentos: Int = 0,
    val isConected: Boolean = false
)
