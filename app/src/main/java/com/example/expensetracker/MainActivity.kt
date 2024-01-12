package com.example.expensetracker

import android.os.Bundle
import android.widget.HorizontalScrollView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expensetracker.ui.theme.ExpenseTrackerTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import java.util.Date




var sources = mutableListOf<ExpenseSource>()

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        sources.add(ExpenseSource("Inter"))
        sources.add(ExpenseSource("Pai"))

        sources[0].addToList(15.53, "14/32/123", "foi mto legal")
        sources[0].addToList(07.53, "12/32/123", "foi mto legal")

        sources[1].addToList(15.53, "14/32/123", "foi bosta")
        sources[1].addToList(07.53, "12/32/123", "foi bosta")
        super.onCreate(savedInstanceState)
        setContent {
            ExpenseTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HelloContent(sources)
                }
            }
        }
    }
}

class ExpenseItem(var value: Double, var date: String, var description: String) {
}
class ExpenseSource(var name: String) {
    var list = mutableListOf<ExpenseItem>()

    fun addToList(value: Double, date: String, description: String) {
        var item = ExpenseItem(value, date, description)
        list.add(item)
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelloContent(sources: MutableList<ExpenseSource>) {
    Row(
        modifier = Modifier.horizontalScroll(rememberScrollState()),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start
    ) {
        for (source in sources) {
            Text(text = "${source.name}")
            Column(modifier = Modifier.padding(16.dp)) {
                for (item in source.list) {
                    Text(
                        text = "${item.value}",
                        modifier = Modifier.padding(bottom = 9.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "${item.date}",
                        modifier = Modifier.padding(bottom = 8.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "${item.description}",
                        modifier = Modifier.padding(bottom = 8.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}


//        var name by remember { mutableStateOf("c ") }
//        if (name.isNotEmpty()) {
//            Text(
//                text = "Hello, $name!",
//                modifier = Modifier.padding(bottom = 8.dp),
//                style = MaterialTheme.typography.bodyMedium
//            )
//        }
//        OutlinedTextField(
//            value = name,
//            onValueChange = { name = it },
//            label = { Text("Name") }
//        )

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ExpenseTrackerTheme {
//        HelloContent()
//    }
//}