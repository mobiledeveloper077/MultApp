package uz.abduvali.multapp.viewmodel

import uz.abduvali.multapp.database.entities.CharacterEntity

sealed class CharacterResource {

    object Loading : CharacterResource()
    data class Error(val message: String) : CharacterResource()
    data class Success(val list: List<CharacterEntity>?) : CharacterResource()
}