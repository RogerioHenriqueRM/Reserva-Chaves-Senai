package com.example.controlhechavesmig.ui.telas


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext


@OptIn(ExperimentalMaterial3Api::class) // Permite usar APIs do Material 3
@Composable // componente
fun LoginScreen(
    onContinueClicked: (String) -> Unit,
) {
    var email by remember { mutableStateOf("") }

    // Email de teste
    val correctEmail = "test@domain.com"

    // Pega o contexto atual (texto) e mostra um Toast com "email incorreto"
    val context = LocalContext.current


    Scaffold( //Estrutura básica do Material Design
        content = { paddingValues ->
            Column( // tá definindo uma coluna que vai ocupar tudo o espaço disponivel
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Apenas textos com estilo simples
                Text(
                    text = "Reserva-Chan",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 70.dp)
                )
                Text(
                    text = "Coloque sua conta",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Use 'test@domain.com' para entrar.", // Pra facilitar na hora de escrever lá, obviamente eu tiraria se tivesse mais de um usuario.
                    fontSize = 14.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 8.dp, bottom = 24.dp)
                )

                TextField(
                    value = email, // variavel de estado  para mudar o campo de texto
                    onValueChange = { email = it }, //
                    label = { Text("email@domain.com") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    modifier = Modifier.fillMaxWidth()
                )

                Button (
                    //  Lógica de validação
                    onClick = {
                        // .trim()  remove espaços em branco no início e no fim.
                        if (email.trim() == correctEmail) {
                            // Se for igual, chama a função pra navegar.
                            onContinueClicked(email)
                        } else {
                            // Se for diferente, mensagem de erro.
                            Toast.makeText(context, "E-mail incorreto!", Toast.LENGTH_SHORT).show()
                        }
                    },
                    // Fim da lçógic
                    // Estilo
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
                ) {
                    Text("Continue", color = Color.White, fontSize = 16.sp)
                }

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Politicas de privacidade? Não temos",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 24.dp)
                )
            }
        }
    )
}
