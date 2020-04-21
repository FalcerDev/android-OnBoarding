package dev.falcer.onboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private lateinit var dataList: List<OnBoard>

    fun setData(data: List<OnBoard>) {
        dataList = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.card_onboard,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.tv_title)
        private val description = view.findViewById<TextView>(R.id.tv_description)
        fun bind(data: OnBoard) {
            title.text = data.title
            description.text = data.description
            onAction()
        }

        private fun onAction() {
            // do some action here
        }
    }

}