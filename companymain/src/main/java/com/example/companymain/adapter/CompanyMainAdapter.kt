package com.example.companymain.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.companymain.R
import com.example.companymain.databinding.CellCompanyMainInfoBinding
import com.example.core_api.dto.CompanyDTO

const val BASE_IMAGE_VIEW = "https://lifehack.studio/test_task/"

class CompanyMainAdapter(private val listener: Listener) :
    ListAdapter<CompanyDTO, CompanyMainAdapter.CompanyViewHolder>(companyMainInfoDiffUtil) {

    companion object {
        val companyMainInfoDiffUtil = object : DiffUtil.ItemCallback<CompanyDTO>() {
            override fun areItemsTheSame(oldItem: CompanyDTO, newItem: CompanyDTO): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: CompanyDTO, newItem: CompanyDTO): Boolean {
                return oldItem == newItem
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cell_company_main_info, parent, false)
        return CompanyViewHolder(view)
    }

    override fun onBindViewHolder(holder: CompanyViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }

        holder.itemView.setOnClickListener {
            getItem(position)?.let {
                listener.onDetailInfoCompany(it.id.toLong())
            }
        }
    }

    class CompanyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = CellCompanyMainInfoBinding.bind(itemView)

        fun bind(companyDTO: CompanyDTO) {
            binding.nameCompany.text = companyDTO.name
            Glide.with(itemView.context).load(BASE_IMAGE_VIEW + companyDTO.img)
                .into(binding.imageCompany)
        }

        companion object {
            fun create(parent: ViewGroup): CompanyViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.cell_company_main_info, parent, false)
                return CompanyViewHolder(view)
            }
        }
    }


    interface Listener {
        fun onDetailInfoCompany(id: Long)
    }
}