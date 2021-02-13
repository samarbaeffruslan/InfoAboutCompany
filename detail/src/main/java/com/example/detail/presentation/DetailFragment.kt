package com.example.detail.presentation

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.core.utils.Resource
import com.example.detail.R
import com.example.detail.databinding.FragmentDetailBinding
import com.example.detail.di.DetailComponent
import javax.inject.Inject

const val BASE_IMAGE_VIEW = "https://lifehack.studio/test_task/"

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by activityViewModels<DetailFragmentViewModel> { viewModelFactory }

    override fun onAttach(context: Context) {
        DetailComponent.injectFragment(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeDetail(view)


    }

    private fun showProgress(){
        binding.progressCircular.visibility = View.VISIBLE
        binding.cardPoster.visibility = View.INVISIBLE
    }

    private fun hideProgress(){
        binding.progressCircular.visibility = View.INVISIBLE
    }

    private fun showSuccess(){
        binding.progressCircular.visibility = View.INVISIBLE
        binding.cardPoster.visibility = View.VISIBLE
    }

    private fun observeDetail(view: View){
        viewModel.getDetailInfo.observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Loading ->{
                    showProgress()

                }

                is Resource.Success ->{
                    showSuccess()
                    binding.description.text = it.data?.get(0)?.description
                    binding.nameCompany.text = it.data?.get(0)?.name
                    Glide.with(view.context).load(BASE_IMAGE_VIEW + it.data?.get(0)?.img)
                        .into(binding.companyPoster)

                }

                is Resource.Error ->{
                    hideProgress()
                    Toast.makeText(view.context, "Error connection:(", Toast.LENGTH_SHORT).show()

                }
            }
        })
    }


}