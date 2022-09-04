package com.example.myontop.presentation.contractor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myontop.domain.repository.entity.Contractor

class ContractorViewModel : ViewModel() {

    private val contractorsMutable: MutableLiveData<List<Contractor>> = MutableLiveData()
    val contractors: LiveData<List<Contractor>> = contractorsMutable
    private val contractorModel: ContractorModel = ContractorModel()

    fun getContractors() {
        contractorsMutable.postValue(contractorModel.getContractors())
    }
}