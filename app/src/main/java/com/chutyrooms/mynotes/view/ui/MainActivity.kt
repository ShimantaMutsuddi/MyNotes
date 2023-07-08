package com.chutyrooms.mynotes.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.chutyrooms.mynotes.R
import com.chutyrooms.mynotes.databinding.ActivityMainBinding
import com.chutyrooms.mynotes.service.network.db.NoteDatabase
import com.chutyrooms.mynotes.service.network.db.NoteDatabase.Companion.getDatabase
import com.chutyrooms.mynotes.service.repository.NoteRepo
import com.chutyrooms.mynotes.viewmodel.NoteViewModel
import com.chutyrooms.mynotes.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment
    var viewModel: NoteViewModel?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val newsRepository= NoteRepo(getDatabase(this))
        val viewModelProviderFactory=NoteViewModelFactory(newsRepository)
        viewModel= ViewModelProvider(this,viewModelProviderFactory)[NoteViewModel::class.java]

        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}