package id.riset.apollo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.riset.apollo.domain.GetCountriesUseCase
import id.riset.apollo.domain.GetDetailCountryUseCase
import id.riset.apollo.domain.model.DetailedCountry
import id.riset.apollo.domain.model.SimpelCountry
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CountriesViewModel(
    private val getCountriesUseCase: GetCountriesUseCase,
    private val getDetailCountryUseCase: GetDetailCountryUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CountriesState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }
            _state.update {
                it.copy(
                    countries = getCountriesUseCase.execute(),
                    isLoading = false
                )
            }
        }
    }


    fun selectedCountry(code:String){
        viewModelScope.launch {
            _state.update {
                it.copy(
                    selectedCountry = getDetailCountryUseCase.execute(code)
                )
            }
        }
    }

    fun dismisCountryDialog(){
        _state.update {
            it.copy(
                selectedCountry = null
            )
        }
    }
    data class CountriesState(
        val countries: List<SimpelCountry> = emptyList(),
        val isLoading: Boolean = false,
        val selectedCountry: DetailedCountry? = null
    )
}