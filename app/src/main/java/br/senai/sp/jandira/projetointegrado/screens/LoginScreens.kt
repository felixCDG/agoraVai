package br.senai.sp.jandira.projetointegrado.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import br.senai.sp.jandira.foodrecipe.model.UserRegister
import br.senai.sp.jandira.foodrecipe.service.RetrofitFactory
import br.senai.sp.jandira.projetointegrado.R
import br.senai.sp.jandira.projetointegrado.model.UserLogin
import retrofit2.Callback

@Composable
fun LoginScreens(navegacao: NavHostController?) {

    var emailState = remember {
        mutableStateOf("")
    }
    var senhaState = remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()

    ){
        Image(
            painter = painterResource(R.drawable.fundooo),
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
                        text = stringResource(R.string.login),
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
                            text = stringResource(R.string.email),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            color = Color.White
                        )
                        Spacer( modifier = Modifier .height(3.dp))
                        OutlinedTextField(
                            value = emailState.value,
                            onValueChange = {
                                emailState.value = it
                            },
                            modifier = Modifier .fillMaxWidth(),
                            colors = TextFieldDefaults.colors(),
                            shape = RoundedCornerShape(10.dp),
                        )
                        Spacer( modifier = Modifier .height(7.dp))
                        Text(
                            text = stringResource(R.string.senha),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            color = Color.White
                        )
                        Spacer( modifier = Modifier .height(3.dp))
                        OutlinedTextField(
                            value = senhaState.value,
                            onValueChange = {
                                senhaState.value = it
                            },
                            modifier = Modifier .fillMaxWidth(),
                            colors = TextFieldDefaults.colors(),
                            shape = RoundedCornerShape(10.dp),
                        )

                        Spacer( modifier = Modifier .height(3.dp))
                        val textoClique2 = buildAnnotatedString {
                            // Parte clicável: "Cadastre-se"
                            pushStringAnnotation(tag = "eqsenha", annotation = "eqsenha")
                            withStyle(style = androidx.compose.ui.text.SpanStyle(color = Color.Black)) {
                                append(stringResource(R.string.esquecisenha))
                            }
                            pop()
                        }
                        ClickableText(
                            text = textoClique2,
                            modifier = Modifier.padding(horizontal = 10.dp),
                            onClick = { offset ->
                                textoClique2.getStringAnnotations(tag = "eqsenha", start = offset, end = offset)
                                    .firstOrNull()?.let {
                                        navegacao?.navigate("eqsenha")
                                    }
                            }
                        )
                        Spacer( modifier = Modifier .height(23.dp))
                        Card (
                            modifier = Modifier
                                .height(3.dp)
                                .fillMaxWidth(),
                            colors = CardDefaults.cardColors(containerColor = Color(0xff2B5235))
                        ){  }
                        Spacer( modifier = Modifier .height(19.dp))
                        Button(
                            onClick = {

                                val body = UserLogin(
                                    email = emailState.value,
                                    senha = senhaState.value
                                )
                                println(body)
                                val sendUser = RetrofitFactory()
                                    .getUserLoginService()
                                    .loginUser(body)

                                sendUser.enqueue(object : Callback<UserLogin> {
                                    override fun onResponse(call: retrofit2.Call<UserLogin>, response: retrofit2.Response<UserLogin>) {
                                        if (response.isSuccessful) {
                                            // Sucesso no cadastro
                                            Log.i("API", "Usuario logado com sucesso ${response.body()}")
                                            navegacao?.navigate("cadastro")
                                            // Redireciona para tela de login
                                        } else {
                                            // Erro no cadastro (ex: e-mail já existente, campos inválidos, etc.)
                                            Log.e("API", "Erro ao logar: ${response.code()}")
                                        }
                                    }

                                    override fun onFailure(call: retrofit2.Call<UserLogin>, t: Throwable) {
                                        // Erro de rede ou outro imprevisto
                                        Log.e("API", "Falha na requisição: ${t.message}")
                                    }
                                })

                            },
                            colors = ButtonDefaults.buttonColors(Color(0xFF9B5D27)),
                            modifier = Modifier
                                .width(1000.dp)

                        ) {
                            Text(
                                text = stringResource(R.string.finalizlogin),
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 20.sp,
                                color = Color.White
                            )
                        }
                        val textoClique = buildAnnotatedString {
                            append(stringResource(R.string.naotemconta))

                            // Parte clicável: "Cadastre-se"
                            pushStringAnnotation(tag = "cadastro", annotation = "cadastro")
                            withStyle(style = androidx.compose.ui.text.SpanStyle(color = Color.Black)) {
                                append(stringResource(R.string.cadastrese))
                            }
                            pop()
                        }

                        ClickableText(
                            text = textoClique,
                            modifier = Modifier.padding(horizontal = 37.dp),
                            onClick = { offset ->
                                textoClique.getStringAnnotations(tag = "cadastro", start = offset, end = offset)
                                    .firstOrNull()?.let {
                                        navegacao?.navigate("cadastro")
                                    }
                            }
                        )


                    }
                }
            }
        }
    }
}



@Preview
@Composable
private fun LoginScreensPreview() {
    LoginScreens(navegacao = null)
}