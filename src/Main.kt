import kotlin.random.Random

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main()
{
    var array = FillArray()
    Draw(array)
}

fun GetAvg(): Int {
    val times = 5
    var total = 0
    for (i in 1..times) total += Random.nextInt(10000)
    val avg = total / times
    return avg
}

fun GetToArray(array: Array<Int>, avg : Int) {
    when(avg)
    {
        in 0..1000 -> ++array[0]
        in 1001..2000 -> ++array[1]
        in 2001..3000 -> ++array[2]
        in 3001..4000 -> ++array[3]
        in 4001..5000 -> ++array[4]
        in 5001..6000 -> ++array[5]
        in 6001..7000 -> ++array[6]
        in 7001..8000 -> ++array[7]
        in 8001..9000 -> ++array[8]
        in 9001..10000 -> ++array[9]
    }
}

fun FillArray(): Array<Int>
{
    var GraphArray = arrayOf(0, 0, 0, 0, 0, 0, 0, 0 ,0 , 0)
    var avg = 0
    for (i in 1..10000)
    {
        avg = GetAvg()
        GetToArray(GraphArray, avg)
    }
    return SimplifyArray(GraphArray)
}

fun GetMax(GraphArray: Array<Int>) : Int
{
    var max = GraphArray[0]
    for (i in GraphArray.indices)
        if (GraphArray[i] > max) max = GraphArray[i]
    return max
}

fun SimplifyArray(graphArray: Array<Int>): Array<Int>
{
    for (i in graphArray.indices) graphArray[i] = graphArray[i] / 50
    return graphArray
}

fun Draw(GraphArray: Array<Int>)
{
    val max = GetMax(GraphArray)
    var drawingPoint = max
    for (i in 1..max)
    {
        for (j in GraphArray.indices)
        {
            if (drawingPoint <= GraphArray[j]) print("X")
            else print(" ")
        }
        --drawingPoint
        println()
    }
}

///