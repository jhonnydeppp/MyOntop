package com.example.myontop.domain.repository

import com.example.myontop.domain.repository.entity.Contractor

class RepositoryImpl:Repository {

    override fun getContractors(): List<Contractor> =
        listOf(
            Contractor(contractorName = "Darlene Robertson", type = "Traditional", startDate = "Mar 4, 2021", amount = "\$200 USD", status = "Active"),
            Contractor(contractorName = "Darlene Robertson", type = "Traditional", startDate = "Mar 4, 2021", amount = "\$200 USD", status = "Active"),
            Contractor(contractorName = "Darlene Robertson", type = "Traditional", startDate = "Mar 4, 2021", amount = "\$200 USD", status = "Signature pending")
        )
}