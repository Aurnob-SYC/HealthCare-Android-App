import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun healthArticleScreen(
    navController: NavController,
    viewModel: UserAccountViewModel,
    modifier: Modifier = Modifier

    ) {
    /*val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    val healthArticles by viewModel.healthArticlesList.collectAsState()
    val healthArticlesArray = healthArticles.toTypedArray()
    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .fillMaxSize(),

        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "Health Articles",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        viewModel.updateCurrentUser(null)
                        navController.navigate("Home")
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { *//* do something *//* }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = null
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            viewModel.getHealthArticles()
            healthArticlesArray.forEach { article ->
                // Display each HealthArticle in a Text composable
                Text(text = article.name)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }*/

}





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
