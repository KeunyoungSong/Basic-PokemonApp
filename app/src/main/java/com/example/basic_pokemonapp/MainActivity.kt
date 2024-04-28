package com.example.basic_pokemonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.basic_pokemonapp.screen.DetailScreen
import com.example.basic_pokemonapp.screen.MainScreen
import com.example.basic_pokemonapp.ui.theme.BasicPokemonAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			BasicPokemonAppTheme {				// A surface container using the 'background' color from the theme
				Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
					TopLevel()
				}
			}
		}
	}
}
@Composable
fun TopLevel(
	navController: NavHostController = rememberNavController(),
	modifier: Modifier = Modifier
) {
	NavHost(navController = navController, startDestination = "Home", modifier = modifier) {		// 홈 페이지
		composable("Home") {
			MainScreen(onPokemonClick = {
				val pokemonId = it.substringAfter("pokemon/").substringBefore("/").toInt()
				navController.navigate("Detail/${pokemonId}")
			})
		}
		
		// 상세페이지
		composable(
			// 다른 화면에서 상세 페이지로 넘어올 때 pokemonId 을 동적으로 지정해 상세화면을 보여줄 수 있다
			// 아래는 pokemonId 키워드 위치에 있는 값을 Int 타입으로 간주한다는 설정을 한다
			"Detail/{pokemonId}", arguments = listOf(navArgument("pokemonId") {
				type = NavType.IntType
			})
		) {
			// 아래는 실제 pokemonId 에 위치한 값을 불러온다
			val pokemonId = it.arguments?.getInt("pokemonId") ?: 0
			DetailScreen(pokemonId = pokemonId, onUpButtonClick = {
				navController.navigate("Home"){
					popUpTo("Home"){
						inclusive = true
					}
				}
			})
		}
	}
}