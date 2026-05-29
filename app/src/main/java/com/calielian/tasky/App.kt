package com.calielian.tasky

import android.app.Application
import com.calielian.tasky.database.AppDatabase
import com.google.android.material.color.DynamicColors

class App: Application() {
	val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }

	override fun onCreate() {
		super.onCreate()
		DynamicColors.applyToActivitiesIfAvailable(this)
	}
}