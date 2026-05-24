package jesusernesto.lopezibarra.practicaautenticacionlopeze.presentation.login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.google.firebase.auth.FirebaseAuth
import jesusernesto.lopezibarra.practicaautenticacionlopeze.R
import jesusernesto.lopezibarra.practicaautenticacionlopeze.ui.theme.*

@Composable
fun LoginScreen(auth: FirebaseAuth, navigateToHome:() -> Unit = {}) {
    var email: String by remember { mutableStateOf("") }
    var password: String by remember { mutableStateOf("") }


    Column(Modifier.fillMaxSize().background(Black).padding(horizontal = 32.dp)){
        Row() {
            Icon(painter = painterResource(id = R.drawable.ic_back), contentDescription = "", tint = White,
                modifier = Modifier.padding(vertical = 24.dp).size(24.dp))
            Spacer(modifier = Modifier.weight(1f))
        }
        Text("Email", color = White, fontWeight = FontWeight.Bold, fontSize = 40.sp)
        TextField(value = email, onValueChange = {email = it}, Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(unfocusedContainerColor = UnselectedField, focusedContainerColor = SelectedField))
        Spacer(Modifier.height(48.dp))
        Text("Password", color = White, fontWeight = FontWeight.Bold, fontSize = 40.sp)
        TextField(value = password, onValueChange = {password = it},Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(unfocusedContainerColor = UnselectedField, focusedContainerColor = SelectedField))

        Spacer(Modifier.height(48.dp))
        Button(onClick = { auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if(task.isSuccessful){
                navigateToHome()
                Log.i("aris", "Login OK")
            } else {
                //Mostrar error
                Log.i("aris", "Login KO")
            } }})
            {
            Text("Log In")
        }
    }
}