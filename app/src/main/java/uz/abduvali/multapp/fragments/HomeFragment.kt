package uz.abduvali.multapp.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.abduvali.multapp.R
import uz.abduvali.multapp.adapters.CharacterAdapter
import uz.abduvali.multapp.database.entities.CharacterEntity
import uz.abduvali.multapp.databinding.FragmentHomeBinding
import uz.abduvali.multapp.viewmodel.CharacterViewModel
import kotlin.coroutines.CoroutineContext

class HomeFragment : Fragment(R.layout.fragment_home), CoroutineScope {

    private lateinit var characterViewModel: CharacterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        characterViewModel = ViewModelProvider(this)[CharacterViewModel::class.java]
    }

    private val binding by viewBinding(FragmentHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val characterAdapter = CharacterAdapter(object : CharacterAdapter.OnItemClick {
            override fun onClick(characterEntity: CharacterEntity) {
                findNavController().navigate(R.id.action_homeFragment_to_characterFragment)
            }
        })
        binding.rv.adapter = characterAdapter

        launch {
            characterViewModel.flow.catch {
                
            }.collect {
                characterAdapter.submitData(it)
            }
        }
    }

    override val coroutineContext: CoroutineContext
        get() = Job()
}