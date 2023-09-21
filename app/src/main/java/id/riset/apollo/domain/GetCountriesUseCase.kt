package id.riset.apollo.domain

import id.riset.apollo.domain.model.SimpelCountry

class GetCountriesUseCase(
    private val countryClient : CountryClient
) {
    suspend fun execute(): List<SimpelCountry> {
        return countryClient
            .getCountries()
            .sortedBy { it.name }
    }
}