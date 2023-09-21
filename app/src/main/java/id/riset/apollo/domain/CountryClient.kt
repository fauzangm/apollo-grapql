package id.riset.apollo.domain

import id.riset.apollo.domain.model.DetailedCountry
import id.riset.apollo.domain.model.SimpelCountry

interface CountryClient {
    suspend fun getCountries(): List<SimpelCountry>
    suspend fun getDetailCountries(code : String): DetailedCountry?
}