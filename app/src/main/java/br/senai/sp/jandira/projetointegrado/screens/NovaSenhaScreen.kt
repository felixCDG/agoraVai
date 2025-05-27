package br.senai.sp.jandira.projetointegrado.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import br.senai.sp.jandira.projetointegrado.R

@Composable
fun NovaSenhaScreen(navegacao: NavHostController?) {

    Box(
        modifier = Modifier
            .fillMaxSize()

    ){
        Image(
            painter = painterResource(R.drawable.fundu),
            contentDescription = " Backgroud ",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x88000000))
        )

        Column (
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "",
                modifier = Modifier
                    .size(320.dp)
            )
            Spacer(modifier = Modifier .height(37.dp))
            Box(
                modifier = Modifier
                    .width(330.dp)
                    .padding(top = 16.dp) // espaço para o botão sobreposto
            ) {
                // Botão "CADASTRO" sobreposto
                Box(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .offset(y = (-20).dp)
                        .background(color = Color(0xFF9B5D27), shape = RoundedCornerShape(12.dp))
                        .padding(horizontal = 35.dp, vertical = 8.dp)
                        .zIndex(1f)
                        .height(22.dp),

                    ) {
                    Text(
                        text = stringResource(R.string.novasenhaT),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }

                // Card do formulário
                Card(
                    modifier = Modifier

                        .fillMaxWidth()
                        .align(Alignment.TopCenter),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    colors = CardDefaults.cardColors(Color(0x69FFE8C9))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(35.dp)
                    ) {
                        Text(
                            text = " Digite sua nova senha \n" +
                                    "   e confirme a mesma ",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            color = Color.White,
                            modifier = Modifier
                                .padding(horizontal = 20.dp )
                        )
                        Spacer(modifier = Modifier .height(16.dp))
                        Text(
                            text = stringResource(R.string.novasenha),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 18.sp,
                            color = Color.White
                        )
                        Spacer( modifier = Modifier .height(5.dp))
                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            modifier = Modifier .fillMaxWidth(),
                            colors = TextFieldDefaults.colors(),
                            shape = RoundedCornerShape(10.dp),
                        )
                        Spacer( modifier = Modifier .height(7.dp))
                        Text(
                            text = stringResource(R.string.confirmasenha),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 18.sp,
                            color = Color.White
                        )
                        Spacer( modifier = Modifier .height(3.dp))
                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            modifier = Modifier .fillMaxWidth(),
                            colors = TextFieldDefaults.colors(),
                            shape = RoundedCornerShape(10.dp),
                        )
                        Spacer( modifier = Modifier .height(23.dp))
                        Card (
                            modifier = Modifier
                                .height(3.dp)
                                .fillMaxWidth(),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFF9B5D27))
                        ){  }
                        Spacer( modifier = Modifier .height(19.dp))
                        Button(
                            onClick = {
                                navegacao?.navigate("login")
                            },
                            colors = ButtonDefaults.buttonColors(Color(0xFF9B5D27)),
                            modifier = Modifier
                                .width(1000.dp)

                        ) {
                            Text(
                                text = stringResource(R.string.next),
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 20.sp,
                                color = Color.White
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
private fun NovaSenhaScreenPreview() {
    NovaSenhaScreen(navegacao = null)
}