package br.senai.sp.jandira.projetointegrado.screens

import android.content.Context
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.KeyboardArrowDown
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.foodrecipe.service.AzureUploadService.uploadImageToAzure
import br.senai.sp.jandira.foodrecipe.service.RetrofitFactory
import br.senai.sp.jandira.projetointegrado.R
import br.senai.sp.jandira.projetointegrado.model.ComportamentoItem
import br.senai.sp.jandira.projetointegrado.model.IdButtons
import br.senai.sp.jandira.projetointegrado.model.PetRegister
import br.senai.sp.jandira.projetointegrado.model.SaudeItem
import coil.compose.AsyncImage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroAnimal(navegacao: NavHostController?) {

    var isVacinado = remember { mutableStateOf(false) }
    var isVermifugado = remember { mutableStateOf(false) }
    var isCastrado = remember { mutableStateOf(false) }

    val vacinadoId = 1
    val vermifugadoId = 2
    val castradoId = 3

    // 1) Estado para armazenar o URI da imagem escolhida
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    // 2) Estado para armazenar a URL retornada pelo Azure
    var imageUrl by remember { mutableStateOf<String?>(null) }

    // 3) Launcher para pegar o arquivo via Galeria
    val pickImageLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            imageUri = uri
        }

    val context = LocalContext.current


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
    var idenderecoState = remember {
        mutableStateOf("")
    }
    val selectedPorteId = remember {
        mutableStateOf(0)
    }
    var idstatusState = remember {
        mutableStateOf("")
    }
    var idracaState = remember {
        mutableStateOf("")
    }
    val selectedSexoId = remember {
        mutableStateOf(0)
    }
    val selectedTemperamentoId = remember {
        mutableStateOf(0)
    }
    val selectedEspecieId = remember {
        mutableStateOf(0)
    }
    val saudeSelecionada = remember {
        mutableStateListOf<Int>()
    }

    val comportamentosSelecionados = remember {
        mutableStateListOf<Int>()
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
                        Card (
                            modifier = Modifier
                                .fillMaxWidth(),
                            colors = CardDefaults.cardColors(containerColor = Color(0xffA7CFAF)),
                            border = BorderStroke(1.dp, color = Color(0xFF939393))
                        ){
                            val especies = listOf(
                                Pair("Cachorro", 1),
                                Pair("Gato", 2),
                                Pair("Pássaro", 3),
                                Pair("Outro", 4)
                            )

                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(6.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                for (row in 0..1) {
                                    Row(
                                        horizontalArrangement = Arrangement.SpaceEvenly,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        for (col in 0..1) {
                                            val index = row * 2 + col
                                            if (index < especies.size) {
                                                val (label, id) = especies[index]
                                                Button(
                                                    onClick = {
                                                        selectedEspecieId.value = id
                                                    },
                                                    shape = RoundedCornerShape(30.dp),
                                                    colors = ButtonDefaults.buttonColors(
                                                        containerColor = if (selectedEspecieId.value == id)
                                                            Color(0xFFC4ECBA)
                                                        else
                                                            Color(0x0F174202)
                                                    ),
                                                    modifier = Modifier
                                                        .padding(4.dp)
                                                        .height(45.dp)
                                                ) {
                                                    Text(text = label, color = Color.Black)
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                        }
                        Spacer(modifier = Modifier .height(7.dp))
                        Text(
                            text = stringResource(R.string.sexo),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                        Spacer( modifier = Modifier .height(5.dp))
                        Card (
                            modifier = Modifier
                                .fillMaxWidth(),
                            colors = CardDefaults.cardColors(containerColor = Color(0xffA7CFAF)),
                            border = BorderStroke(1.dp, color = Color(0xFF939393))
                        ){
                            Column (
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(6.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){

                                val sexo = listOf(
                                    Pair("Macho", 2),
                                    Pair("Femea", 3),
                                )

                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(3.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    for (row in 0..1) {
                                        Row(
                                            horizontalArrangement = Arrangement.SpaceEvenly,
                                            modifier = Modifier.fillMaxWidth()
                                        ) {
                                            for (col in 0..1) {
                                                val index = row * 2 + col
                                                if (index < sexo.size) {
                                                    val (label, id) = sexo[index]
                                                    Button(
                                                        onClick = {
                                                            selectedSexoId.value = id
                                                        },
                                                        shape = RoundedCornerShape(30.dp),
                                                        colors = ButtonDefaults.buttonColors(
                                                            containerColor = if (selectedSexoId.value == id)
                                                                Color(0xFFC4ECBA)
                                                            else
                                                                Color(0x0F174202)
                                                        ),
                                                        modifier = Modifier
                                                            .padding(4.dp)
                                                            .height(45.dp)
                                                    ) {
                                                        Text(text = label, color = Color.Black)
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        Spacer(modifier = Modifier .height(7.dp))
                        Text(
                            text = "Necessidades",
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
                        Card (
                            modifier = Modifier
                                .fillMaxWidth(),
                            colors = CardDefaults.cardColors(containerColor = Color(0xffA7CFAF)),
                            border = BorderStroke(1.dp, color = Color(0xFF939393))
                        ){
                            Column (
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(1.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                val porte = listOf(
                                    Pair("Grande", 1),
                                    Pair("Medio", 2),
                                    Pair("Pequeno", 3),
                                )

                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(3.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    for (row in 0..1) {
                                        Row(
                                            horizontalArrangement = Arrangement.SpaceEvenly,
                                            modifier = Modifier.fillMaxWidth()
                                        ) {
                                            for (col in 0..1) {
                                                val index = row * 2 + col
                                                if (index < porte.size) {
                                                    val (label, id) = porte[index]
                                                    Button(
                                                        onClick = {
                                                            selectedPorteId.value = id
                                                        },
                                                        shape = RoundedCornerShape(30.dp),
                                                        colors = ButtonDefaults.buttonColors(
                                                            containerColor = if (selectedPorteId.value == id)
                                                                Color(0xFFC4ECBA)
                                                            else
                                                                Color(0x0F174202)
                                                        ),
                                                        modifier = Modifier
                                                            .padding(4.dp)
                                                            .height(45.dp)
                                                    ) {
                                                        Text(text = label, color = Color.Black)
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
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
                            text = stringResource(R.string.cep),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                        Spacer( modifier = Modifier .height(5.dp))
                        OutlinedTextField(
                            value = idenderecoState.value,
                            onValueChange = {
                                idenderecoState.value = it
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
                            text = "Comportamento",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                        Spacer( modifier = Modifier .height(5.dp))
                        Card (
                            modifier = Modifier
                                .fillMaxWidth(),
                            colors = CardDefaults.cardColors(containerColor = Color(0xffA7CFAF)),
                            border = BorderStroke(1.dp, color = Color(0xFF939393))
                        ){
                            Column (
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(1.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){

                                val buttonColors = listOf(
                                    remember { mutableStateOf(false) },
                                    remember { mutableStateOf(false) },
                                    remember { mutableStateOf(false) },
                                    remember { mutableStateOf(false) },

                                    )
                                val labels = listOf(
                                    "Gentil", "Brincalhao",
                                    "Medroso", "Independente"
                                )
                                for (row in 0..2) {
                                    Row(
                                        horizontalArrangement = Arrangement.SpaceEvenly,
                                        modifier = Modifier.fillMaxWidth()
                                    ){
                                        for (col in 0..1) {
                                            val index = row * 2 + col
                                            if (index < labels.size) {
                                                val isSelected = buttonColors[index]
                                                Button(
                                                    onClick = {
                                                        val idComportamento = index + 1 // Supondo que 1 = Gentil, 2 = Brincalhão, etc.
                                                        if (comportamentosSelecionados.contains(idComportamento)) {
                                                            comportamentosSelecionados.remove(idComportamento)
                                                        } else {
                                                            comportamentosSelecionados.add(idComportamento)
                                                        }
                                                        isSelected.value = !isSelected.value
                                                    },
                                                    shape = RoundedCornerShape(30.dp),
                                                    colors = ButtonDefaults.buttonColors(
                                                        containerColor = if (isSelected.value) Color(
                                                            0xFFC4ECBA
                                                        ) else Color(0x0F174202)
                                                    ),
                                                    modifier = Modifier
                                                        .padding(4.dp)
                                                        .height(45.dp)
                                                ) {
                                                    Text(text = labels[index], color = Color.Black)
                                                }
                                            }
                                        }
                                    }
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
                            colors = CardDefaults.cardColors(containerColor = Color(0xffA7CFAF)),
                            border = BorderStroke(1.dp, color = Color(0xFF939393))
                        ){
                            Column(

                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Checkbox(
                                        checked = isVacinado.value,
                                        onCheckedChange = {
                                            isVacinado.value = it
                                            if (it) saudeSelecionada.add(vacinadoId) else saudeSelecionada.remove(vacinadoId)
                                        }
                                    )

                                    Text(text = "vacinado", fontSize = 18.sp)
                                }

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Checkbox(
                                        checked = isVermifugado.value,
                                        onCheckedChange = {
                                            isVermifugado.value = it
                                            if (it) saudeSelecionada.add(vermifugadoId) else saudeSelecionada.remove(vermifugadoId)
                                        }
                                    )

                                    Text(text = "vermífugado", fontSize = 18.sp)
                                }

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Checkbox(
                                        checked = isCastrado.value,
                                        onCheckedChange = {
                                            isCastrado.value = it
                                            if (it) saudeSelecionada.add(castradoId) else saudeSelecionada.remove(castradoId)
                                        }
                                    )

                                    Text(text = "castrado", fontSize = 18.sp)
                                }
                            }
                        }
                        Spacer(modifier = Modifier .height(7.dp))
                        Text(
                            text = "Temperamento",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                        Spacer( modifier = Modifier .height(5.dp))
                        Card (
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(3.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xffA7CFAF)),
                            border = BorderStroke(1.dp, color = Color(0xFF939393))
                        ){
                            Column (
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(5.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                val temperamento = listOf(
                                    Pair("Bravo", 2),
                                    Pair("Calmo", 1),
                                    Pair("Alegre", 3),
                                )

                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(3.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    for (row in 0..1) {
                                        Row(
                                            horizontalArrangement = Arrangement.SpaceEvenly,
                                            modifier = Modifier.fillMaxWidth()
                                        ) {
                                            for (col in 0..1) {
                                                val index = row * 2 + col
                                                if (index < temperamento.size) {
                                                    val (label, id) = temperamento[index]
                                                    Button(
                                                        onClick = {
                                                            selectedTemperamentoId.value = id
                                                        },
                                                        shape = RoundedCornerShape(30.dp),
                                                        colors = ButtonDefaults.buttonColors(
                                                            containerColor = if (selectedTemperamentoId.value == id)
                                                                Color(0xFFC4ECBA)
                                                            else
                                                                Color(0x0F174202)
                                                        ),
                                                        modifier = Modifier
                                                            .padding(4.dp)
                                                            .height(45.dp)
                                                    ) {
                                                        Text(text = label, color = Color.Black)
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

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
                            onValueChange = { },
                            shape = RoundedCornerShape(10.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                containerColor = Color(0xffA7CFAF), // 🔁 fundo branco
                                focusedBorderColor = Color.DarkGray,
                                unfocusedBorderColor = Color.Gray,

                                ),
                            label = {
                                Text(
                                    text = "Imagem",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color(0xFF000000)
                                )
                            },
                            leadingIcon = {
                                Icon(imageVector = Icons.Default.Image,
                                    contentDescription = "",
                                    tint = Color(0xFF000000),
                                    modifier = Modifier
                                        .padding(start = 10.dp)
                                        .size(40.dp)
                                    )
                            },
                            enabled = false,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    pickImageLauncher.launch("image/*")
                                }
                        )
                        imageUri?.let { uri ->
                            AsyncImage(
                                model = uri,
                                contentDescription = "Imagem Selecionada",
                                modifier = Modifier
                                    .padding(vertical = 10.dp, horizontal = 15.dp)
                                    .fillMaxWidth()
                                    .border(2.dp, Color(0x80241508))
                            )
                        }
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

                                ),
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
                                CoroutineScope(Dispatchers.IO).launch {
                                    try {
                                        // 2) Chama a sua função de upload e aguarda a URL
                                        val urlRetornada = uploadImageToAzure(context, imageUri!!)

                                        withContext(Dispatchers.Main) {
                                            pictureState.value = urlRetornada
                                        }

                                        val body = PetRegister(
                                            nome = nameAnimalState.value,
                                            dataNascimento = dateState.value,
                                            foto = pictureState.value,
                                            necessidades = necessidadeState.value,
                                            idEndereco = idenderecoState.value.toIntOrNull() ?: 0,
                                            idPorte = selectedPorteId.value,
                                            idStatus = idstatusState.value.toIntOrNull() ?: 0,
                                            idRaca = idracaState.value.toIntOrNull() ?: 0,
                                            idSexo = selectedSexoId.value,
                                            idTemperamento = selectedTemperamentoId.value,
                                            idEspecie = selectedEspecieId.value,
                                            comportamento = comportamentosSelecionados.map { ComportamentoItem(it) },
                                            saude = saudeSelecionada.map { SaudeItem(it) },




                                            )
                                        println(body)

                                        val sendPet = RetrofitFactory()
                                            .getPetRegisterService()
                                            .cadastroPet(body)

                                        sendPet.enqueue(object : Callback<PetRegister>{
                                            override fun onResponse (call: Call<PetRegister>, response: Response<PetRegister>){
                                                if (response.isSuccessful){

                                                    Log.i("API", "Pet cadastrado com sucesso ${response.body()}")
                                                    navegacao?.navigate("home")
                                                }else{
                                                    Log.e("API", "Erro ao cadastrar: ${response.code()}")
                                                    navegacao?.navigate("home")
                                                }
                                            }

                                            override  fun onFailure(call: Call<PetRegister>, t: Throwable){
                                                Log.e("API", "Falha na requisição: ${t.message}")
                                            }

                                        })
                                        
                                        // 3) Volta na Main e guarda a URL num estado para usar depois
                                        withContext(Dispatchers.Main) {
                                            imageUrl = urlRetornada
                                        }
                                    } catch (e: Exception) {
                                        Log.e("ExemploEnvio", "Falha no upload: ${e.message}")
                                        withContext(Dispatchers.Main) {
                                            Toast.makeText(context, "Erro no upload", Toast.LENGTH_SHORT).show()
                                        }
                                    }
                                }
                                
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

val especies = listOf(
    Pair("Grande", 1),
    Pair("Medio", 2),
    Pair("Pequeno", 3),
)


