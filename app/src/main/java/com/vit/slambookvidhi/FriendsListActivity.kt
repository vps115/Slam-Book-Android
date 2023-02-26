package com.vit.slambookvidhi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class FriendsListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends_list)

        val rvFriends = findViewById<RecyclerView>(R.id.rvFriendsList)

        val friendsList = arrayListOf<Friend>()

        val dbHelper = DBHelper(this, null)
        val cursor = dbHelper.getFriendsFromSlamBook()

        if(cursor != null){
            while (cursor.moveToNext()) {
                val name = cursor.getString(cursor.getColumnIndex(DBHelper.FRIEND_NAME))
                val dob = cursor.getString(cursor.getColumnIndex(DBHelper.FRIEND_DOB))
                val phone = cursor.getString(cursor.getColumnIndex(DBHelper.FRIEND_PHONE))
                val hobby = cursor.getString(cursor.getColumnIndex(DBHelper.FRIEND_HOBBY))

                val friend = Friend(name, dob, phone, hobby)
                friendsList.add(friend)
            }
        }

        rvFriends.adapter = FriendsAdapter(friendsList, this)
    }
}