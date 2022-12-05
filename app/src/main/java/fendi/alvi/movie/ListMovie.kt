package fendi.alvi.movie

import fendi.alvi.movie.`interface`.TmdbEndpoints
import fendi.alvi.movie.Adapter.MainAdapter
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fendi.alvi.movie.models.PopularMovies
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import fendi.alvi.movie.Services.ServiceBuilder


class ListMovie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_movie)
        val rvUser: RecyclerView = findViewById(R.id.recyclerview)
        getMovieNew(rvUser)
    }
    fun getMovieNew(recyclerView: RecyclerView){
        val request = ServiceBuilder.buildService(TmdbEndpoints::class.java)
        val call = request.getMovies(getString(R.string.api_key))

        call.enqueue(object : Callback<PopularMovies>{
            override fun onResponse(call: Call<PopularMovies>, response: Response<PopularMovies>) {
                if (response.isSuccessful){

                    recyclerView.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@ListMovie)
                        adapter = MainAdapter(response.body()!!.results)
                    }
                    Log.e("resp",response.body().toString())
                }
            }
            override fun onFailure(call: Call<PopularMovies>, t: Throwable) {
                Toast.makeText(this@ListMovie, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })

    }

}