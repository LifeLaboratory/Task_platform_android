package ru.lifelaboratory.task_platform.REST

object Model {
    data class AuthResult(val answer : Int,
                          val session : String)

    data class RegistrationResult(val answer : Int)
}