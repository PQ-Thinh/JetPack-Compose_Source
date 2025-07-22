package com.example.ggsouresjetpack.Side_Effects

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ggsouresjetpack.Side_Effects.ui.detail.DetailScreen
import com.example.ggsouresjetpack.Side_Effects.ui.detail.DetailViewModel
import com.example.ggsouresjetpack.Side_Effects.ui.home.HomeScreen
import com.example.ggsouresjetpack.Side_Effects.ui.list.ListScreen
import com.example.ggsouresjetpack.Side_Effects.ui.main.MainRoute
import com.example.ggsouresjetpack.Side_Effects.ui.profile.ProfileRoute
import com.example.ggsouresjetpack.Side_Effects.ui.register.RegisterRoute
import com.example.ggsouresjetpack.Side_Effects.ui.theme.GGSouresJetpackTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SideEffectsActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()


            GGSouresJetpackTheme {
                NavHost(navController = navController, startDestination = "/") {


                    composable(route = "/") {
                        MainRoute(
                            onNavigateDetail = {
                                navController.navigate("detail/")
                            },
                            onNavigateToHome = {
                                navController.navigate("home/")
                            },
                            onNavigateList = {
                                navController.navigate("list/")
                            }
                        )
                    }

                    composable(route = "home/") {
                        HomeScreen {
                            navController.navigate("register/")
                        }
                    }

                    composable(route = "register/") {
                        RegisterRoute() { userName ->
                            navController.navigate("profile/$userName")
                        }
                    }

                    composable(route = "profile/{userName}",
                        arguments = listOf(
                            navArgument(name = "userName") { type = NavType.StringType }
                        )
                    ) { navBackStackEntry ->
                        val username = navBackStackEntry.arguments?.getString("userName")
                        requireNotNull(username)
                        ProfileRoute(userName = username) {
                            navController.popBackStack()
                        }
                    }

                    composable("detail/"){
                        val viewModel:DetailViewModel = hiltViewModel()
                        DetailScreen(viewModel = viewModel) {
                            navController.navigate("home/")
                        }
                    }


                    composable("list/"){
                        ListScreen()
                    }

                }
            }
        }
    }

}