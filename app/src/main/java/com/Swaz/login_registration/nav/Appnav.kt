package com.Swaz.login_registration.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.Swaz.login_registration.data.AuthViewModel
import com.Swaz.login_registration.ui.theme.screens.home.Hm
import com.Swaz.login_registration.ui.theme.screens.login.Login
import com.Swaz.login_registration.ui.theme.screens.register.Reg
import com.Swaz.login_registration.ui.theme.screens.splash.Sp

@Composable
fun AppNav(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Route_Sp
)

{
    NavHost(
        modifier = Modifier,
        startDestination = startDestination,
        navController = navController
    )
    {
        composable(Route_Sp) { Sp(navController) }
        composable(Route_hm){ Hm(navController)}
        composable(Route_lgn){ Login(navController)}
        composable(Route_reg){ Reg(navController) }

    }

}

