package com.example.ggsouresjetpack.Nagvigation.ui.customer


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AddressDetailScreen(addressId:String?,saveAddressAndBack: (String?)->Unit){

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)) {

        var savableAddressId by rememberSaveable {
            mutableStateOf(addressId)
        }

        if(addressId.isNullOrEmpty()){
            Text(text = "Add new Address")
        }
        else{
            Text(text = "Edit Address with id: $addressId")
        }
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(value = savableAddressId ?: "", onValueChange = {
            savableAddressId = it
        }, enabled = (addressId.isNullOrEmpty()))
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = {
            saveAddressAndBack(savableAddressId)
        }) {
            Text("Save")
        }
    }

}