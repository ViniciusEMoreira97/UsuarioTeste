package me.dio.usuariodeteste

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_test.view.*
import me.dio.usuariodeteste.domain.Test

class TestAdapter(val context: Context, val userList: List<Test>):
    RecyclerView.Adapter<TestAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var selecao: TextView

        init {
            name = itemView.tv_name
            selecao = itemView.tv_selecao
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.activity_test, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = userList[position].name
        holder.selecao.text = userList[position].country
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}