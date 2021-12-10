package uz.abduvali.multapp.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharacterEntity(
    @PrimaryKey
    val id: Int,
    val image: String,
    val location: String,
    val name: String,
    val status: String,
)