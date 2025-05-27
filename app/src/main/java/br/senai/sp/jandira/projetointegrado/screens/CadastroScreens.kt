package br.senai.sp.jandira.projetointegrado.screens



import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import  br.senai.sp.jandira.projetointegrado.R

@Composable
fun CadastroScreen(navegacao: NavHostController?) {



    Box(
        modifier = Modifier
            .fillMaxSize()

    ){
        Image(
            painter = painterResource(R.drawable.fundo),
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
                    .size(270.dp)
            )

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
                        .height(25.dp),

                ) {
                    Text(
                        text = stringResource(R.string.cadastro),
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
                            text = stringResource(R.string.nome),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
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
                            text =stringResource(R.string.email),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
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
                        Spacer( modifier = Modifier .height(7.dp))
                        Text(
                            text =stringResource(R.string.senha),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
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
                        Spacer( modifier = Modifier .height(7.dp))
                        Text(
                            text = stringResource(R.string.confirmasenha),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
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
                        Spacer( modifier = Modifier .height(7.dp))
                        Text(
                            text = stringResource(R.string.palavrachave),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
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
                        Spacer( modifier = Modifier .height(7.dp))
                        Text(
                            text = stringResource(R.string.idade),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
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
                        Spacer( modifier = Modifier .height(7.dp))
                        Text(
                            text = stringResource(R.string.cpf),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
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
                        Spacer( modifier = Modifier .height(7.dp))
                        Text(
                            text = stringResource(R.string.contato),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
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
                        Spacer( modifier = Modifier .height(7.dp))
                        Text(
                            text = stringResource(R.string.contatoreserva),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
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
                        Spacer( modifier = Modifier .height(7.dp))
                        Text(
                            text = stringResource(R.string.estado),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            color = Color.White
                        )
                        Spacer( modifier = Modifier .height(3.dp))
                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            modifier = Modifier .fillMaxWidth(),
                            colors = TextFieldDefaults.colors(),
                            shape = RoundedCornerShape(10.dp),
                            trailingIcon = {
                                IconButton(onClick = {}) {
                                    Icon(
                                        imageVector = Icons.Default.KeyboardArrowDown,
                                        contentDescription = "",
                                        tint = Color.Black
                                    )
                                }
                            }
                        )
                        Spacer( modifier = Modifier .height(7.dp))
                        Text(
                            text = stringResource(R.string.cep),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            color = Color.White
                        )
                        Spacer( modifier = Modifier .height(3.dp))
                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            modifier = Modifier .fillMaxWidth(),
                            colors = TextFieldDefaults.colors(),
                            shape = RoundedCornerShape(10.dp),
                            trailingIcon = {
                                IconButton(onClick = {}) {
                                    Icon(
                                        imageVector = Icons.Default.KeyboardArrowDown,
                                        contentDescription = "",
                                        tint = Color.Black
                                    )
                                }
                            }
                        )
                        Spacer( modifier = Modifier .height(7.dp))
                        Text(
                            text = stringResource(R.string.qualseuinterrese),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            color = Color.White
                        )
                        Spacer( modifier = Modifier .height(3.dp))
                        Card (
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp),
                            border = BorderStroke( width = 1.dp, Color.Black)
                        ){
                            Column (
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(7.dp)
                            ){
                                Row (
                                    modifier = Modifier
                                        .fillMaxWidth()
                                ){
                                    Icon(
                                        imageVector = Icons.Default.CheckCircle,
                                        contentDescription = ""
                                    )
                                    Text(
                                        text = stringResource(R.string.qadotar),
                                        fontSize = 15.sp,
                                        modifier = Modifier
                                            .padding(1.dp)

                                    )
                                    Spacer( modifier = Modifier .padding(horizontal = 5.dp))
                                    Icon(
                                        imageVector = Icons.Default.CheckCircle,
                                        contentDescription = ""
                                    )
                                    Text(
                                        text = stringResource(R.string.qdivulga),
                                        fontSize = 15.sp,
                                        modifier = Modifier
                                            .padding(1.dp)

                                    )
                                }

                                Spacer( modifier = Modifier .height(6.dp))
                                Row (
                                    modifier = Modifier
                                        .fillMaxSize()
                                ){
                                    Icon(
                                        imageVector = Icons.Default.CheckCircle,
                                        contentDescription = ""
                                    )
                                    Text(
                                        text = stringResource(R.string.fazpartedeong),
                                        fontSize = 15.sp,
                                        modifier = Modifier
                                            .padding(1.dp)

                                    )
                                }

                            }
                        }

                        Spacer( modifier = Modifier .height(7.dp))
                        Text(
                            text = stringResource(R.string.sefazpartedeong),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 15.sp,
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

                        Spacer( modifier = Modifier .height(27.dp))
                        Card (
                            modifier = Modifier
                                .height(3.dp)
                                .fillMaxWidth(),
                            colors = CardDefaults.cardColors(containerColor = Color(0xff2B5235))
                        ){  }
                        Spacer( modifier = Modifier .height(23.dp))
                        Button(
                            onClick = {
                                navegacao?.navigate("login")
                            },
                            colors = ButtonDefaults.buttonColors(Color(0xFF9B5D27)),
                            modifier = Modifier
                               .width(1000.dp)

                        ) {
                            Text(
                                text = stringResource(R.string.finalizarcadastro),
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
private fun CadastroScreensPreview() {
    CadastroScreen(navegacao = null)
}