package com.example.roomrecyclertask

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import android.widget.TextView
import android.view.LayoutInflater
import android.view.ViewGroup

class TaskItemAdapter: RecyclerView.Adapter<TaskItemAdapter.TaskItemViewHolder>() {

        var data = listOf<Task>()
           // @SuppressLint("NotifyDataSetChanged")
            set(value){
                field = value
                notifyDataSetChanged()

        }
    override fun getItemCount() = data.size



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            TaskItemViewHolder = TaskItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }



    class TaskItemViewHolder(val rootView:TextView):
        RecyclerView.ViewHolder(rootView){
        companion object{
            fun inflateFrom(parent:ViewGroup):TaskItemViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.task_item,parent,false) as TextView
                return TaskItemViewHolder(view)
            }
        }
        fun bind(item:Task){
            rootView.text = item.taskName
        }
    }

}