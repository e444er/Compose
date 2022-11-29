package com.e444er.compose.presentation.main

sealed class AuthState {

    object Authorized : AuthState()

    object NoAuthorized : AuthState()

    object Initial: AuthState()
}
