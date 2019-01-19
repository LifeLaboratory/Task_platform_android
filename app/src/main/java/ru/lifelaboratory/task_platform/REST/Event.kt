package ru.lifelaboratory.task_platform.REST

data class Event(val name : String,
                 val pictureUrl : String,
                 val description : String,
                 val startDate : String,
                 val endDate : String,
                 val users : String)