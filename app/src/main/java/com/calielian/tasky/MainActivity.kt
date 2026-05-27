package com.calielian.tasky

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.calielian.tasky.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		if (savedInstanceState == null) {
			changeFragment(TaskFragment())
		}

		binding.navBar.setOnItemSelectedListener {
			when (it.itemId) {
				R.id.task_navbar -> changeFragment(TaskFragment())
				R.id.routine_navbar -> changeFragment(RoutineFragment())
				R.id.more_navbar -> changeFragment(MoreFragment())
			}
			true
		}
	}

	private fun changeFragment(newFragment: Fragment) {
		supportFragmentManager.beginTransaction()
			.replace(R.id.fragment_container, newFragment)
			.commit()
	}
}