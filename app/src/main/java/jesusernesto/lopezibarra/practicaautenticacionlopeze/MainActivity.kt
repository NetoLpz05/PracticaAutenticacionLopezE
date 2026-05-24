package jesusernesto.lopezibarra.practicaautenticacionlopeze

import android.os.Bundle
import android.util.Log
import androidx.activity.*
import androidx.activity.compose.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.ui.*
import androidx.navigation.*
import androidx.navigation.compose.*
import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.*
import jesusernesto.lopezibarra.practicaautenticacionlopeze.ui.theme.PracticaAutenticacionLopezETheme

class MainActivity : ComponentActivity() {
    private lateinit var navHostController: NavHostController
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        auth = Firebase.auth
        setContent {
            navHostController = rememberNavController()
            PracticaAutenticacionLopezETheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier.padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ){
                        NavigationWrapper(navHostController, auth)
                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            Log.i("aris", "Estoy logueado")
            auth.signOut()
        } else{
            //navHostController.navigate("login")
        }
    }
}