package com.calielian.tasky.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime

@Dao
interface RoutineDao {
	@Insert
	suspend fun insert(routine: RoutineEntity)

	@Delete
	suspend fun delete(routine: RoutineEntity)

	@Query("DELETE FROM sqlite_sequence WHERE name = 'Routine'")
	suspend fun resetId()

	@Query("SELECT * FROM Routine")
	fun getAllRoutines(): Flow<List<RoutineEntity>>

	@Query("DELETE FROM Routine WHERE id = :id")
	suspend fun deleteRoutine(id: Int)

	@Query("DELETE FROM Routine")
	suspend fun deleteAllRoutines()

	@Query("UPDATE Routine SET description = :description WHERE id = :id")
	suspend fun updateRoutineDescription(id: Int, description: String)

	@Query("UPDATE Routine SET title = :title WHERE id = :id")
	suspend fun updateRoutineTitle(id: Int, title: String)

	@Query("UPDATE Routine SET datetime = :datetime WHERE id = :id")
	suspend fun updateRoutineDate(id: Int, datetime: LocalDateTime)
}