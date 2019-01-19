package ru.lifelaboratory.task_platform.REST

data class Auth (val login : String,
                 val password : String)

data class Registration (val name : String,
                         val login : String,
                         val password : String,
                         val email : String)