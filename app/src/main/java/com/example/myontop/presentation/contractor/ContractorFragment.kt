package com.example.myontop.presentation.contractor

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.myontop.databinding.ContractorFragmentBinding
import com.example.myontop.presentation.adapter.ContractorAdapter

class ContractorFragment : Fragment() {
    private lateinit var binding: ContractorFragmentBinding
    private lateinit var contractorAdapter: ContractorAdapter

    companion object {
        fun newInstance() = ContractorFragment()
    }

    private lateinit var viewModel: ContractorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ContractorFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[ContractorViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewConfig()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel = ContractorViewModel()
        viewModel.contractors.observe(viewLifecycleOwner) { contractorAdapter.items = it }
        viewModel.getContractors()
    }

    private fun recyclerViewConfig() {
        val recyclerView = binding.contractorRecycler
        recyclerView.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.setHasFixedSize(false)
        recyclerView.isNestedScrollingEnabled = false
        contractorAdapter =
            ContractorAdapter(listOf()) { _ -> }
        binding.contractorRecycler.adapter = contractorAdapter
    }
}