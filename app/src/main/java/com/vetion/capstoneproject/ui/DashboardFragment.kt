package com.vetion.capstoneproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.vetion.capstoneproject.databinding.FragmentDashboardBinding
import com.vetion.capstoneproject.ui.dashboard.DashboardViewModel

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Bind the ViewModel data to the views
        dashboardViewModel.title.observe(viewLifecycleOwner) {
            binding.textTitle.text = it
        }

        dashboardViewModel.tanggalPemeriksaan.observe(viewLifecycleOwner) {
            binding.textTanggal.text = it
        }

        dashboardViewModel.hasilPemeriksaan.observe(viewLifecycleOwner) {
            binding.textHasil.text = it
        }

        dashboardViewModel.saranDetail.observe(viewLifecycleOwner) {
            binding.textSaranDetail.text = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
