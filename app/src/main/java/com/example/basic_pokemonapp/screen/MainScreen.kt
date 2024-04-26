package com.example.basic_pokemonapp.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.example.basic_pokemonapp.viewmodel.PokemonViewModel

@Composable
fun MainScreen(
	onPokemonClick: (String) -> Unit,
	viewModel: PokemonViewModel = hiltViewModel()
) {
	val lazyPagingItems = viewModel.pokemonList.collectAsLazyPagingItems()
	
	// 포켓몬 목록
	LazyColumn {
		items(
			count = lazyPagingItems.itemCount,
			key = lazyPagingItems.itemKey { it.url },
		) { index ->
			lazyPagingItems[index]?.let { item ->
				Card(
					elevation = CardDefaults.cardElevation(8.dp),
					modifier = Modifier
						.padding(8.dp)
						.fillMaxWidth()
				) {
					Row(
						verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)
					) {
						Column {
							Text("포켓몬: ${item.name}")
							Text(text = item.url, Modifier.alpha(0.4f))
							Spacer(modifier = Modifier.size(16.dp))
							Button(onClick = { onPokemonClick(item.url) }) {
								Text("보기")
							}
						}
					}
				}
			}
		}
	}
}