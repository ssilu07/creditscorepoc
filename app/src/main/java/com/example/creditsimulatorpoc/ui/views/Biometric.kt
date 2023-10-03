package com.example.creditsimulatorpoc.ui.views


import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG
import androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavHostController
import com.example.creditsimulatorpoc.AppDestinations
import java.net.Authenticator

object Biometric  {

    fun authenticate(
        activity: FragmentActivity,
        title: String,
        subtitle: String,
        description: String,
        negativeText: String,
        onError: (Int, CharSequence) -> Unit,
        onSuccess: (BiometricPrompt.AuthenticationResult) -> Unit,
        onFailed: () -> Unit,
        navController: NavHostController
    ) {
        val executor = ContextCompat.getMainExecutor(activity)
        val biometricPrompt = BiometricPrompt(activity, executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationError(
                    errorCode: Int,
                    errString: CharSequence
                ) {
                    super.onAuthenticationError(errorCode, errString)
                    onError(errorCode, errString)
                }

                override fun onAuthenticationSucceeded(
                    result: BiometricPrompt.AuthenticationResult
                ) {
                    super.onAuthenticationSucceeded(result)
                    onSuccess(result)
                    navController.popBackStack()
                    navController.navigate(AppDestinations.HOME)
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    onFailed()
                }
            })
        val promptInfo: BiometricPrompt.PromptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle(title)
            .setSubtitle(subtitle)
            .setDescription(description)
            .setAllowedAuthenticators(BIOMETRIC_STRONG or DEVICE_CREDENTIAL)
            .build()
        biometricPrompt.authenticate(promptInfo)

    }
}