package uz.abduvali.multapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import uz.abduvali.multapp.repository.CharacterRepository

class CharacterViewModel() :
    ViewModel() {

    val flow = Pager(PagingConfig(10)) {
        CharacterSource()
    }.flow.cachedIn(viewModelScope)
}