package id.riset.apollo.ui.theme

import androidx.compose.runtime.Composable
import id.riset.apollo.presentation.CountriesViewModel

@Composable
fun CountriesScreen(
    state : CountriesViewModel.CountriesState,
    onSelectedCountry : (code :String) -> Unit,
    onDismissCountryDialog : () -> Unit
){
    
}