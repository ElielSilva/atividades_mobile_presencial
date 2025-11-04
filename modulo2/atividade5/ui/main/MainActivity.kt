package modulo3.movieapp.ui.main

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import com.example.mobile.R
import kotlinx.coroutines.*
import modulo3.movieapp.repository.MovieRepository
import androidx.activity.viewModels
import androidx.lifecycle.Observer


class MainActivity : AppCompatActivity() {

    // instancia o ViewModel
    private val viewModel: MovieViewModel by viewModels()

    private lateinit var txtResult: TextView
    private lateinit var btnLoadMovies: Button
    private lateinit var btnMovieDetails: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        txtResult = findViewById(R.id.txtResult)
        btnLoadMovies = findViewById(R.id.btnLoadMovies)
        btnMovieDetails = findViewById(R.id.btnMovieDetails)

        // observa o LiveData do ViewModel e atualiza a tela quando o valor mudar
        viewModel.resultText.observe(this, Observer { result ->
            txtResult.text = result
        })

        // botoes pra chamar os metodos
        btnLoadMovies.setOnClickListener {
            viewModel.loadPopularMovies()
        }

        btnMovieDetails.setOnClickListener {
            viewModel.loadMovieDetails()
        }
    }
}
