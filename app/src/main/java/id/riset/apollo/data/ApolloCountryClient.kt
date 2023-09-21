package id.riset.apollo.data

import com.apollographql.apollo3.ApolloClient
import id.riset.apollo.CountriesQuery
import id.riset.apollo.CountryQuery
import id.riset.apollo.domain.CountryClient
import id.riset.apollo.domain.model.DetailedCountry
import id.riset.apollo.domain.model.SimpelCountry

class ApolloCountryClient (
    private val apolloClient : ApolloClient
    ):CountryClient  {
    override suspend fun getCountries(): List<SimpelCountry> {
        return  apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toSimpleCountry()  }
            ?: emptyList()
    }

    override suspend fun getDetailCountries(code: String): DetailedCountry? {
        return  apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()

    }

}