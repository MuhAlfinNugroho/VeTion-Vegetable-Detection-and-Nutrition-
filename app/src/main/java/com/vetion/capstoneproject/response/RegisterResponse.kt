package com.vetion.capstoneproject.response

import com.google.gson.annotations.SerializedName

data class RegisterResponse(
	@SerializedName("message") val message: String,
	@SerializedName("token") val token: String,
	@SerializedName("refreshToken") val refreshToken: String
)