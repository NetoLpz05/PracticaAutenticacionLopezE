package jesusernesto.lopezibarra.practicaautenticacionlopeze

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import jesusernesto.lopezibarra.practicaautenticacionlopeze.presentation.home.HomeScreen
import jesusernesto.lopezibarra.practicaautenticacionlopeze.presentation.initial.InitialScreen
import jesusernesto.lopezibarra.practicaautenticacionlopeze.presentation.login.LoginScreen
import jesusernesto.lopezibarra.practicaautenticacionlopeze.presentation.signup.SignUpScreen

@Composable
fun NavigationWrapper(navHostController: NavHostController, auth: FirebaseAuth){
    NavHost(navController = navHostController, startDestination = "home"){
        composable("initial"){
            InitialScreen(
                navigateToLogin = { navHostController.navigate("login") },
                navigateToSignUp = { navHostController.navigate("signUp") }
            )
        }
        composable("login"){
            LoginScreen(auth){navHostController.navigate("home")}
        }
        composable("signUp"){
            SignUpScreen(auth)
        }
        composable("home"){
            HomeScreen()
        }
    }
}