//package com.example.myapplicationtest
//
//import android.content.Intent
//import android.os.Bundle
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//import androidx.fragment.app.Fragment
//import com.example.myapplicationtest.databinding.ActivityMainBinding
//
//class MainActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityMainBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        // Fragmento inicial
//        replaceFragment(CharacterFragment())
//
//        // Configura o BottomNavigationView
//        binding.bottomNavigationView2.setOnItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.id_characters -> replaceFragment(CharacterFragment())
//                R.id.id_planets -> replaceFragment(PlanetsFragment())
//                R.id.id_favorits -> replaceFragment(FavoritsFragment())
//            }
//            true
//        }
//    }
//
//    // Função para trocar o fragment
//    private fun replaceFragment(fragment: Fragment) {
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragmentContainerView, fragment)
//            .commit()
//    }
//}

package com.example.myapplicationtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.myapplicationtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Liga o bottom nav ao navController
        binding.bottomNavigationView.setupWithNavController(navController)
    }
}