package ru.lifelaboratory.task_platform.REST

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface User {
    @POST("api/auth/")
    fun auth(@Body auth : Auth) : Observable<Model.AuthResult>

    @POST("api/registration/")
    fun registration(@Body reg : Registration) : Observable<Model.RegistrationResult>

    companion object {
        fun create(): User {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://taskplatform.jumpingcrab.com/")
                .build()

            return retrofit.create(User::class.java)
        }
    }

}