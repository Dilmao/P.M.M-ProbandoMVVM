package com.iessanalberto.dam2.probandomvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _usuario = MutableLiveData<String>()
    val usuario: LiveData<String> = _usuario

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    fun onUserPasswordChanged (usuario: String, password: String){
        _usuario.value = usuario
        _password.value = password
    }

    fun validarUserPassword(): Boolean{
        return _usuario.equals("admin")&&_password.equals("admin")
    }
}