package com.ummah.dhikr
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import com.ummah.dhikr.ui.HomeScreen
import com.ummah.dhikr.ui.SettingsScreen
import com.ummah.dhikr.ui.LibraryScreen
class MainActivity: ComponentActivity(){
 override fun onCreate(savedInstanceState: Bundle?){
  super.onCreate(savedInstanceState)
  setContent{
   MaterialTheme(colorScheme = darkColorScheme()){
    var tab by remember { mutableStateOf(0) }
    Scaffold(bottomBar={
     NavigationBar{ 
      NavigationBarItem(selected=tab==0, onClick={tab=0}, icon={}, label={Text("Today")})
      NavigationBarItem(selected=tab==1, onClick={tab=1}, icon={}, label={Text("Library")})
      NavigationBarItem(selected=tab==2, onClick={tab=2}, icon={}, label={Text("Time")})
     }
    }){ pad -> Box(Modifier.padding(pad)){ when(tab){ 0->HomeScreen(); 1->LibraryScreen(); 2->SettingsScreen() } } }
   }
  }
 }
}
