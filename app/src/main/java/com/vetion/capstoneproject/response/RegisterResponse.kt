package com.vetion.capstoneproject.response

import com.google.gson.annotations.SerializedName

data class RegisterResponse(

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("user")
	val user: User
)

data class User(

	@field:SerializedName("password")
	val password: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("username")
	val username: String
)
