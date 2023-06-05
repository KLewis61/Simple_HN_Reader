package com.klewis61.simple_hn_reader.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.klewis61.simple_hn_reader.R
import com.klewis61.simple_hn_reader.data.Story
import com.klewis61.simple_hn_reader.viewModel.HomeScreenUiState

@Composable
fun HomeScreen(navController: NavController, homeScreenUiState: HomeScreenUiState, retryAction:() -> Unit) {
    when (homeScreenUiState) {
        is HomeScreenUiState.Loading -> LoadingScreen()
        is HomeScreenUiState.Success -> HomeScreenContent(homeScreenUiState.stories)
        is HomeScreenUiState.Error -> ErrorScreen(retryAction)
    }

}

@Composable
fun LoadingScreen(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Image(modifier = Modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = "Loading")
    }
}

@Composable
fun ErrorScreen(retryAction: () -> Unit){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "An error occurred", fontSize = 20.sp)
            Button(onClick = retryAction){
                Text(text = "Retry")
            }
        }
    }
}


@Composable
fun HomeScreenContent(stories: List<Story>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(4.dp)
    ){
       items(items = stories, key = {story ->story.objectID}){
           StoryCard(story = it)
       }
    }
}


@Composable
fun StoryCard(story:Story,modifier: Modifier = Modifier){
    Column(modifier = modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(8.dp))
        .clickable {

            }
        .padding(8.dp)
    ) {
        Text(text = story.title ?: "No title", fontSize = 20.sp,fontWeight = FontWeight.Bold)
        Text(text = story.num_comments.toString() + " comments", fontSize = 14.sp)
    }
}