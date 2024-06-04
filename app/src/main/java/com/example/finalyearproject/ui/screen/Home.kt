package com.example.finalyearproject.ui.screen

import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Card
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.finalyearproject.data.dao.UserAccountDao
import com.example.finalyearproject.data.entity.HealthArticles
import com.example.finalyearproject.data.entity.UserAccount
import com.example.finalyearproject.ui.screen.viewModel.UserAccountViewModel
import com.example.finalyearproject.ui.theme.FinalYearProjectTheme
import kotlinx.coroutines.flow.Flow


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun homeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: UserAccountViewModel
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

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
                        "Health Care",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        viewModel.updateCurrentUser(null)
                        navController.navigate("LogIn")
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .weight(1f)
                        .padding(10.dp)
                ) {
                    IconButton(
                        onClick = {
                            navController.navigate("LabTest")
                        },
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                Icons.Rounded.Home,
                                contentDescription = null,
                                modifier = Modifier.size(80.dp)
                            )
                            Text(text = "Lab Test")
                        }
                    }

                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .weight(1f)
                        .padding(10.dp)
                ) {
                    IconButton(
                        onClick = {
                            navController.navigate("Medicine")
                        },
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                Icons.Rounded.FavoriteBorder,
                                contentDescription = null,
                                modifier = Modifier.size(80.dp)
                            )
                            Text(text = "Medicine")
                        }
                    }

                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .weight(1f)
                        .padding(10.dp)
                ) {
                    IconButton(
                        onClick = {
                            navController.navigate("Doctor")
                        },
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                Icons.Rounded.AccountCircle,
                                contentDescription = null,
                                modifier = Modifier.size(80.dp)
                            )
                            Text(text = "Doctor")
                        }
                    }

                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .weight(1f)
                        .padding(10.dp)
                ) {
                    IconButton(
                        onClick = {
                                  navController.navigate("HealthArticle")
                        },
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                Icons.Rounded.Info,
                                contentDescription = null,
                                modifier = Modifier.size(80.dp)
                            )
                            Text(text = "Health Articles")
                        }
                    }

                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .weight(1f)
                        .padding(10.dp)
                ) {
                    IconButton(
                        onClick = {
                            navController.navigate("OrderDetails")
                        },
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                Icons.Rounded.ShoppingCart,
                                contentDescription = null,
                                modifier = Modifier.size(80.dp)
                            )
                            Text(text = "Order Details")
                        }
                    }

                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .weight(1f)
                        .padding(10.dp)
                ) {
                    IconButton(
                        onClick = {
                            viewModel.updateCurrentUser(null)
                            navController.navigate("LogIn")
                                  },
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                Icons.Rounded.Close,
                                contentDescription = null,
                                modifier = Modifier.size(80.dp)
                            )
                            Text(text = "Log Out")
                        }
                    }

                }
            }

            }
        }
}




/*
@Preview
@Composable
fun previewHomeScreen() {
    FinalYearProjectTheme {
        val userAccountViewModel = UserAccountViewModel(MockUserAccountDao());
        homeScreen(navController = rememberNavController(), viewModel = userAccountViewModel);
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

    override fun getAllHealthArticles(): Flow<List<HealthArticles>> {
        TODO("Not yet implemented")
    }

    override fun insertAllHealthArticles(healthArticles: List<HealthArticles>) {
        TODO("Not yet implemented")
    }

}
*/
