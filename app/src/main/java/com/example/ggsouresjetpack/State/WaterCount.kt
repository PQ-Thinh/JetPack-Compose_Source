package com.example.ggsouresjetpack.State
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


//@SuppressLint("UnrememberedMutableState")
//@Composable
//fun WaterCounter(modifier: Modifier= Modifier) {
//    Column(modifier = modifier.padding(16.dp)) {
//        var count by remember { mutableIntStateOf(0) }
//        if (count > 0) {
//            var showTask by remember { mutableStateOf(true) }
//            if (showTask) {
//                WellnessTaskItem(
//                    onClose = {
//                        showTask=!showTask
//                    },
//                    taskName = "Have you taken your 15 minute walk today?"
//                )
//            }
//            Text("You've had $count glasses.")
//        }
//        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
//            Button(onClick = { count++}, enabled = count < 10) {
//                Text("Add one")
//            }
//            Button(onClick = { count=0 }, enabled = count>0) {
//                Text("Clear water count" )
//            }
//        }
//
//    }
//}

@Composable
fun StatelessCounter(Name:String, count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses $Name.")
        }
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}
@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var waterCount by remember { mutableStateOf(0) }

   // var juiceCount by remember { mutableStateOf(0) }


        StatelessCounter("water",waterCount, { waterCount++ })
        Spacer(modifier= Modifier.height(8.dp))
        //StatelessCounter("juice",juiceCount, { juiceCount++ })



}
@Composable
fun WellnessItem(
    name: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onRemove: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .shadow(2.dp, RoundedCornerShape(8.dp))
            .background(Color(0xFFF2F2F2), RoundedCornerShape(8.dp))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "📝 Task $name",
            modifier = Modifier.weight(1f),
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp
        )
        Checkbox(
            checked = checked,
            onCheckedChange =  onCheckedChange,
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red,
                uncheckedColor = Color.Green
            )
        )
        Button(
            onClick = onRemove,
            colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
        ) {
            Text("❌")
        }
    }
}


@Composable
fun ListViewItem(modifier: Modifier = Modifier) {
    var itemList by remember { mutableStateOf((0..9).toList()) }
    val checkedStates = remember { mutableStateMapOf<Int, Boolean>() }

    LazyColumn(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(itemList) { index ->
            val checked = checkedStates[index] ?: false
            WellnessItem(
                name = "$index",
                checked = checked,
                onCheckedChange = { checkedStates[index] = it },
                onRemove = {
                    itemList = itemList.filterNot { it == index }
                    checkedStates.remove(index)
                },
                modifier = modifier
            )
        }
    }
}

@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    Scaffold(modifier.background(color = Color.White)){
//           StatefulCounter(modifier.padding(vertical = 30.dp))
        ListViewItem(modifier.padding(it))
    }

}