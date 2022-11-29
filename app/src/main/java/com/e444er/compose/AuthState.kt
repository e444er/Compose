package com.e444er.compose

sealed class AuthState {

    object Authorized : AuthState()

    object NoAuthorized : AuthState()

    object Initial: AuthState()
}
