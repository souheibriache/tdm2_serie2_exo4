package com.example.exo4

import retrofit2.Call
import retrofit2.http.GET

interface DataService {
    @GET("/posts") fun get_todo_list(): Call<List<ToDo>>
}