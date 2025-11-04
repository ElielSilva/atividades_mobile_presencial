package modulo3.movieapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import modulo3.movieapp.repository.MovieRepository
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    private val repository = MovieRepository()

    // liveData que vai guarda o texto a ser exibido na tela
    private val _resultText = MutableLiveData<String>()
    val resultText: LiveData<String> get() = _resultText

    // função para buscar filmes populares usando viewModelScope.launch
    fun loadPopularMovies() {
        //vai exeuctar as tarefas de forma assincrona sem travar a tela
        viewModelScope.launch {
            _resultText.value = "Carregando filmes populares..."
            val movies = repository.fetchPopularMovies()
            _resultText.value = "🎬 Filmes Populares:\n${movies.joinToString("\n")}"
        }
    }

    // função para buscar detalhes de um filme aleatório
    fun loadMovieDetails() {
        viewModelScope.launch {
            _resultText.value = "Buscando detalhes do filme..."
            val movie = repository.getRandomMovieDetails()
            _resultText.value =
                "📽️ Detalhes do filme:\nTítulo: ${movie.title}\nAno: ${movie.year}\nNota: ${movie.rating}/10"
        }
    }
}