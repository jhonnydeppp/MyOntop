package com.example.myontop.presentation.contractor

import com.example.myontop.domain.repository.Repository
import com.example.myontop.domain.repository.RepositoryImpl
import com.example.myontop.domain.repository.entity.Contractor

class ContractorModel {
    private val repository: Repository = RepositoryImpl()

    fun getContractors(): List<Contractor> = repository.getContractors()

}