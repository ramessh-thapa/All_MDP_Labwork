package com.example.amazonecommerceapp

class User(
    val email: String,
    val fullName: String,
    val password: String,
    val phoneNumber: String
)

object UserData {
    val userList = mutableListOf(
        User("john@gmail.com", "John Doe", "pass123", "1234567890"),
        User("jane@gmail.com", "Jane Smith", "pass456", "0987654321")
    )

    private var loggedInUser: User? = null

    fun addUser(user: User) {
        userList.add(user)
    }

    fun find(predicate: (User) -> Boolean): User? {
        return userList.find(predicate)
    }

    fun setLoggedInUser(user: User) {
        this.loggedInUser = user;
    }
    fun getLoggedInUser(): User?  {
        return this.loggedInUser;
    }
}