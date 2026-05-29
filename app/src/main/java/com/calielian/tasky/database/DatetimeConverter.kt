package com.calielian.tasky.database

import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.time.ZoneOffset

class DatetimeConverter {

	// Converte o Long armazenado no banco em um LocalDateTime
	@TypeConverter
	fun fromTimestamp(value: Long?): LocalDateTime? {
		return value?.let {
			LocalDateTime.ofEpochSecond(it, 0, ZoneOffset.UTC)
		}
	}

	// Converte o LocalDateTime em um Long que será armazenado no banco
	@TypeConverter
	fun toTimestamp(date: LocalDateTime?): Long? {
		return date?.toEpochSecond(ZoneOffset.UTC)
	}
}