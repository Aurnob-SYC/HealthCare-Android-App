import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.finalyearproject.data.dao.UserAccountDao
import com.example.finalyearproject.data.entity.HealthArticles
import com.example.finalyearproject.data.entity.UserAccount

import com.example.finalyearproject.ui.screen.homeScreen
import com.example.finalyearproject.ui.screen.viewModel.UserAccountViewModel
import com.example.finalyearproject.ui.theme.FinalYearProjectTheme
import kotlinx.coroutines.flow.Flow


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow

import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Dialog
import com.example.finalyearproject.R

@Composable
fun healthArticleScreen(
    navController: NavController,
    viewModel: UserAccountViewModel,
    modifier: Modifier = Modifier
) {
    val imageUrls = listOf(
        R.drawable.healtharticles1,
        R.drawable.healtharticles2,
        R.drawable.healtharticles3
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(imageUrls) { imageUrl ->
            var showDialog by remember { mutableStateOf(false) }

            Image(
                painter = painterResource(id = imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Max) // Ensure the height is intrinsic to maintain the aspect ratio.
                    .clip(RoundedCornerShape(8.dp))
                    .border(2.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(vertical = 8.dp)
                    .clickable { showDialog = true }
            )

            if (showDialog) {
                Dialog(onDismissRequest = { showDialog = false }) {
                    ZoomableImage(
                        imageUrl = imageUrl,
                        onDismiss = { showDialog = false }
                    )
                }
            }
        }
    }
}

@Composable
fun ZoomableImage(
    imageUrl: Int,
    onDismiss: () -> Unit
) {
    var scale by remember { mutableStateOf(1f) }
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .pointerInput(Unit) {
                detectTransformGestures { _, pan, zoom, _ ->
                    scale *= zoom
                    offsetX += pan.x
                    offsetY += pan.y
                }
            }
            .clickable { onDismiss() }
    ) {
        Image(
            painter = painterResource(id = imageUrl),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .graphicsLayer(
                    scaleX = maxOf(1f, minOf(3f, scale)),
                    scaleY = maxOf(1f, minOf(3f, scale)),
                    translationX = offsetX,
                    translationY = offsetY
                )
                .fillMaxSize()
        )
    }
}

/*@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun healthArticleScreen(
    navController: NavController,
    viewModel: UserAccountViewModel,
    modifier: Modifier = Modifier

    ) {

    val imageUrls = listOf(
        R.drawable.healtharticles1,
        R.drawable.healtharticles2,
        R.drawable.healtharticles3

    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(imageUrls) { imageUrl ->
            Image(
                painter = painterResource(id = imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Max) // Ensure the height is intrinsic to maintain the aspect ratio.
                    .clip(RoundedCornerShape(8.dp))
                    .border(2.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(vertical = 8.dp)
            )
        }
    }

}*/






/*
@Preview
@Composable
fun previewHealthArticleScreen() {
    FinalYearProjectTheme {
        val userAccountViewModel = UserAccountViewModel(MockUserAccountDao());
        healthArticleScreen(navController = rememberNavController(), viewModel = userAccountViewModel);
    }
}

class MockUserAccountDao : UserAccountDao {
    override fun insert(userAccount: UserAccount) {
        TODO("Not yet implemented")
    }

    override fun delete(userAccount: UserAccount) {
        TODO("Not yet implemented")
    }

    override fun authenticate(email: String, password: String): Flow<UserAccount> {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }

    override fun getHello(): UserAccount? {
        TODO("Not yet implemented")
    }

    override fun getAllHealthArticles(): Flow<List<HealthArticles>> {
        TODO("Not yet implemented")
    }

    override fun insertAllHealthArticles(healthArticles: List<HealthArticles>) {
        TODO("Not yet implemented")
    }

}
*/

