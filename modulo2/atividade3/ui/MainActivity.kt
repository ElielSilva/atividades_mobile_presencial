package modulo2.listas.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile.R
import modulo2.listas.adapter.TaskAdapter
import modulo2.listas.model.Task

class MainActivity : AppCompatActivity() {

    private lateinit var editTextTaskTitle: EditText
    private lateinit var buttonAdd: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TaskAdapter

    private var taskList = mutableListOf<Task>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        editTextTaskTitle = findViewById(R.id.editTextTaskTitle)
        buttonAdd = findViewById(R.id.buttonAdd)
        recyclerView = findViewById(R.id.recyclerViewTasks)

        adapter = TaskAdapter(
            onTaskClicked = { task ->
                val index = taskList.indexOfFirst { it.id == task.id }
                if (index != -1) {
                    val updatedTask = task.copy(isCompleted = !task.isCompleted)
                    taskList[index] = updatedTask
                    adapter.submitList(taskList.toList())
                }
            },
            onDeleteClicked = { task ->
                taskList.remove(task)
                adapter.submitList(taskList.toList())
            }
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        buttonAdd.setOnClickListener {
            val title = editTextTaskTitle.text.toString()
            if (title.isNotBlank()) {
                val newTask = Task(title = title)
                taskList.add(newTask)
                adapter.submitList(taskList.toList())
                editTextTaskTitle.text.clear()
            }
        }
    }
}