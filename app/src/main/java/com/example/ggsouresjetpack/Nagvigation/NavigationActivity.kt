package com.example.ggsouresjetpack.Nagvigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.ggsouresjetpack.Nagvigation.ui.catalog.category.CategoryScreen
import com.example.ggsouresjetpack.Nagvigation.ui.catalog.product.ProductDetailScreen
import com.example.ggsouresjetpack.Nagvigation.ui.checkout.CheckoutScreen
import com.example.ggsouresjetpack.Nagvigation.ui.checkout.CheckoutSuccessScreen
import com.example.ggsouresjetpack.Nagvigation.ui.checkout.createCheckoutScreenRoute
import com.example.ggsouresjetpack.Nagvigation.ui.customer.AddressDetailScreen
import com.example.ggsouresjetpack.Nagvigation.ui.customer.CustomerInfoScreen
import com.example.ggsouresjetpack.Nagvigation.ui.customer.MyAccountScreen
import com.example.ggsouresjetpack.Nagvigation.ui.home.HomeScreen
import com.example.ggsouresjetpack.Nagvigation.ui.theme.GGSouresJetpackTheme

class NavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainApp()
        }
    }
}
@Composable
fun MainApp(){
    val navController = rememberNavController()
    GGSouresJetpackTheme {
        //navHost<--- composable
        //navController<-- navigate

        // fragment, activity

        //xml: home -< fragment home
        // route, destination
        //url : facebook.com <--- home, facebook.com/profile.00 <---
        NavHost(navController = navController, startDestination = "home"){
            // route : home
            // return Composable
            composable("home"){
                HomeScreen(
                    openCategoryAction = {
                        navController.navigate("category")
                    },
                    openMyAccountScreen = {
                        navController.navigate("myAccount")
                    },
                    editCustomerInfo = {
                        navController.navigate("customer")
                    }
                )
            }
            composable("category") {
                CategoryScreen(
                    openProductDetail = {
                        productId->
                        navController.navigate("productDetail/$productId")
                    }
                )
            }
            // category fragment : argument
            //route: product detail
            composable("productDetail/{productId}", arguments = listOf(
                navArgument(name = "productId"){
                    type = NavType.StringType
                }
            )) {backStackEntry->
                val productId =backStackEntry.arguments?.getString("productId")// giải mã productId từ categoryScreen
                requireNotNull(productId)
                ProductDetailScreen(
                    productId = productId, checkout = {
                        cartId, customerId ->
                        navController.navigate(createCheckoutScreenRoute(cartId,customerId))
                    },
                    backActon = {
                        navController.popBackStack()
                    }
                )
            }
            //required
            composable("checkout/{cartId}/{customerId}",
                arguments = listOf(
                    navArgument(name = "cartId"){
                        type = NavType.StringType
                    },
                    navArgument(name = "customerId"){
                        type = NavType.StringType
                    }
                )) {
                    backStackEntry->
                val cartId =backStackEntry.arguments?.getString("cartId")
                requireNotNull(cartId)

                val customerId =backStackEntry.arguments?.getString("customerId")
                requireNotNull(customerId)
                CheckoutScreen(cartId=cartId,customerId=customerId){
                    navController.navigate("checkoutSuccess")
                }
            }
            composable("checkoutSuccess") {
                CheckoutSuccessScreen(goHomeAction = {
                    navController.popBackStack("home",inclusive = false, saveState = true)
                }, viewOrderDetailAction = {

                })
            }
            //Nested Navigation
            //route: customer
            //route: myAccount
            navigation("myAccount","customer") {
                composable("myAccount") {
                    MyAccountScreen(navController = navController,openAddressScreen = {
                            addressId->
                        val route = if (addressId == null) "addressDetail" else "addressDetail?addressId=$addressId"
                        navController.navigate(route)
                    })
                }
                composable("customerInfo") {
                    CustomerInfoScreen{
                        navController.popBackStack()
                    }
                }
                //optional
                composable("addressDetail?addressId={addressId}",
                    arguments = listOf(
                        navArgument(name = "addressId") {
                            type = NavType.StringType
                            nullable = true// cho phép null
                        }
                    )) {
                        backStackEntry->
                    val addressId =backStackEntry.arguments?.getString("addressId")
                    AddressDetailScreen(addressId = addressId,
                        saveAddressAndBack = {
                            //gủi dữ liệu từ màn hình hiện tại sang màn hình trước đó
                                addressId-> navController.previousBackStackEntry?.savedStateHandle?.set(
                            "new_address_id",addressId)
                            navController.popBackStack()
                        })
                }
            }
        }
    }
}