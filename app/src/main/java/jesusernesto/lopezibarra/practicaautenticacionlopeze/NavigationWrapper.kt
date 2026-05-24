package jesusernesto.lopezibarra.practicaautenticacionlopeze

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.*
import com.google.firebase.auth.FirebaseAuth
import jesusernesto.lopezibarra.practicaautenticacionlopeze.presentation.initial.InitialScreen
import jesusernesto.lopezibarra.practicaautenticacionlopeze.presentation.login.LoginScreen
import jesusernesto.lopezibarra.practicaautenticacionlopeze.presentation.signup.SignUpScreen

@Composable
fun NavigationWrapper(navHostController: NavHostController, auth: FirebaseAuth){
    NavHost(navController = navHostController, startDestination = "initial"){
        composable("initial"){
            InitialScreen(
                navigateToLogin = { navHostController.navigate("login") },
                navigateToSignUp = { navHostController.navigate("signUp") }
            )
        }
        composable("login"){
            LoginScreen(auth)
        }
        composable("signUp"){
            SignUpScreen(auth)
        }
    }
}