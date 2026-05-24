package jesusernesto.lopezibarra.practicaautenticacionlopeze.presentation.home

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import coil.compose.AsyncImage
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import jesusernesto.lopezibarra.practicaautenticacionlopeze.presentation.model.*
import androidx.compose.runtime.State
import jesusernesto.lopezibarra.practicaautenticacionlopeze.ui.theme.Black

@Composable
fun HomeScreen(viewmodel: HomeViewmodel = HomeViewmodel()) {
    val artists: State<List<Artist>> = viewmodel.artist.collectAsState()

    Column(
        Modifier.fillMaxSize().background(Black).padding(horizontal = 32.dp)) {

        Text("Popular Artists", color = White, fontWeight = FontWeight.Bold, fontSize = 40.sp)

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow {
            items(artists.value) {
                ArtistItem(it)
            }
        }
    }
}

@Composable
fun ArtistItem(artist: Artist){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        AsyncImage(
            modifier = Modifier.size(60.dp).clip(CircleShape),
            model = artist.image,
            contentDescription = "Artists image",
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = artist.name.orEmpty(), color = White)
    }
}

@Preview
@Composable
fun ArtistItemPreview(){
    val artist = Artist(
        "MegaR",
        "El GOAT",
        "https://akamai.sscdn.co/letras/250x250/fotos/3/5/a/b/35ab7158f884ee3a056724ab2662bb73.jpg",
        //emptyList()
    )
    ArtistItem(artist = artist)
}













//fun createArtist(db: FirebaseFirestore){
//    val random = (1..1000).random()
//    val artist = Artist(name = "Random $random", numberOfSongs = random)
//    db.collection("artists").add(artist)
//        .addOnSuccessListener {
//            Log.i("aris", "SUCCESS")
//        }
//        .addOnFailureListener {
//            Log.i("aris", "FAILURE")
//        }
//        .addOnCompleteListener {
//            Log.i("aris", "COMPLETE")
//        }
//}