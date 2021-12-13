package uz.abduvali.multapp.retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import uz.abduvali.domain.models.Character

interface ApiService {

    @GET("character/")
    suspend fun getCharacters(@Query("page") page: Int = 1): Response<Character>
}