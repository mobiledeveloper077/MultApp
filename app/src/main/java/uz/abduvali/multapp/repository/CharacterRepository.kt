package uz.abduvali.multapp.repository

import kotlinx.coroutines.flow.flow
import uz.abduvali.multapp.database.dao.CharacterDao
import uz.abduvali.multapp.database.entities.CharacterEntity
import uz.abduvali.multapp.retrofit.ApiService

class CharacterRepository(
    private val apiService: ApiService
) {

    suspend fun getCharacters(page: Int) =
        flow { emit(apiService.getCharacters(page)) }
}