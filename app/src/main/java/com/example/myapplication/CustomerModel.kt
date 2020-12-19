package com.example.myapplication

data class CustomerModel(
    val id: Int,
    val name: String

) {
    override fun toString(): String {
        return "CustomerModel(id=$id, name='$name')"
    }

    @JvmName("getId1")
    fun getId(): Int {
        return this.id
    }

    @JvmName("getName1")
    fun getName(): String {
        return this.name
    }
}