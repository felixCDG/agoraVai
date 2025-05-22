package br.senai.sp.jandira.projetointegrado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.projetointegrado.screens.CadastroScreen
import br.senai.sp.jandira.projetointegrado.screens.LoginScreens
import br.senai.sp.jandira.projetointegrado.ui.theme.ProjetoIntegradoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navegacao = rememberNavController()
            NavHost(
                navController = navegacao,
                startDestination = "Home"
            ){
                composable(route = "login"){ LoginScreens(navegacao) }
                composable(route = "cadastro"){ CadastroScreen(navegacao) }
            }

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProjetoIntegradoTheme {
        Greeting("Android")
    }
}