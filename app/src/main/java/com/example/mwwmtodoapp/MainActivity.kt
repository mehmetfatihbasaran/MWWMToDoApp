package com.example.mwwmtodoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mwwmtodoapp.ui.theme.MWWMToDoAppTheme
import com.example.mwwmtodoapp.ui.theme.add_edit_todo.AddEditTodoEvent
import com.example.mwwmtodoapp.ui.theme.add_edit_todo.AddEditTodoScreen
import com.example.mwwmtodoapp.ui.theme.add_edit_todo.AddEditTodoViewModel
import com.example.mwwmtodoapp.ui.theme.todo_list.TodoListScreen
import com.example.mwwmtodoapp.ui.theme.todo_list.TodoListViewModel
import com.example.mwwmtodoapp.util.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    /*
    private lateinit var todoListViewModel: TodoListViewModel
    private lateinit var addEditTodoViewModel: AddEditTodoViewModel

     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
        todoListViewModel = ViewModelProvider(this)[TodoListViewModel::class.java]
        addEditTodoViewModel = ViewModelProvider(this)[AddEditTodoViewModel::class.java]

         */
        setContent {
            MWWMToDoAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController, startDestination = Routes.TODO_LIST){
                        composable(Routes.TODO_LIST){
                            TodoListScreen(onNavigate = {
                                navController.navigate(it.route)
                            })
                        }
                    composable(
                        route = Routes.ADD_EDIT_TODO + "?todoId={todoId}",
                        arguments = listOf(
                            navArgument(name = "todoId"){
                                type = NavType.IntType
                                defaultValue = -1
                            }
                        )
                    ){
                        AddEditTodoScreen(onPopBackStack = {
                            navController.popBackStack()
                        })
                    }
                }
            }
        }
    }
}
