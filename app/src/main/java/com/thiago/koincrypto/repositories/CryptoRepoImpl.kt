package com.thiago.koincrypto.repositories

import com.thiago.koincrypto.models.ApiBaseModel
import com.thiago.koincrypto.models.BaseModel
import com.thiago.koincrypto.models.CryptoCurrencyList
import com.thiago.koincrypto.network.Api

class CryptoRepoImpl(private val api: Api):CryptoRepo {
    override suspend fun getListing(): BaseModel<ApiBaseModel<CryptoCurrencyList>> {
        try {
            api.getListing(
                start = 1,
                limit = 100
            ).also {
                return if (it.isSuccessful){
                    BaseModel.Success(data = it.body()!!)
                }else{
                    BaseModel.Error("We have an error")
                }
            }
        }catch (e:Exception){
            return BaseModel.Error(e.message.toString())
        }
    }
}