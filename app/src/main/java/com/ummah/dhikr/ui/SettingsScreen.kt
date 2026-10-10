package com.ummah.dhikr.ui
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.ummah.dhikr.worker.DhikrWorker
@Composable
fun SettingsScreen(){
 val ctx = LocalContext.current
 var hour by remember { mutableStateOf(20) }
 Column(Modifier.padding(24.dp)){
  Text("Choose your daily time", style=MaterialTheme.typography.titleLarge)
  Spacer(Modifier.height(20.dp))
  Row{ FilterChip(selected=hour==5, onClick={hour=5}, label={Text("After Fajr")}); Spacer(Modifier.width(8.dp)); FilterChip(selected=hour==20, onClick={hour=20}, label={Text("After Maghrib 8pm")}) }
  Spacer(Modifier.height(20.dp))
  Slider(value=hour.toFloat(), onValueChange={hour=it.toInt()}, valueRange=0f..23f, steps=22)
  Button(onClick={ DhikrWorker.scheduleDaily(ctx, hour, 0) }){ Text("Save & Schedule $hour:00 daily") }
 }
}
