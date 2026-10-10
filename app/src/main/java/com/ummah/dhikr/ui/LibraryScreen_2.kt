package com.ummah.dhikr.ui
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ummah.dhikr.data.SeedData
@Composable
fun LibraryScreen(){
 var filter by remember { mutableStateOf("All") }
 Column(Modifier.padding(16.dp)){
  Text("Adhkar Library", style=MaterialTheme.typography.titleLarge)
  Row(Modifier.padding(vertical=8.dp)){ listOf("All","Istighfar","Deceased","Salawat").forEach{ c-> FilterChip(selected=filter==c, onClick={filter=c}, label={Text(c)}, modifier=Modifier.padding(end=6.dp)) } }
  LazyColumn{ items(SeedData.list.filter{ filter=="All" || it.category==filter }){ item-> Card(Modifier.fillMaxWidth().padding(vertical=6.dp)){ Column(Modifier.padding(12.dp)){ Text(item.arabic); Text(item.translation, style=MaterialTheme.typography.bodySmall); Text(item.virtue, style=MaterialTheme.typography.labelSmall, color=MaterialTheme.colorScheme.primary) } } } }
 }
}
