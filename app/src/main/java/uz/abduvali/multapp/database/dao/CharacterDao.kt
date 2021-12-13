package uz.abduvali.multapp.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Update
import uz.abduvali.multapp.database.entities.CharacterEntity

@Dao
interface CharacterDao {

    @Insert(onConflict = REPLACE)
    fun insert(entity: CharacterEntity)

    @Update
    fun update(entity: CharacterEntity)

    @Delete
    fun delete(entity: CharacterEntity)
}