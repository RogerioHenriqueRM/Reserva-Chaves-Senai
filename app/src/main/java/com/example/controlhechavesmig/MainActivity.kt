package com.example.controlhechavesmig

import android.os.Bundle
import androidx.activity.ComponentActivity // Alterado para androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.controlhechavesmig.ui.telas.LoginScreen
import com.example.controlhechavesmig.ui.telas.SalasScreen
import com.example.controlhechavesmig.ui.theme.ControlheChavesMIGTheme
import com.example.controlhechavesmig.navigation.AppRoutes

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ControlheChavesMIGTheme {

                // O NavController deve ser lembrado dentro de um Composable
                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    NavHost(
                        navController = navController,
                        startDestination = AppRoutes.LOGIN, //tela inicial
                        modifier = Modifier.padding(innerPadding) // Aplica o padding do Scaffold
                    ) {
                        composable(AppRoutes.LOGIN) {
                            LoginScreen(
                                onContinueClicked = {
                                    // Navega para a tela de Salas após o login bem-sucedido
                                    navController.navigate(AppRoutes.SALAS) {
                                        // Limpa a pilha de login para que o usuário não volte para ela
                                        popUpTo(AppRoutes.LOGIN) { inclusive = true }
                                    }
                                }
                            )
                        }
                        composable(AppRoutes.SALAS) {
                            SalasScreen(
                                // Se SalasScreen precisar do navController ou de ações de navegação
                                //Ex:
                                // navController = navController,
                                // onNavigateToDetalhes = { salaId -> navController.navigate("detalhes/$salaId") }
                            )
                        }
                        // Se for colocar mais tela bota aqui
                    }
                }
            }
        }
    }
}