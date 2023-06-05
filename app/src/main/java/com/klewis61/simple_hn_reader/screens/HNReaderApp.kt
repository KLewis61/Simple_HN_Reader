package com.klewis61.simple_hn_reader.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.klewis61.simple_hn_reader.Destination


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HNReaderApp(navController: NavHostController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Simple HN Reader") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.MoreVert, contentDescription = "Menu")
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar() {
                val navBackEntry = navController.currentBackStackEntryAsState()
                val currentDestination = navBackEntry.value?.destination

                NavigationBarItem(
                    selected = currentDestination?.route == Destination.Home.route,
                    onClick = { navController.navigate(Destination.Home.route) },
                    icon = {
                        Icon(Icons.Filled.Home, contentDescription = "Top Stories", modifier = Modifier.size(28.dp))
                    },
                    label = { Text(text = "Top Stories") }
                )

                NavigationBarItem(
                    selected = currentDestination?.route == Destination.Favorites.route,
                    onClick = { navController.navigate(Destination.Favorites.route) },
                    icon = {
                        Icon(Icons.Filled.Star, contentDescription = "Favorites", modifier = Modifier.size(28.dp))
                    },
                    label = { Text(text = Destination.Favorites.route) }
                )

                NavigationBarItem(
                    selected = currentDestination?.route == Destination.Search.route,
                    onClick = { navController.navigate(Destination.Search.route) },
                    icon = {
                        Icon(Icons.Filled.Search, contentDescription = "Search", modifier = Modifier.size(28.dp))
                    },
                    label = { Text(text = Destination.Search.route) }
                )

                NavigationBarItem(
                    selected = currentDestination?.route == Destination.User.route,
                    onClick = { navController.navigate(Destination.User.route) },
                    icon = {
                        Icon(Icons.Filled.AccountCircle, contentDescription = "User", modifier = Modifier.size(28.dp))
                    },
                    label = { Text(text = Destination.User.route) }
                )
            }
        }
    )
    {
        NavHost(navController = navController, startDestination = Destination.Home.route) {
            composable(Destination.Home.route) { HomeScreen() }
            composable(Destination.Favorites.route) { FavoritesScreen() }
            composable(Destination.Search.route) { SearchScreen() }
            composable(Destination.User.route) { UserScreen() }
        }
    }
}