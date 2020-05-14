package com.example.exo4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {

    val url = "https://jsonplaceholder.typicode.com/"
    lateinit var todo_list : List<ToDo>
    val context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gettodolist()
    }



    fun gettodolist() {

        //make progress spinner visible
        if (progressBar1 != null)
            progressBar1.visibility = View.VISIBLE
        //creer une instance du client retrofit
        val retrofit = RetrofitClientInstance.retrofitInstance
        //creer une instance du service
        val service = retrofit.create(DataService::class.java)

        // creer la requete get
        val Todo_request = service.get_todo_list()


        // executer la requete get
        Todo_request.enqueue(object : Callback<List<ToDo>> {
            override fun onResponse(call: Call<List<ToDo>>, response: Response<List<ToDo>>) {
                if (progressBar1 != null)
                    progressBar1.visibility = View.GONE
                val allarticles = response.body()
                if (allarticles != null) {
                    todo_list  = allarticles
                    var newadapter = ToDoAdapter( todo_list,context)
                   recyclerView.layoutManager = LinearLayoutManager(context)
                    recyclerView.adapter = newadapter
                    recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))


                }
            }

            override fun onFailure(call: Call<List<ToDo>>, t: Throwable) {
                if (progressBar1 != null)
                    progressBar1.visibility = View.GONE
                Toast.makeText(context, "error getting tasks", Toast.LENGTH_SHORT)
                    .show()

            }
        })

    }
}
