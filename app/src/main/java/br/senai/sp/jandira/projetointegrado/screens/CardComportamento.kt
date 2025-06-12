package br.senai.sp.jandira.projetointegrado.screens



import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Cardcomportamento(
    comportamentoText : String = "api"
){
    Row(
        modifier = Modifier
            .background(Color.Transparent)
    ) {
        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(Color(0xffDA8940)),
            border = BorderStroke(width = 1.dp, color = Color.Black),
            modifier = Modifier
                .padding(end = 10.dp)

        ) {
            Text(
                text = comportamentoText,
                color = Color.Black,
                fontSize = 16.sp
            )
        }

    }
}


@Preview(showSystemUi = true)
@Composable
private fun CardComportamento() {
    Cardcomportamento()
}