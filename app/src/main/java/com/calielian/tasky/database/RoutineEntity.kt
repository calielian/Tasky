package com.calielian.tasky.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(
	tableName = "Routine"
)
data class RoutineEntity(
	@PrimaryKey(autoGenerate = true) val id: Int = 0,
	@ColumnInfo(name = "title") val title: String?,
	@ColumnInfo(name = "description") val description: String?,
	@ColumnInfo(name = "datetime") val date: LocalDateTime?
)
