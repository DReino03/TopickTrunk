package com.topicktrunck

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.Parabolic
import com.exyte.animatednavbar.animation.balltrajectory.Straight
import com.exyte.animatednavbar.animation.balltrajectory.Teleport
import com.exyte.animatednavbar.animation.indendshape.Height
import com.exyte.animatednavbar.animation.indendshape.StraightIndent
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius
import com.exyte.animatednavbar.items.dropletbutton.DropletButton
import com.exyte.animatednavbar.items.wigglebutton.WiggleButton
import com.exyte.navbar.colorButtons
import com.exyte.navbar.colorButtons.ColorButton
import com.exyte.navbar.dropletButtons
import com.exyte.navbar.wiggleButtonItems
import com.topicktrunck.ui.theme.LightPurple
import com.topicktrunck.ui.theme.Purple
import com.topicktrunck.ui.theme.RoyalPurple


@Composable
fun ColorButtonNavBar(navController: NavController, destinations: List<String>) {
   Row(modifier = Modifier.background(Color.Transparent)) {
       var selectedItem by remember { mutableStateOf(0) }
       var prevSelectedIndex by remember { mutableStateOf(0) }

       if (colorButtons.isEmpty()){
              Text(text = "No items to display")

       }else{
           AnimatedNavigationBar(
               modifier = Modifier
                   .padding(horizontal = 8.dp, vertical = 5.dp)
                   .height(65.dp),
               selectedIndex = selectedItem,
               ballColor = Color.Blue,
               cornerRadius = shapeCornerRadius(25.dp),
               ballAnimation = Straight(
                   spring(dampingRatio = 0.6f, stiffness = Spring.StiffnessVeryLow)
               ),
               indentAnimation = StraightIndent(
                   indentWidth = 56.dp,
                   indentHeight = 15.dp,
                   animationSpec = tween(1000)
               )
       ) {
           val currentRoute = navController.currentBackStackEntry?.destination?.route

           colorButtons.forEachIndexed { index, it ->
               ColorButton(
                   modifier = Modifier.fillMaxSize(),
                   prevSelectedIndex = prevSelectedIndex,
                   selectedIndex = selectedItem,
                   index = index,
                   route = (destinations.getOrNull(index) ?: ""),
                   onClick = {
                       prevSelectedIndex = selectedItem
                       selectedItem = index
                       navController.navigate(destinations[index]) {
                           // Evita volver a seleccionar el mismo item
                           launchSingleTop = true
                           restoreState = true
                       }
                             },
                   icon = it.icon,
                   contentDescription = stringResource(id = it.description),
                   animationType = it.animationType,
                   background = it.animationType.background
               )
           }
       }
       }
   }
   }
