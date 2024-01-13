package com.example.mwwmtodoapp.ui.theme.todo_list

import com.example.mwwmtodoapp.data.Todo

sealed class TodoListEvent{

    data class OnDeleteTodoClicked(val todo: Todo): TodoListEvent()
    data class OnDoneChange(val todo: Todo, val isDone: Boolean): TodoListEvent()
    object OnUndoDeleteClick: TodoListEvent()
    data class OnTodoClick(val todo: Todo): TodoListEvent()
    object OnAddTodoClick: TodoListEvent()

}
