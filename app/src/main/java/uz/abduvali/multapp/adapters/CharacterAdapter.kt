package uz.abduvali.multapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.abduvali.domain.models.Result
import uz.abduvali.multapp.database.AppDatabase
import uz.abduvali.multapp.database.entities.CharacterEntity
import uz.abduvali.multapp.databinding.ItemCharacterBinding
import uz.abduvali.multapp.utils.setImage
import uz.abduvali.multapp.utils.toCharacterEntity

class CharacterAdapter(private val onItemClick: OnItemClick) :
    PagingDataAdapter<Result, CharacterAdapter.Vh>(DiffUtil()) {

    interface OnItemClick {
        fun onClick(characterEntity: CharacterEntity)
    }

    class Vh(val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root)

    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        val item = getItem(position)?.toCharacterEntity()!!
        holder.binding.apply {
            AppDatabase.getInstance(image.context).characterDao().insert(item)
            root.setOnClickListener { onItemClick.onClick(item) }
            image.setImage(item.image)
            name.text = item.name
            location.text = item.location
            status.text = item.status
        }
    }
}