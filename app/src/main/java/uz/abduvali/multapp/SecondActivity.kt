package uz.abduvali.multapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.abduvali.multapp.adapters.TopAdapter
import uz.abduvali.multapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            rv.adapter = TopAdapter()
        }
    }
}