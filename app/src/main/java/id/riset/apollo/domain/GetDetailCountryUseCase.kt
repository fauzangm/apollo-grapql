package id.riset.apollo.domain

import id.riset.apollo.domain.model.DetailedCountry
import id.riset.apollo.domain.model.SimpelCountry

class GetDetailCountryUseCase(
    private val countryClient : CountryClient
) {
    suspend fun execute(code :String): DetailedCountry? {
        return countryClient.getDetailCountries(code)
    }
}