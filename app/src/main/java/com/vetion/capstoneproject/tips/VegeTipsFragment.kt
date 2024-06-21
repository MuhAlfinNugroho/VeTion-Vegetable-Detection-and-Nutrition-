package com.vetion.capstoneproject.ui.tips

import VetionAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.vetion.capstoneproject.databinding.FragmentVegeTipsBinding
import com.vetion.capstoneproject.tips.TipsViewModel

class VegeTipsFragment : Fragment() {

    private var _binding: FragmentVegeTipsBinding? = null
    private val binding get() = _binding!!

    private lateinit var tipsAdapter: VetionAdapter
    private val viewModel: TipsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVegeTipsBinding.inflate(inflater, container, false)
        val view = binding.root

        setupRecyclerView()
        observeViewModel()

        return view
    }

    private fun setupRecyclerView() {
        tipsAdapter = VetionAdapter()
        binding.rvListTips.apply {
            adapter = tipsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun observeViewModel() {
        viewModel.listTips.observe(viewLifecycleOwner, { tipsList ->
            tipsAdapter.setList(tipsList)
            if (tipsList.isNotEmpty()) {
                binding.rvListTips.visibility = View.VISIBLE
                binding.searchBar.visibility = View.VISIBLE // Tampilkan search bar jika ada data
            } else {
                binding.rvListTips.visibility = View.GONE
                binding.searchBar.visibility = View.GONE // Sembunyikan search bar jika data kosong
            }
        })

        viewModel.isLoading.observe(viewLifecycleOwner, { isLoading ->
            if (isLoading) {
                binding.progressBar.visibility = View.VISIBLE // Tampilkan progress bar atau loading indicator
            } else {
                binding.progressBar.visibility = View.GONE // Sembunyikan progress bar atau loading indicator
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}