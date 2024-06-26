package com.vetion.capstoneproject.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
	@field:SerializedName("message")
	val message: String?,

	@field:SerializedName("token")
	val token: String?,

	@field:SerializedName("refreshToken")
	val refreshToken: String?
)
