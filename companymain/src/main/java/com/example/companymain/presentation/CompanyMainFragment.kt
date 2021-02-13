package com.example.companymain.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.companymain.R
import com.example.companymain.adapter.CompanyMainAdapter
import com.example.companymain.databinding.FragmentMainCompanyBinding
import com.example.companymain.di.CompanyMainComponent
import com.example.core.navigation.CompanyMainNavigator
import com.example.core.utils.Resource
import com.example.detail.presentation.DetailFragmentViewModel
import javax.inject.Inject

class CompanyMainFragment : Fragment(R.layout.fragment_main_company), CompanyMainAdapter.Listener {

    private var _binding: FragmentMainCompanyBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var navigator: CompanyMainNavigator

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by activityViewModels<CompanyMainFragmentViewModel> { viewModelFactory }
    private val detailViewModel by activityViewModels<DetailFragmentViewModel> { viewModelFactory }

    private lateinit var adapter: CompanyMainAdapter

    override fun onAttach(context: Context) {
        CompanyMainComponent.injectFragment(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainCompanyBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        viewModel.getInfoCompany()
        viewModel.getMainInfo.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Loading -> {
                    showProgressBar()
                }
                is Resource.Success -> {
                    hideProgressBar()
                    adapter.submitList(it.data)
                }
                is Resource.Error -> {
                    hideProgressBar()
                    Toast.makeText(view.context, "Error", Toast.LENGTH_SHORT).show()

                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() {
        adapter = CompanyMainAdapter(this)
        binding.recycler.apply {
            this.adapter = this@CompanyMainFragment.adapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun showProgressBar() {
        binding.progress.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.progress.visibility = View.INVISIBLE
    }

    override fun onDetailInfoCompany(id: Long) {
        val nav = findNavController()
        detailViewModel.getDetailInfoCompany(id)
        navigator.navigateToDetail(nav)
    }


}