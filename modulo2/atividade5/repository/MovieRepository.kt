package modulo3.movieapp.repository

import kotlinx.coroutines.delay
import modulo3.movieapp.model.Movie

class MovieRepository {
    suspend fun fetchPopularMovies(): List<String> {
        delay(2000) // simula tempo
        return listOf("Oppenheimer", "Uma Batalha Após a Outra", "Duna: Parte 2", "Interestelar", "Barbie")
    }

    suspend fun getRandomMovieDetails(): Movie {
        delay(2500)//simular tempo
        val movies = listOf(
            Movie("Oppenheimer", 2023, 8.5),
            Movie("Gênio Indomável", 1997, 9.0),
            Movie("After Hours", 1985, 9.8),
            Movie("12 Homens e uma sentença", 1957, 10.0)
        )
        return movies.random()
    }
}
