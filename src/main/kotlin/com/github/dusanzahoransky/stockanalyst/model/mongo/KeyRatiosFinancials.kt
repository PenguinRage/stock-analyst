package com.github.dusanzahoransky.stockanalyst.model.mongo

import com.github.dusanzahoransky.stockanalyst.model.LastRefreshDate
import com.github.dusanzahoransky.stockanalyst.model.enums.Exchange
import com.github.dusanzahoransky.stockanalyst.model.ms.keyratios.Result
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.util.*

/**
 * Raw data cached from MorningStar API
 */
@Document
data class KeyRatiosFinancials(
    @Id var id: String? = null,
    val symbol: String,
    val exchange: Exchange,
    val date: LocalDate = LocalDate.now(),
    var results: List<Result> = ArrayList()
) : LastRefreshDate {
    override fun getLastRefreshDate(): LocalDate {
        return date
    }
}