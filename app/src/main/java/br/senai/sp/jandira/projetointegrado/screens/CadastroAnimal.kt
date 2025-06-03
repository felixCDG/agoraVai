package br.senai.sp.jandira.projetointegrado.screens

import android.util.Log
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroAnimal(navegacao: NavHostController?) {
    val vacinado = false
    val vermifugado = false
    val castrado = false

    var nameAnimalState = remember {
        mutableStateOf("")
    }
    var dateState = remember {
        mutableStateOf("")
    }
    var pictureState = remember {
        mutableStateOf("")
    }
    var necessidadeState = remember {
        mutableStateOf("")
    }
    var idporteState = remember {
        mutableStateOf("")
    }
    var idstatusState = remember {
        mutableStateOf("")
    }
    var idracaState = remember {
        mutableStateOf("")
    }
    var idsexoState = remember {
        mutableStateOf("")
    }
    var idtemperamentoState = remember {
        mutableStateOf("")
    }
    var idespecieState = remember {
        mutableStateOf("")
    }
    var idsaudeState = remember {
        mutableStateOf("")
    }




    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xffFEFAE0))
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()

        ){
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
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
                        modifier =Modifier
                            .size(200.dp)
                    )
                }
            }

            Card (
                modifier = Modifier
                    .fillMaxSize(),
                colors = CardDefaults.cardColors(containerColor = Color(0xffD5E9D5)),
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                )
                
            ){
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(Color(0xFF9B5D27)),

                    ) {
                        Text(
                            text = stringResource(R.string.cadastroanimal),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier .height(7.dp))
                    Column {
                        Text(
                            text = stringResource(R.string.nameanimal),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                        Spacer( modifier = Modifier .height(5.dp))
                        OutlinedTextField(
                            value = nameAnimalState.value,
                            onValueChange = {
                                nameAnimalState.value = it
                            },
                            modifier = Modifier .fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                containerColor = Color(0xffA7CFAF), // 🔁 fundo branco
                                focusedBorderColor = Color.DarkGray,
                                unfocusedBorderColor = Color.Gray,

                                )
                        )
                        Spacer(modifier = Modifier .height(7.dp))
                        Text(
                            text = stringResource(R.string.especi),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                        Spacer( modifier = Modifier .height(5.dp))
                        OutlinedTextField(
                            value = idespecieState.value,
                            onValueChange = {
                                idespecieState.value = it
                            },
                            modifier = Modifier .fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                containerColor = Color(0xffA7CFAF), // 🔁 fundo branco
                                focusedBorderColor = Color.DarkGray,
                                unfocusedBorderColor = Color.Gray,

                                )
                        )
                        Spacer(modifier = Modifier .height(7.dp))
                        Text(
                            text = stringResource(R.string.sexo),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                        Spacer( modifier = Modifier .height(5.dp))
                        OutlinedTextField(
                            value = idsexoState.value,
                            onValueChange = {
                                idsexoState.value = it
                            },
                            modifier = Modifier .fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                containerColor = Color(0xffA7CFAF), // 🔁 fundo branco
                                focusedBorderColor = Color.DarkGray,
                                unfocusedBorderColor = Color.Gray,

                                )
                        )
                        Spacer(modifier = Modifier .height(7.dp))
                        Text(
                            text = "necessidade",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                        Spacer( modifier = Modifier .height(5.dp))
                        OutlinedTextField(
                            value = necessidadeState.value,
                            onValueChange = {
                                necessidadeState.value = it
                            },
                            modifier = Modifier .fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                containerColor = Color(0xffA7CFAF), // 🔁 fundo branco
                                focusedBorderColor = Color.DarkGray,
                                unfocusedBorderColor = Color.Gray,

                                )
                        )
                        Spacer(modifier = Modifier .height(7.dp))
                        Text(
                            text = stringResource(R.string.porte),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                        Spacer( modifier = Modifier .height(5.dp))
                        OutlinedTextField(
                            value = idporteState.value,
                            onValueChange = {
                                idporteState.value = it
                            },
                            modifier = Modifier .fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                containerColor = Color(0xffA7CFAF), // 🔁 fundo branco
                                focusedBorderColor = Color.DarkGray,
                                unfocusedBorderColor = Color.Gray,

                                )
                        )
                        Spacer(modifier = Modifier .height(7.dp))
                        Text(
                            text = stringResource(R.string.idade),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                        Spacer( modifier = Modifier .height(5.dp))
                        OutlinedTextField(
                            value = dateState.value,
                            onValueChange = {
                                dateState.value = it
                            },
                            modifier = Modifier .fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                containerColor = Color(0xffA7CFAF), // 🔁 fundo branco
                                focusedBorderColor = Color.DarkGray,
                                unfocusedBorderColor = Color.Gray,

                                )
                        )
                        Spacer(modifier = Modifier .height(7.dp))
                        Text(
                            text = stringResource(R.string.saude),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                        Spacer( modifier = Modifier .height(5.dp))
                        OutlinedTextField(
                            value = idsaudeState.value,
                            onValueChange = {
                                idsaudeState.value = it
                            },
                            modifier = Modifier .fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                containerColor = Color(0xffA7CFAF), // 🔁 fundo branco
                                focusedBorderColor = Color.DarkGray,
                                unfocusedBorderColor = Color.Gray,

                                )
                        )
                        Spacer(modifier = Modifier .height(7.dp))
                        Text(
                            text = "Temperamento",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                        Spacer( modifier = Modifier .height(5.dp))
                        OutlinedTextField(
                            value = idtemperamentoState.value,
                            onValueChange = {
                                idtemperamentoState.value = it
                            },
                            modifier = Modifier .fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                containerColor = Color(0xffA7CFAF), // 🔁 fundo branco
                                focusedBorderColor = Color.DarkGray,
                                unfocusedBorderColor = Color.Gray,

                                )
                        )

                        Spacer(modifier = Modifier .height(7.dp))
                        Text(
                            text = "Carregue as Imagens do Animal",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                        Spacer( modifier = Modifier .height(5.dp))
                        OutlinedTextField(
                            value = pictureState.value,
                            onValueChange = {
                                pictureState.value = it
                            },
                            modifier = Modifier .fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                containerColor = Color(0xffA7CFAF), // 🔁 fundo branco
                                focusedBorderColor = Color.DarkGray,
                                unfocusedBorderColor = Color.Gray,

                                )
                        )
                        Spacer(modifier = Modifier .height(7.dp))
                        Text(
                            text = "Raça do Animal",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                        Spacer( modifier = Modifier .height(5.dp))
                        OutlinedTextField(
                            value = idracaState.value,
                            onValueChange = {
                                idracaState.value = it
                            },
                            modifier = Modifier .fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                containerColor = Color(0xffA7CFAF), // 🔁 fundo branco
                                focusedBorderColor = Color.DarkGray,
                                unfocusedBorderColor = Color.Gray,

                                )
                        )
                        Spacer(modifier = Modifier .height(7.dp))
                        Text(
                            text = "Status do Animal",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                        Spacer( modifier = Modifier .height(5.dp))
                        OutlinedTextField(
                            value = idstatusState.value,
                            onValueChange = {
                                idstatusState.value = it
                            },
                            modifier = Modifier .fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                containerColor = Color(0xffA7CFAF), // 🔁 fundo branco
                                focusedBorderColor = Color.DarkGray,
                                unfocusedBorderColor = Color.Gray,

                                )
                        )
                        Spacer( modifier = Modifier .height(27.dp))
                        Card (
                            modifier = Modifier
                                .height(3.dp)
                                .fillMaxWidth(),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFF9B5D27))
                        ){  }
                        Spacer( modifier = Modifier .height(23.dp))
                        Button(
                            onClick = {
                                val body = PetRegister(
                                    nome = nameAnimalState.value,
                                    dataNascimento = dateState.value,
                                    foto = pictureState.value,
                                    necessidades = necessidadeState.value,
                                    idPorte = idporteState.value.toIntOrNull() ?: 0,
                                    idStatus = idstatusState.value.toIntOrNull() ?: 0,
                                    idRaca = idracaState.value.toIntOrNull() ?: 0,
                                    idSexo = idsexoState.value.toIntOrNull() ?: 0,
                                    idTemperamento = idtemperamentoState.value.toIntOrNull() ?: 0,
                                    idEspecie =  idespecieState.value.toIntOrNull() ?: 0,
                                    idSaude = idsaudeState.value.toIntOrNull() ?: 0
                                )
                                println(body)

                                val sendPet = RetrofitFactory()
                                    .getPetRegisterService()
                                    .cadastroPet(body)

                                sendPet.enqueue(object : Callback<PetRegister>{
                                    override fun onResponse (call: Call<PetRegister>, response: Response<PetRegister>){
                                        if (response.isSuccessful){

                                            Log.i("API", "Pet cadastrado com sucesso ${response.body()}")
                                        }else{
                                            Log.e("API", "Erro ao cadastrar: ${response.code()}")
                                        }
                                    }

                                    override  fun onFailure(call: Call<PetRegister>, t: Throwable){
                                        Log.e("API", "Falha na requisição: ${t.message}")
                                    }

                                })

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
private fun CadastroAnimalPreview() {
    CadastroAnimal(navegacao = null)
}