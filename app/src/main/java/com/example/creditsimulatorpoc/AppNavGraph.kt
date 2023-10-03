package com.example.creditsimulatorpoc

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.creditsimulatorpoc.model.Month
import com.example.creditsimulatorpoc.model.PaymentModel
import com.example.creditsimulatorpoc.model.YearWiseStatus
import com.example.creditsimulatorpoc.ui.*
import com.example.creditsimulatorpoc.ui.views.HomeScreen

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun AppNavGraph(
    scaffoldState: ScaffoldState,
    navController: NavHostController = rememberNavController(),
    startDestination: String,
    activity: MainActivity,
    activityone: FragmentActivity
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(AppDestinations.SPLASH) {
            SplashScreenLayout(
                navController = navController
            )
        }
        composable(AppDestinations.LOGIN) {
            LoginLayout(
                navController = navController,
                activity = activityone
            )
        }
        composable(AppDestinations.PINLOGIN) {
            PinLoginScreen(
                navController = navController
            )
        }
        composable(AppDestinations.SIGNUP) {
            signUpScreen(
                navController = navController
            )
        }
        composable(AppDestinations.HOME) {
            HomeScreen(
                navController = navController
            )
        }
        composable(AppDestinations.CreditScreen) {
            CreditScoreScreen(
                navController = navController
            )
        }
        composable(AppDestinations.ACTIVITYSTATUS) {
            ActivityStatusScreen(
                navController = navController
            )
        }
        composable(AppDestinations.EXPANDEDSTATUS) {
            ExpandedCreditList(
                navController = navController,
                creditList = Month(),
                yearWiseStatus = YearWiseStatus(),
                paymentModel = PaymentModel()
            )
        }
        composable(AppDestinations.BiometricScreen) {
            BiometricScreen(
                navController = navController,
                activity = activityone
            )
        }
    }

}