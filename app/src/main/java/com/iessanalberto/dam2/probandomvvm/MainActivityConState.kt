package com.iessanalberto.dam2.probandomvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.iessanalberto.dam2.probandomvvm.ui.theme.ProbandoMVVMTheme

class MainActivityConState : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProbandoMVVMTheme {
                val loginViewModelConState: LoginViewModelConState = viewModel()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Login(loginViewModelConState)
                }
            }
        }
    }

    @Composable
    fun Login(loginViewViewModelConState: LoginViewModelConState) {

        val loginUiState by loginViewViewModelConState.uiState.collectAsState()

        //val usuario: String by mainViewModel.usuario.observeAsState(initial = "")
        //val password: String by mainViewModel.password.observeAsState(initial = "")

        Column (modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
            OutlinedTextField(value = loginUiState.usuario, onValueChange = {loginViewViewModelConState.onChanged(it,loginUiState.password)}, label = { Text(text = "Introduce usuario")})
            Spacer(modifier = Modifier.width(20.dp))
            OutlinedTextField(value = loginUiState.password, onValueChange = {loginViewViewModelConState.onChanged(loginUiState.usuario,it)}, label = { Text(
                text = "Introduce contraseña"
            )},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { loginViewViewModelConState.onValidar()}) {
                Text(text = "Conectar")
            }
            Text(text = loginUiState.intentos.toString())
        }
    }
}
