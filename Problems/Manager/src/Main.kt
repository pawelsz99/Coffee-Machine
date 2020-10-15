class Task(val name: String)

// create the Manager singleton here
object Manager {

    var solvedTask = 0

    fun solveTask(task: Task) {
        solvedTask += 1
        println("Task ${task.name} solved!")
    }


}