package com.chirikualii.materi_recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.chirikualii.materi_recyclerview.databinding.ItemProfileBinding
import com.chirikualii.materi_recyclerview.databinding.ItemProfileHeaderBinding

class ListProfileAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class Holder(val binding: ItemProfileBinding) : RecyclerView.ViewHolder(binding.root) {
        //fungsi untuk menghubungkan binding dan view (item_profile.xml)
        fun bindView(data: Profile) {
            binding.tvName.text = data.nama
            binding.tvPhone.text = data.phone

            Glide
                .with(itemView.rootView)
                .load(data.image)
                //.circleCrop() membuat rounded pada gambar
                .into(binding.imProfile)
        }

    }

    class HolderHeader(val binding: ItemProfileHeaderBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(data: Profile) {
            binding.tvName.text = data.nama
            binding.tvPhone.text = data.phone

            Glide
                .with(itemView.rootView)
                .load(data.image)
                //.circleCrop() membuat rounded pada gambar
                .into(binding.ivProfile)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        //menginisiasi class viewholder yang telah dibuat sebelum (Holder)


        when(viewType){

            0 -> {
                val binding = ItemProfileHeaderBinding.inflate(layoutInflater, parent, false)
                return HolderHeader(binding)
            }

            1 -> {
                val binding = ItemProfileBinding.inflate(layoutInflater, parent, false)
                return Holder(binding)
            }
            else -> {
                return null!!
            }
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val profile = listProfile.get(position)

      when(viewType) {

          0 -> {
              val holderProfileHeader = holder as HolderHeader
              holderProfileHeader.bindView(profile)
          }

          1 -> {
              val holderProfileHeader = holder as Holder
              holderProfileHeader.bindView(profile)
          }

      }

    }

    override fun getItemCount(): Int {
        return listProfile.size
    }

    override fun getItemViewType(position: Int): Int {

        if (position == 0) {
            viewType = 0
            return 0
        } else {
            viewType = 1
            return viewType
        }
    }

    private val listProfile = mutableListOf<Profile>()
    private var viewType = -1

    fun addlist(list: List<Profile>) {
        listProfile.clear()
        listProfile.addAll(list)
        notifyDataSetChanged()
    }


}