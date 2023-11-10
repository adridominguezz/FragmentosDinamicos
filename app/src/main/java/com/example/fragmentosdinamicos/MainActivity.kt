package com.example.fragmentosdinamicos

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.fragmentosdinamicos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    var cargarFragmento2 = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)


        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, FirstFragment())
            .commit();



        binding.fab.setOnClickListener {
            var f: Fragment?=null

            if(cargarFragmento2){f = AveriaFragment.newInstance(3  )}else{f = FirstFragment()}

            supportFragmentManager
                    .beginTransaction()
                .replace(R.id.container, f)
                .commit();
            cargarFragmento2 = !cargarFragmento2
        }
    }


}