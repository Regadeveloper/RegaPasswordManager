package data


import androidx.lifecycle.LiveData
class UserRepository (private val userDao : UserDaoInterface) {

    val readData: LiveData<List<User>> = userDao.readData()

    suspend fun addUser (user: User){
        userDao.addUser(user)
    }
}