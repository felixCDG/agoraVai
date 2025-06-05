package br.senai.sp.jandira.projetointegrado.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage


@Composable
fun CardPet(

    foto: String = "URL da imagem",
    name: String = "Nome do Pet",

) {
    Card (
        modifier = Modifier
            .width(150.dp)
            .height(160.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFB24E))

    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Card(
                modifier = Modifier
                    .height(80.dp)
                    .width(125.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1D79C0)),


            ) {
                AsyncImage(
                    model = foto,
                    contentDescription = ""
                )
            }
            Spacer(modifier = Modifier .height(7.dp))
            Column (
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.Start
            ){
                Text(
                    text = name,
                    fontWeight = FontWeight.ExtraBold

                )
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Text(
                        text = "localização: ",
                        fontSize = 10.sp
                    )
                }
            }

        }
    }

}

@Preview
@Composable
private fun CardPetPreview() {
    CardPet()
}