package br.senai.sp.jandira.projetointegrado.screens

import android.util.Log
import android.widget.ImageButton
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
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
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
import br.senai.sp.jandira.foodrecipe.model.UserRegister
import br.senai.sp.jandira.foodrecipe.service.RetrofitFactory
import br.senai.sp.jandira.projetointegrado.R
import retrofit2.Callback

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroAnimal(modifier: Modifier = Modifier) {
    val vacinado = false
    val vermifugado = false
    val castrado = false

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
                            value = "",
                            onValueChange = {},
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
                            value = "",
                            onValueChange = {},
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
                            value = "",
                            onValueChange = {},
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
                            value = "",
                            onValueChange = {},
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
                            value = "",
                            onValueChange = {},
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
                            text = stringResource(R.string.estado),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                        Spacer( modifier = Modifier .height(5.dp))
                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            modifier = Modifier .fillMaxWidth() ,
                            shape = RoundedCornerShape(10.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                containerColor = Color(0xffA7CFAF), // 🔁 fundo branco
                                focusedBorderColor = Color.DarkGray,
                                unfocusedBorderColor = Color.Gray,

                            )

                        )
                        Spacer(modifier = Modifier .height(7.dp))
                        Text(
                            text = stringResource(R.string.cidade),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                        Spacer( modifier = Modifier .height(5.dp))
                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            modifier = Modifier .fillMaxWidth() ,
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
                        Card (
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xffA7CFAF))
                        ){
                            Column(

                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Checkbox(
                                        checked = true,
                                        onCheckedChange = {}
                                    )
                                    Text(text = "vacinado", fontSize = 18.sp)
                                }
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Checkbox(
                                        checked = true,
                                        onCheckedChange = {},

                                    )
                                    Text(text = "vermífugado", fontSize = 18.sp)
                                }
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Checkbox(
                                        checked = true,
                                        onCheckedChange = {},

                                    )
                                    Text(text = "castrado", fontSize = 18.sp)
                                }
                            }
                        }
                        Spacer(modifier = Modifier .height(7.dp))
                        Text(
                            text = stringResource(R.string.saude),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                        Spacer( modifier = Modifier .height(5.dp))
                        Card (
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xffA7CFAF))
                        ){
                            Column (
                                modifier = Modifier
                                    .fillMaxSize(),

                            ){  }
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
    CadastroAnimal()
}