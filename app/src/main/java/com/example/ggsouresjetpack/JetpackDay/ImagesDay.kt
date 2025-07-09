package com.example.ggsouresjetpack.JetpackDay

import android.icu.number.Scale
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.ggsouresjetpack.R
import com.example.ggsouresjetpack.ui.theme.GGSouresJetpackTheme

@Composable
@Preview
fun ImagesDay(){
    GGSouresJetpackTheme {
       Column (Modifier
            .background(color = Color.White)
           .padding(24.dp)){
            Images(contentScale = ContentScale.Crop)
             Spacer(modifier = Modifier.height(12.dp))
            CrialAvatar()
           UrlImage()
       //            ImagesVector()
//            Spacer(modifier = Modifier.height(12.dp))
//            CustomPainterImagesComposable()
        }
   }

}
@Composable
fun CustomPainterImagesComposable(){
    Image(painter = ColorPainter(Color.Red),
        contentDescription = null,
        modifier = Modifier.size(220.dp),)
}
@Composable
fun ImagesVector(){
    Image(imageVector = Icons.Filled.Person,
        contentDescription = "person")
}
@Composable
fun Images(contentScale: ContentScale){
    Image(
        painter = painterResource(id = R.drawable.sunny1_background),
        contentDescription = "Ảnh nền",
        contentScale = contentScale,
        modifier = Modifier.height(150.dp)
            .fillMaxWidth()
            .shadow(
                elevation = 20.dp,
                shape = RoundedCornerShape(size = 8.dp)
            ).aspectRatio(2f),
        alignment = Alignment.Center,


    )
}
@Composable
fun CrialAvatar(){
    Surface (
        modifier = Modifier.border(BorderStroke(1.dp, color = Color.Blue),
            shape = CircleShape)
            .clip(shape = CircleShape)
    ){
        Image(painter = painterResource(id = R.drawable.avatar),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
    }
}
@Composable
fun UrlImage(){
    Image(rememberAsyncImagePainter(
        model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpEy091YwhQgNu1yu4_t2AdLh6Flg_EdsHYA&s",
        placeholder = painterResource(id=R.drawable.avatar)),

        contentDescription = null)
}