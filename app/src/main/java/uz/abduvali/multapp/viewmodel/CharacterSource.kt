package uz.abduvali.multapp.viewmodel

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import uz.abduvali.multapp.repository.CharacterRepository
import uz.abduvali.multapp.retrofit.ApiClient

class CharacterSource() :
    PagingSource<Int, uz.abduvali.domain.models.Result>() {

    private val characterRepository = CharacterRepository(ApiClient.apiService)

    override fun getRefreshKey(state: PagingState<Int, uz.abduvali.domain.models.Result>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, uz.abduvali.domain.models.Result> {
        try {
            val currentPage = params.key ?: 1

            var loadResult: LoadResult.Page<Int, uz.abduvali.domain.models.Result>? = null

            if (params.key ?: 1 >= 1) {
                characterRepository.getCharacters(currentPage)
                    .catch {
                        loadResult = LoadResult.Page(
                            emptyList(),
                            currentPage - 1, currentPage + 1
                        )
                    }.collect {
                        loadResult =
                            LoadResult.Page(
                                it.body()?.results ?: emptyList(),
                                currentPage - 1, currentPage + 1
                            )
                    }
            } else {
                loadResult =
                    LoadResult.Page(
                        emptyList(),
                        null, currentPage + 1
                    )
            }
            return loadResult!!
        } catch (e: Exception) {
            return LoadResult.Error(e.fillInStackTrace())
        }
    }
}