package com.example.rgarcia.listmaker

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

class ListSelectionRecyclerViewAdapter(val lists: ArrayList<TaskList>, val clickListener: ListSelectionRecyclerViewClickListener) : RecyclerView.Adapter<ListSelectionViewHolder>() {


    val listTitles = arrayOf("Shopping List", "Chores", "Android Tutorials");

    interface ListSelectionRecyclerViewClickListener {
        fun listItemClicked(list: TaskList)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSelectionViewHolder {
        val view = LayoutInflater.from(parent?.context)
                .inflate(R.layout.list_selection_view_holder,
                        parent,
                        false)
        // 2
        return ListSelectionViewHolder(view)
    }


    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(holder: ListSelectionViewHolder, position: Int) {
        if (holder != null) {
            holder.listPosition.text = (position + 1).toString()
            holder.listTitle.text = lists.get(position).name
            holder.itemView.setOnClickListener({
                clickListener.listItemClicked(lists.get(position))
            })
        }
    }

    fun addList(list: TaskList) {
        // 1
        lists.add(list)

        // 2
        notifyDataSetChanged()
    }

}