package jesusernesto.lopezibarra.practicaautenticacionlopeze.presentation.initial

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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.*
import com.google.firebase.ktx.*
import jesusernesto.lopezibarra.practicaautenticacionlopeze.R
import jesusernesto.lopezibarra.practicaautenticacionlopeze.ui.theme.*

@Composable
fun InitialScreen(navigateToLogin:() -> Unit = {}, navigateToSignUp:() -> Unit = {}) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val auth: FirebaseAuth = Firebase.auth

    Column(modifier = Modifier.fillMaxSize()
            .background(Brush.verticalGradient(listOf(Gray, Black), startY = 0f, endY = 600f)).padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(1f))
        
        Image(painter = painterResource(id = R.drawable.spotify), contentDescription = "spotify",
            modifier = Modifier.clip(CircleShape).height(48.dp))
        Spacer(modifier = Modifier.weight(1f))

        Text("Millions of Songs", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 38.sp)
        Text("Free on Spotify", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 38.sp)

        Spacer(Modifier.weight(1f))

        Button(onClick = { navigateToSignUp() }, Modifier.fillMaxWidth().padding(32.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Green)){
            Text("Sign up free", color = Black, fontWeight = FontWeight.Bold)
        }
        Spacer(Modifier.height(8.dp))
        CustomButton(Modifier.clickable{ }, painterResource(id = R.drawable.google), "Continue with Google")
        Spacer(Modifier.height(8.dp))
        CustomButton(Modifier.clickable{ }, painterResource(id = R.drawable.facebook), "Continue with Facebook")
        Text("Log In", color = Color.White, modifier = Modifier.padding(24.dp).clickable { navigateToLogin() },
            fontWeight = FontWeight.Bold)
        Spacer(Modifier.weight(1f))
    }
}

@Composable
fun CustomButton(modifier:Modifier, painter: Painter, title: String){
    Box(Modifier.fillMaxWidth().height(48.dp).padding(horizontal = 32.dp).background(BackgroundButton)
        .border(2.dp, ShapeButton, CircleShape),
        contentAlignment = Alignment.CenterStart,){
        Image(painter = painter, contentDescription = "",
            Modifier.padding(start = 16.dp).size(16.dp))
        Text(title, color = Color.White, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
    }
}