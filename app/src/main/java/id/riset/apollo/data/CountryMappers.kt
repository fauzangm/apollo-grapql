package id.riset.apollo.data

import id.riset.apollo.CountriesQuery
import id.riset.apollo.CountryQuery
import id.riset.apollo.domain.DetailedCountry
import id.riset.apollo.domain.SimpelCountry

fun CountryQuery.Country.toDetailedCountry():DetailedCountry{
    return DetailedCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No Capital",
        currency = currency ?: "No Currency",
        language = languages.mapNotNull { it.name },
        continent = continent.name
    )
}

fun CountriesQuery.Country.toSimpleCountry():SimpelCountry{
    return SimpelCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No Capital"
    )
}