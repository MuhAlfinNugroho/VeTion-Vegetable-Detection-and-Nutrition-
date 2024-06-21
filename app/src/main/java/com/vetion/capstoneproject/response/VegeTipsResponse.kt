package com.vetion.capstoneproject.response

import com.google.gson.annotations.SerializedName

data class VegeTipsResponse(

	@field:SerializedName("data")
	val data: Data,

	@field:SerializedName("status")
	val status: String,

	@field:SerializedName("status")
	val message: String?
)

data class Data(

	@field:SerializedName("manfaat")
	val manfaat: String,

	@field:SerializedName("penyimpanan_jangka_pendek")
	val penyimpananJangkaPendek: List<String>,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("pemilihan")
	val pemilihan: String,

	@field:SerializedName("penyimpanan_jangka_panjang")
	val penyimpananJangkaPanjang: List<String>
)
