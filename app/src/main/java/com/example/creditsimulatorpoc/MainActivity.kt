package com.example.creditsimulatorpoc

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.creditsimulatorpoc.ui.theme.CreditSimulatorPocTheme
import com.example.creditsimulatorpoc.ui.views.BottomBar

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@ExperimentalFoundationApi

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CreditSimulatorPocTheme {
                val scaffoldState = rememberScaffoldState()
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box {
                        AppNavGraph(
                            activity = this@MainActivity,
                            scaffoldState = scaffoldState,
                            navController = navController,
                            startDestination = AppDestinations.SPLASH,
                            activityone = this@MainActivity
                        )
                        val navBackStackEntry by navController.currentBackStackEntryAsState()

                        val currentRoute = navBackStackEntry?.destination?.route

                        Scaffold(
                            bottomBar = {
                                if (currentRoute?.startsWith("home/") == true)
                                    BottomBar(navController = navController)
                            }
                        ) {
                            Surface(
                                modifier = Modifier.padding(paddingValues = it)
                                    .fillMaxSize(),
                                color = MaterialTheme.colors.background
                            ) {
                                Box {
                                    AppNavGraph(
                                        activity = this@MainActivity,
                                        scaffoldState = scaffoldState,
                                        navController = navController,
                                        startDestination = AppDestinations.SPLASH,
                                        activityone = this@MainActivity
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CreditSimulatorPocTheme {

    }
}