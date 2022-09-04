package com.example.myontop.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getColorStateList
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getColor
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.myontop.R
import com.example.myontop.databinding.ContractorItemBinding
import com.example.myontop.domain.repository.entity.Contractor
import kotlin.properties.Delegates

class ContractorAdapter(
    items: List<Contractor> = emptyList(), private val lambda:
        (contractor: Contractor) -> Unit
) : RecyclerView.Adapter<ContractorAdapter.ViewHolder>() {

    var items: List<Contractor> by Delegates.observable(items) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ContractorItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { lambda.invoke(items[position]) }
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(private val binding: ContractorItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(contractor: Contractor) {
            with(binding) {
                contractorName.text = contractor.contractorName
                type.text = contractor.type
                startDate.text = contractor.startDate
                amount.text = contractor.amount
                status.text = contractor.status
                view9.setOnClickListener { toolInclude.root.isVisible = true }
                toolInclude.root.setOnClickListener { toolInclude.root.isVisible = false }
                if (contractor.status.contains("Signature")) {
                    status.backgroundTintList = getColorStateList(binding.root.context,R.color.orange)
                    status.setTextColor(getColor(binding.root.context, R.color.orange_text))
                    imageView5.setColorFilter(ContextCompat.getColor(binding.root.context, R.color.orange_text), android.graphics.PorterDuff.Mode.SRC_IN);
                }
            }

        }
    }


}