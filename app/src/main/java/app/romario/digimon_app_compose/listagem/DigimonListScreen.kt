package app.romario.digimon_app_compose.listagem


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import app.romario.digimon_app_compose.response.DigimonListItem
import coil.compose.rememberImagePainter

@Composable
fun DigimonListScreen(viewModel: DigimonListViewModel = hiltViewModel()) {

    LazyColumn(){
        itemsIndexed(viewModel.digimonList.value){
            i, item ->
                showDigimon(digimon = item)
        }
    }


}

@Composable
fun showDigimon(digimon: DigimonListItem){
    
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)) {

        Image(painter = rememberImagePainter(digimon.img), contentDescription = "",
        modifier = Modifier.height(80.dp))

        Column(modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center) {
                Text(text = digimon.name, modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp)
        }
        
    }
    
}