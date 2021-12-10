package com.example.dogtorpet.view.ui.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import com.google.android.material.bottomnavigation.BottomNavigationView

import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.dogtorpet.R
import com.example.dogtorpet.databinding.ActivityMainBinding
import com.google.android.material.bottomappbar.BottomAppBar



class MainActivity() : AppCompatActivity(), OnQueryTextListener, Parcelable {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DogAdapter
    private var dogImages = mutableListOf<String>()

    constructor(parcel: Parcel) : this() {

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configNav()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.searchview.setOnQueryTextListener(this)
        initRecyclerView()
    }

    private fun getRetroFit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")//¿Cuál URL?
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun searchByName(query:String) {
        CoroutineScope(Dispatchers.IO).launch {
            val call =
                getRetroFit().create(APIService::class.java).getDogsByBreeds("$query/images")
            val puppies = call.body()
            runOnUiThread {
                if (call.isSuccessful) {
                    val images = puppies?.images ?: emptyList()
                    dogImages.clear()
                    dogImages.addAll(images)
                    adapter.notifyDataSetChanged()
                } else {
                    showError()
                }
                hideKeyboard()
            }
        }
    }
        private fun initRecyclerView(){
            adapter= DogAdapter(dogImages)
            binding.rvDogs.layoutManager=LinearLayoutManager(this)
            binding.rvDogs.adapter=adapter
        }

        private fun showError(){
            Toast.makeText(this, "Ha ocurrido un error",Toast.LENGTH_SHORT).show()
        }

        override fun onQueryTextChange(newText: String?):Boolean{
            return true
        }

        override fun onQueryTextSubmit(query: String?):Boolean{
            if(!query.isNullOrEmpty()){
                searchByName(query.toLowerCase())
            }
            return true
        }

        private fun hideKeyboard(){
            val inm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inm.hideSoftInputFromWindow(binding.root.windowToken,0)
        }

    fun configNav() {
        val navView: BottomNavigationView = binding.navView
        navView.background = null
        val botView: BottomAppBar = binding.bottomappbar
        botView.setBackgroundColor(Color.parseColor("#C5F9F9"))
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navView.setupWithNavController(navController)

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }
}