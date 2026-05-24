package jesusernesto.lopezibarra.practicaautenticacionlopeze.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import jesusernesto.lopezibarra.practicaautenticacionlopeze.presentation.model.Artist
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.*

class HomeViewmodel : ViewModel() {
    private var db: FirebaseFirestore = Firebase.firestore

    private val _artist = MutableStateFlow<List<Artist>>(emptyList())
    val artist: StateFlow<List<Artist>> = _artist

    init {
        getArtists()
    }

//    private fun loadData() {
//        val random = (1..10000).random()
//        val artist = Artist(
//            name = "Random $random",
//            description = "Descripción random número $random",
//            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwyXeKDN29AmZgZPLS7n0Bepe8QmVappBwZCeA3XWEbWNdiDFB"
//        )
//        db.collection("artists").add(artist)
//    }

    private fun getArtists() {
        viewModelScope.launch {
            val result: List<Artist> = withContext(Dispatchers.IO) {
                getAllArtists()
            }
            _artist.value = result
        }
    }

    private suspend fun getAllArtists(): List<Artist> {
        return try {
            db.collection("artists").get().await().documents.mapNotNull { snapshot ->
                snapshot.toObject(Artist::class.java)
            }
        } catch (e: Exception) {
            Log.i("aris", e.toString())
            emptyList()
        }
    }

}