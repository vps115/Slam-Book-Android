package com.vit.slambookvidhi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.SnackbarLayout


class FriendsAdapter(private val items: ArrayList<Friend>, private val context: Context) :
    RecyclerView.Adapter<FriendsAdapter.FriendsViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_friend, parent, false)
        return FriendsViewHolder(view)
    }

    override fun onBindViewHolder(holder: FriendsViewHolder, position: Int) {
        with(holder) {
            with(items[position]) {
                holder.nameTextView.text = items[position].name
                holder.itemView.setOnClickListener {

                    val snackbar = Snackbar.make(holder.nameTextView,"Phone Number: $phone\n" +
                            "Date of Birth: $dob\nHobby: $hobby", Snackbar.LENGTH_LONG)
                    snackbar.setTextMaxLines(4)
                    snackbar.show()
                }
            }
        }
    }


    inner class FriendsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView = itemView.findViewById<AppCompatTextView>(R.id.friendName)
    }

}