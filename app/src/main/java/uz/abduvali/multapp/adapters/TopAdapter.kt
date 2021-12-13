package uz.abduvali.multapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.abduvali.multapp.databinding.ItemTopBinding

class TopAdapter() : RecyclerView.Adapter<TopAdapter.Vh>() {

    class Vh(val binding: ItemTopBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemTopBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.binding.apply {
            val manager =
                object : LinearLayoutManager(rv.context, HORIZONTAL, false) {
                    override fun checkLayoutParams(lp: RecyclerView.LayoutParams?): Boolean {
                        val size = width / 2.65
                        lp?.width = size.toInt()
                        return super.checkLayoutParams(lp)
                    }
                }
            rv.layoutManager = manager
            rv.adapter = BottomAdapter()
        }
    }

    override fun getItemCount(): Int {
        return 10
    }
}