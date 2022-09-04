package com.example.myontop.domain.repository

import com.example.myontop.domain.repository.entity.Contractor

interface Repository {

    fun getContractors(): List<Contractor>

}