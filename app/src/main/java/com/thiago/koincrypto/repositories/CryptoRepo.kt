package com.thiago.koincrypto.repositories

import com.thiago.koincrypto.models.ApiBaseModel
import com.thiago.koincrypto.models.BaseModel
import com.thiago.koincrypto.models.CryptoCurrencyList

interface CryptoRepo {
    suspend fun getListing(): BaseModel<ApiBaseModel<CryptoCurrencyList>>
}