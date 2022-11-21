package com.example.umc_week8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_week8.databinding.ItemDataBinding

class DataRVAdapter(private val dataList: ArrayList<Data>): RecyclerView.Adapter<DataRVAdapter.DataViewHolder>() {
        inner class DataViewHolder(private val viewBinding: ItemDataBinding): RecyclerView.ViewHolder(viewBinding.root){
            fun bind(data: Data){
                viewBinding.apply {
                    viewBinding.tvTitle.text = data.title
                    viewBinding.tvContent.text = data.content
                }
            }
        }

    //viewHolder 만들어질 때 실행할 동작
    override fun onCreateViewHolder(parent:ViewGroup, viewType: Int): DataViewHolder{
        val viewBinding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(viewBinding)
    }

    //ViewHolder가 실제로 데이터를 표시해야할 때 호출되는 함수
    override fun onBindViewHolder(holder: DataViewHolder, position: Int){
        holder.bind(dataList[position])

        // item click시 delete
        holder.itemView.setOnClickListener{
            dataList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, dataList.size)
            notifyDataSetChanged()
        }
        // 클릭 시 메모 삭제
        val item = dataList[position]
    }

    //표현 할 Item의 총 갯수
    override fun getItemCount(): Int = dataList.size



}