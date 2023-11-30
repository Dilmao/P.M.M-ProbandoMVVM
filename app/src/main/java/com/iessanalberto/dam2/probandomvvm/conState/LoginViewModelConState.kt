package com.iessanalberto.dam2.probandomvvm.conState

import androidx.lifecycle.ViewModel
import com.iessanalberto.dam2.probandomvvm.conState.LoginUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModelConState: ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun onChanged(usuario: String, password: String){
        _uiState.update {
            currentState -> currentState.copy(usuario = usuario, password = password)
        }
    }

    fun onValidar() {
        if (_uiState.value.usuario.equals("admin") && _uiState.value.password.equals("admin"))

            _uiState.update { currentState ->
                currentState.copy(isConected = true)
            }
        else {
            _uiState.update { currentState ->
                currentState.copy(intentos = currentState.intentos.inc())
            }
        }

        }

    }
