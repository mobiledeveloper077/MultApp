package uz.abduvali.multapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.abduvali.multapp.databinding.ItemBottomBinding

class BottomAdapter() : RecyclerView.Adapter<BottomAdapter.Vh>() {

    class Vh(val binding: ItemBottomBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemBottomBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }
}