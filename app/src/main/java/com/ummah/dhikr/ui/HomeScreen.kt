package com.ummah.dhikr.ui
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
@Composable
fun HomeScreen(){
 var count by remember { mutableStateOf(0) }
 val target = 33
 Column(Modifier.fillMaxSize().padding(24.dp), horizontalAlignment=Alignment.CenterHorizontally){
   Text("بِسْمِ اللَّه - Today's Dhikr for the Ummah", style=MaterialTheme.typography.titleMedium)
   Spacer(Modifier.height(16.dp))
   Card(Modifier.fillMaxWidth()){ Column(Modifier.padding(20.dp)){ 
     Text("اللَّهُمَّ اغْفِرْ لِلْمُؤْمِنِينَ وَالْمُؤْمِنَاتِ", style=MaterialTheme.typography.headlineMedium, textAlign=TextAlign.Center, modifier=Modifier.fillMaxWidth())
     Spacer(Modifier.height(12.dp))
     Text("Allahummaghfir lil-mu'minina wal-mu'minati...", style=MaterialTheme.typography.bodyMedium)
     Spacer(Modifier.height(8.dp))
     AssistChip(onClick={}, label={Text("Tabarani - good deed for each believer")})
   }}
   Spacer(Modifier.height(32.dp))
   FilledTonalButton(onClick={ if(count<target) count++ }, modifier=Modifier.size(180.dp)){ Text("$count / $target", style=MaterialTheme.typography.displaySmall) }
   Spacer(Modifier.height(16.dp))
   if(count>=target) Button(onClick={ count=0 }){ Text("I made dhikr for the Ummah today ✓") } else TextButton(onClick={count=0}){ Text("Reset") }
 }
}
