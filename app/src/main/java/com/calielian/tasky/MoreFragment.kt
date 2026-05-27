package com.calielian.tasky

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.calielian.tasky.databinding.FragmentMoreBinding
class MoreFragment : Fragment() {
	private var _binding: FragmentMoreBinding? = null
	private val biding get() = _binding!!

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		_binding = FragmentMoreBinding.inflate(layoutInflater, container, false)
		return biding.root
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}