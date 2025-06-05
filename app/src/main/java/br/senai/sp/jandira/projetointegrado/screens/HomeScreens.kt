package br.senai.sp.jandira.projetointegrado.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PersonPin
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.foodrecipe.service.RetrofitFactory
import br.senai.sp.jandira.projetointegrado.R
import br.senai.sp.jandira.projetointegrado.model.IdButtons
import br.senai.sp.jandira.projetointegrado.model.PetRegister
import br.senai.sp.jandira.projetointegrado.model.Pets
import br.senai.sp.jandira.projetointegrado.model.ResultPet
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navegacao: NavHostController?) {

    //devolvidas pela API
    var PetList = remember {
        mutableStateOf(listOf<Pets>())
    }

    // Obter o dados da Retrofit
    var callPet = RetrofitFactory()
        .getPetService()
        .listAll()

    //Enviar a requisição
    callPet.enqueue(object : Callback<ResultPet>{
        override fun onResponse(p0: Call<ResultPet>, p1: Response<ResultPet>) {
            PetList.value = p1.body()!!.pets
        }

        override fun onFailure(call: Call<ResultPet>, t: Throwable) {
            Log.e("HomeScreen", "Erro na requisição: ${t.message}")
            // Se quiser, pode mostrar algo na UI, mas como é Compose, talvez precise usar um estado para isso.
        }


    })


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xffFEFAE0))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xff244B2E)),
                ) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "",
                        tint = Color(0xFFFFFFFF),

                        )
                }
                Image(
                    painter = painterResource(R.drawable.logm),
                    contentDescription = "",
                    modifier = Modifier
                        .size(100.dp)
                )
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Default.PersonPin,
                        contentDescription = "",
                        modifier = Modifier
                            .size(200.dp)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            ){
                Image(
                    painter = painterResource(R.drawable.baner),
                    contentDescription = "",
                    modifier = Modifier
                        .size(500.dp),
                    contentScale = ContentScale.FillBounds
                )
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(13.dp),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Encontre aqui \nseu novo \namiguinho!!",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 30.sp,
                        color = Color(0xffBC6C25)
                    )
                    Spacer(modifier = Modifier .height(4.dp))
                    Text(
                        text = "De um novo lar a um bixinho,\n" +
                                "ou use nosso site para divulgar um pet!",
                        fontSize = 11.sp,
                        color = Color(0xFFFFFFFF)
                    )

                }
            }

            Card(
                modifier = Modifier
                    .fillMaxSize(),
                colors = CardDefaults.cardColors(containerColor = Color(0xffFEFAE0)),
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                )

            ) {
                Column (
                    modifier = Modifier
                        .fillMaxSize(),
                ){
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ){
                        Image(
                            painter = painterResource(R.drawable.patsfundo),
                            contentDescription = "",
                            modifier = Modifier
                                .size(900.dp),
                            contentScale = ContentScale.Crop
                        )
                        Column (
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 7.dp),
                            horizontalAlignment = Alignment.End
                        ){
                            Button(
                                onClick = {},
                                colors = ButtonDefaults.buttonColors(Color(0xffA46731)),
                                border = BorderStroke(2.dp, Color(0xff0000000)),
                                shape = RoundedCornerShape(
                                    size = 0.dp
                                )
                            ) {
                                Icon(
                                    imageVector = Icons.Default.FilterAlt,
                                    contentDescription = "",
                                    tint = Color(0xFFD9D9D9)
                                )
                                Text(
                                    text = "FILTRAR",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 15.sp,
                                    color = Color(0xFFFFFFFF)

                                )
                            }
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {
                            Spacer(modifier = Modifier.height(45.dp))

                            LazyVerticalGrid(
                                columns = GridCells.Fixed(2),
                                modifier = Modifier.fillMaxSize(),
                                horizontalArrangement = Arrangement.spacedBy(12.dp),
                                verticalArrangement = Arrangement.spacedBy(12.dp),
                                content = {
                                    items(PetList.value){
                                        CardPet(
                                            foto = it.foto,
                                            name = it.nome
                                        )
                                    }
                                }
                            )
                        }

                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(navegacao = null)
}