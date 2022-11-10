import scala.io.StdIn.{readChar, readFloat}


object App extends App {
  // Задание 3
  println("---------------------------------- Задание a ----------------------------------")
  // a.i) вывод строки справа налево
  val s: String = "Hello, Scala!"
  println(s.reverse)

  // a.ii) преобразование к нижнему регистру
  var lower = for (c <- s) yield c.toLower
  println(lower)

  // a.iii) удаление введенного символа
  println("Введите символ для удаления: ")
  var ch = readChar()
  var chLower = ch.toLower
  var chUpper = ch.toUpper
  var res1 = s.replaceAll(chLower.toString, "")
  var res2 = res1.replaceAll(chUpper.toString, "")
  println(res2)
  // a.iv обавление фразы к строке
  var newStr: String = s + " " + "And goodbye Python!"
  println(newStr)

  // b
  System.out.println("Нажмите Enter чтобы продолжить")
  try System.in.read
  catch {
    case e: Exception =>
  }
  println("\n---------------------------------- Задание b ----------------------------------")
  var yearSalary = (salary: Float, percentBonus: Float, compensation: Float) =>
  salary + (percentBonus * salary) + compensation - ((salary + (percentBonus * salary) + compensation) * 0.13)
  println("Введите зарплату до вычета налогов:")
  var salary = readFloat()
  println("Введите премию в процентах (десятичная дробь):")
  var bonus = readFloat()
  println("Введите компенсацию питания:")
  var compensation = readFloat()
  println(s"Итог: ${yearSalary(salary, bonus, compensation)}")

  // c
  System.out.println("Нажмите Enter чтобы продолжить")
  try System.in.read
  catch {
    case e: Exception =>
  }
  println("\n---------------------------------- Задание c ----------------------------------")
  var salaries: Array[Float] = Array(100, 150, 200, 80, 120, 75)
  var salariesDeviation: Array[Float] = Array(0, 0, 0, 0, 0, 0)
  var avgSalary: Float = salaries.sum / salaries.length
  for (i <- salaries.indices) {
    salariesDeviation(i) = (salaries(i) * 100 / avgSalary) - 100
  }
  println("Отклонение зарплат каждого сотрудника от средней зарплаты в процентах:")
  for (i <- salariesDeviation.indices) {
    if (salariesDeviation(i) < 0) println(s"Сотрудник ${i+1}: меньше на ${salariesDeviation(i) * -1}%")
    else if (salariesDeviation(i) > 0) println(s"Сотрудник ${i+1}: больше на ${salariesDeviation(i)}%")
    else println(s"Сотрудник ${i+1}: отклонение равно ${salariesDeviation(i)}%")
  }


  // d
  System.out.println("Нажмите Enter чтобы продолжить")
  try System.in.read
  catch {
    case e: Exception =>
  }
  println("\n---------------------------------- Задание d ----------------------------------")
  salaries = salaries :+ salary + salary * bonus  // добавили сотрудника из задания b и к его зп добавили премию
  for (i <- salaries.indices) {
    println(s"Сотрудник ${i + 1}: ${salaries(i)}")
  }
  println(s"Минимальная зарплата: ${salaries.min}")
  println(s"Максимальная зарплата: ${salaries.max}")

  // e
  System.out.println("Нажмите Enter чтобы продолжить")
  try System.in.read
  catch {
    case e: Exception =>
  }
  println("\n---------------------------------- Задание e ----------------------------------")
  salaries = salaries :+ 350
  salaries = salaries :+ 90
  salaries = salaries.sorted
  for (i <- salaries.indices) {
    println(s"Сотрудник ${i + 1}: ${salaries(i)}")
  }

  // f
  System.out.println("Нажмите Enter чтобы продолжить")
  try System.in.read
  catch {
    case e: Exception =>
  }
  println("\n---------------------------------- Задание f ----------------------------------")
  salaries = salaries :+ 130
  var buff: Float = 0 // вспомогательная переменная для обмена элементов
  var index: Int = salaries.length-1
  for (i <- salaries.length-1 to 1 by -1) {
    if (salaries(i) < salaries(i-1)) {
      buff = salaries(i-1)
      salaries(i-1) = salaries(i)
      salaries(i) = buff
      index = i
    }
  }
  println(s"Новый сотрудник под номером ${index}")
  for (i <- salaries.indices) {
    println(s"Сотрудник ${i+1}: ${salaries(i)}")
  }

  // g
  System.out.println("Нажмите Enter чтобы продолжить")
  try System.in.read
  catch {
    case e: Exception =>
  }
  println("\n---------------------------------- Задание g ----------------------------------")
   def salaryLevels(salaries: Array[Float], levels: Array[Float]): Array[Int] = {
    // [0, levels(0)) - junior
    // [levels(0), levels(1)) - middle
    // [levels(1), levels[2]) - senior
    var result: Array[Int] = Array()
    for (i <- salaries.indices) {
      if (salaries(i) >= levels(0)) {
          if (salaries(i) < levels(1)) {
            result = result :+ i+1
          }
        }
    }
    result
  }

  var levels: Array[Float] = Array(0, 0, 0)
  println("Введите 3 числа для уровней зарплаты junior, middle и senior:")
  for (i <- levels.indices) {
    levels(i) = readFloat()
  }
  var r = salaryLevels(salaries, levels)
  println("Сотрудники уровня middle:")
  if (r.length != 0) {
    for (i <- r.indices) {
      println(s"Сотрудник ${r(i)}")
    }
  }
  else {
    println("Нет сотрудников с указанной зарплатой уровня middle!")
  }

  // h
  System.out.println("Нажмите Enter чтобы продолжить")
  try System.in.read
  catch {
    case e: Exception =>
  }
  println("\n---------------------------------- Задание h ----------------------------------")
  for (i <- salaries.indices) {
    salaries(i) = salaries(i) + (salaries(i) * 7 / 100)
  }
  println("Проиндексированная на 7% зарплата сотрудников:")
  for (i <- salaries.indices) {
    println(s"Сотрудник ${i + 1}: ${salaries(i)}")
  }
}
