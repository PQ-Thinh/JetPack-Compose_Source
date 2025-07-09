package com.example.ggsouresjetpack.JetpackDay


import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.ggsouresjetpack.R
import com.example.ggsouresjetpack.ui.theme.BackgroundColor
import com.example.ggsouresjetpack.ui.theme.BorderColor
import com.example.ggsouresjetpack.ui.theme.Category
import com.example.ggsouresjetpack.ui.theme.Difficulty
import com.example.ggsouresjetpack.ui.theme.GGSouresJetpackTheme
import com.example.ggsouresjetpack.ui.theme.Ingredients
import com.example.ggsouresjetpack.ui.theme.Mojito
import com.example.ggsouresjetpack.ui.theme.Serves
import com.example.ggsouresjetpack.ui.theme.TextColor
import com.example.ggsouresjetpack.ui.theme.Time

//modifier= Modifier.paint(painterResource(id = R.drawable.sunny1_background)).fillMaxSize()
@Preview
@Composable
fun ConstraintLayoutDay(){
   ConstraintLayout (modifier = Modifier.background(color = Color.White)){
       val (inTop,inBottom) = createRefs()
       ConstraintLayout(modifier = Modifier.constrainAs(inTop) {
           start.linkTo(parent.start)
           end.linkTo(parent.end)
           top.linkTo(parent.top)
       }) {
           IngredientTop()
       }
       ConstraintLayout(modifier = Modifier.constrainAs(inBottom) {
           top.linkTo(inTop.bottom)
           start.linkTo(parent.start)
           end.linkTo(parent.end)
           bottom.linkTo(parent.bottom)
       }) {
           Ingredients()
       }

   }
}
@Composable
fun Ingredients(modifier: Modifier= Modifier){
    ConstraintLayout (){
        val (tvIngredients, imgArrow)=createRefs()
        Text(text = "Ingredients", style = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            lineHeight = 14.sp,
            color = Ingredients
        ),modifier= Modifier.constrainAs(tvIngredients) {
            top.linkTo(parent.top)
            start.linkTo(parent.start, margin = 2.dp)
        })
        Icon(
            imageVector = Icons.Outlined.KeyboardArrowRight,
            contentDescription = null,
            tint = Ingredients,
            modifier = Modifier.constrainAs(imgArrow) {
                start.linkTo(tvIngredients.end, margin = 5.dp)
                bottom.linkTo(tvIngredients.bottom)
            })
        val (lineOne,lineTwo) = createRefs()
        ConstraintLayout(modifier = Modifier
            .fillMaxWidth()
            .constrainAs(lineOne) {
                start.linkTo(tvIngredients.start)
                top.linkTo(tvIngredients.bottom, margin = 14.dp)
            }) { IngredientPreview() }

    }
}
@Composable
fun Ingredient(
    @DrawableRes icon:Int,
    value: Int,
    unit: String?,
    name: String,
    modifier: Modifier = Modifier){
    ConstraintLayout (modifier = modifier
        .background(color = BackgroundColor,
            shape = CircleShape
        )
        .border(BorderStroke(width = 1.dp, color = BorderColor),CircleShape)){
        val verticalGuideline50 = createGuidelineFromTop(0.5f)
        val imgIcon =createRef()
        Image(painter = painterResource(id= icon),
            contentDescription = null,
            modifier= Modifier.constrainAs(imgIcon){
                top.linkTo(parent.top, margin = 5.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(verticalGuideline50)
                height = Dimension.fillToConstraints
            }, contentScale = ContentScale.FillHeight)
        val (tvValue,tvUnit,tvName) = createRefs()
        val verticalGuideline = createGuidelineFromStart(0.5f)
        val valueTextColor = Color(0xFFFB7D8A)
        Text(text = value.toString(), style = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 28.sp,
            lineHeight = 14.sp,
            color = valueTextColor
        ), modifier= Modifier.constrainAs(tvValue){
            top.linkTo(verticalGuideline50, margin = 2.dp)
            end.linkTo(verticalGuideline, margin = 2.dp)
        })
        unit?.let {
            Text(text = unit, style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                lineHeight = 14.sp,
                color = valueTextColor,
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),modifier= Modifier.constrainAs(tvUnit) {
                top.linkTo(tvValue.bottom, margin = 2.dp)
                end.linkTo(tvValue.end)
            })
        }
        val endGuideline20 = createGuidelineFromEnd(0.2f)
        val bottomBarrier = createBottomBarrier(tvValue,tvUnit)
        Text(text = name, style = TextStyle(
            fontSize = 10.5.sp,
            fontWeight = FontWeight.Medium,
            color = TextColor,
           lineHeight = 12.sp
        ),modifier = Modifier.constrainAs(tvName) {
            start.linkTo(verticalGuideline)
            bottom.linkTo(bottomBarrier)
            top.linkTo(tvValue.top)
            end.linkTo(endGuideline20)
            width =Dimension.fillToConstraints
        }, maxLines = 2,
            textAlign = TextAlign.Start)
    }
}
//@Preview(showBackground = true)
@Composable
fun IngredientPreview(modifier: Modifier = Modifier){
    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            Ingredient(
                icon = R.drawable.la,
                value = 8,
                unit = null,
                name = "Mint Leaves",
                modifier = Modifier.size(110.dp))
            Spacer(modifier = Modifier.width(12.dp))
            Ingredient(
                icon = R.drawable.lemon,
                value = 2,
                unit = null,
                name = "Lemon Wedges",
                modifier = Modifier.size(110.dp))
            Spacer(modifier = Modifier.width(12.dp))
            Ingredient(
                icon = R.drawable.lemon_juice,
                value = 30,
                unit = "ml",
                name = "Lemon juice",
                modifier = Modifier.size(110.dp))
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            Ingredient(
                icon = R.drawable.ice,
                value = 6,
                unit = null,
                name = "Ice Cubes",
                modifier = Modifier.size(110.dp))
            Spacer(modifier = Modifier.width(12.dp))
            Ingredient(
                icon = R.drawable.sugar,
                value = 2,
                unit = "tbsp",
                name = "Sugar",
                modifier = Modifier.size(110.dp))
            Spacer(modifier = Modifier.width(12.dp))
            Ingredient(
                icon = R.drawable.soda,
                value = 30,
                unit = "ml",
                name = "Club Soda",
                modifier = Modifier.size(110.dp))
        }
    }
}
@Composable
fun IngredientsText(
    name: String,
    colorText: Color,
    colorParameter: Color,
    parameter: String,
    modifier: Modifier= Modifier
){
    ConstraintLayout {
        val (tvName,tvParameter) = createRefs()
        Text( text = name, style = TextStyle(
            color = colorText,
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp
        ),modifier = Modifier.constrainAs(tvName) {
            start.linkTo(parent.start)

        })
        Text( text = parameter, style = TextStyle(
            color = colorParameter,
            fontWeight = FontWeight.SemiBold,
            fontSize = 30.sp
        ),modifier = Modifier.constrainAs(tvParameter) {
            start.linkTo(parent.start)
            top.linkTo(tvName.bottom, margin = 2.dp)
        })
    }

}
@Composable
fun ListTestIngredients(modifier: Modifier= Modifier){
    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        IngredientsText(
            name = "Time",
            parameter = "25 min",
            colorText = Time,
            colorParameter = Time,
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(3.dp))
        IngredientsText(
            name = "Difficulty",
            parameter = "Medium",
            colorText = Difficulty,
            colorParameter = Difficulty,
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(3.dp))
        IngredientsText(
            name = "Category",
            parameter = "Sweet",
            colorText = Category,
            colorParameter = Category,
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(3.dp))
        IngredientsText(
            name = "Serves",
            parameter = "2",
            colorText = Serves,
            colorParameter = Serves,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}
@Composable
fun VirginMojito(){
    ConstraintLayout {
        Column {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround) {
                Icon(imageVector = Icons.Outlined.KeyboardArrowLeft, contentDescription = null)
                Text(text = "Virgin Mojito", style = TextStyle(
                    color = Time,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                ))
                Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = null)
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "A Mojito without alcohol, its combination of sweet and citrusy flavors makes it the summers go to.",
                style = TextStyle(
                    color = Mojito,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif

                ), textAlign = TextAlign.Start,
                modifier = Modifier.padding(12.dp))
        }

    }
}
@Composable
fun IngredientTop(modifier: Modifier= Modifier){
    ConstraintLayout(modifier= Modifier.paint(painterResource(id = R.drawable.nen)
        ,contentScale = ContentScale.FillBounds)) {
        val (theOne,theTwo,theThree) = createRefs()
        val verticalGuideline30 = createGuidelineFromTop(0.3f)
        val verticalGuideline40 = createGuidelineFromStart(0.4f)
        ConstraintLayout(modifier = Modifier
            .fillMaxWidth()
            .constrainAs(theOne) {
                top.linkTo(parent.top, margin = 15.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(verticalGuideline30)
            }) {  VirginMojito()}
        ConstraintLayout(modifier = Modifier
            .fillMaxWidth()
            .constrainAs(theTwo) {
                start.linkTo(theOne.start, margin = 2.dp)
                top.linkTo(verticalGuideline30)
                end.linkTo(verticalGuideline40)
            }) {
                ListTestIngredients(modifier = Modifier.fillMaxWidth())
        }
        Image(painter = painterResource(id = R.drawable.matcha),
            contentDescription = null,modifier = Modifier.size(304.dp,350.dp)
                .constrainAs(theThree) {
                    start.linkTo(verticalGuideline40)
                    top.linkTo(verticalGuideline30)
                })
    }
}