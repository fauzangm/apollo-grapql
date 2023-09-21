package id.riset.apollo.domain

import id.riset.apollo.CountryQuery

interface CountriesClient {
    suspend fun getCountries(): List<SimpelCountry>
    suspend fun getDetailCountries(code : String): DetailedCountry?
}