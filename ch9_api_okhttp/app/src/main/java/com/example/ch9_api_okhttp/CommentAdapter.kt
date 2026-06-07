package com.example.ch9_api_okhttp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentAdapter(private var commentList: List<Comment>) :
    RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    // 1. 綁定剛剛設計的 item_comment 畫面
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_comment, parent, false)
        return CommentViewHolder(view)
    }

    // 2. 把資料陣列的某一筆，對接到畫面元件上
    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val currentComment = commentList[position]
        holder.tvEmail.text = "${currentComment.email}"
        holder.tvName.text = "${currentComment.name}"
        holder.tvBody.text = currentComment.body
    }

    // 3. 告訴 RecyclerView 總共有幾筆資料
    override fun getItemCount(): Int = commentList.size

    // 4. 清單更新資料的方法（供 Activity 呼叫）
    fun updateData(newComments: List<Comment>) {
        this.commentList = newComments
        notifyDataSetChanged() // 重新整理畫面
    }

    // 內部類別：負責抓取 item 裡面的元件 ID
    class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvEmail: TextView = itemView.findViewById(R.id.tvEmail)
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvBody: TextView = itemView.findViewById(R.id.tvBody)
    }
}