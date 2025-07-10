package com.example.greenai.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.greenai.api.viewmodel.ApiViewModel
import com.example.greenai.navigation.MainNavigationViewModel

@Composable
fun HomeScreen(){
    val viewModel: ApiViewModel = hiltViewModel()
    val navViewModel: MainNavigationViewModel = viewModel()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar("Irrigation Zones")
        }
    ) { padding->
        Box (
            modifier = Modifier.fillMaxSize()
                .padding(padding)
        ){
            if(viewModel.isLoading){
                LoadingScreen()
            }else{
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    state = rememberLazyGridState(),
                    contentPadding = PaddingValues(32.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ){
                    if (viewModel.greenHouseParameters.isNullOrEmpty()){
                        item {
                            Text("No data available for this greenhouse")
                        }
                    }else{
                        items(viewModel.greenHouseParameters!!.reversed()) {
                            ZoneCard("Zone ${it.node_id}"){
                                navViewModel.backStack.add(Screens.ZoneOverview(it))
                            }
                        }
                    }
                }
            }
        }
    }
}