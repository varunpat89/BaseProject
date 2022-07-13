package com.app.baseproject.onboarding

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.baseproject.databinding.ItemOnboardingBinding

class OnBoardingPagerAdapter(private val dataList: List<Triple<String, String, String>>) :
    RecyclerView.Adapter<OnBoardingPagerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemOnboardingBinding.inflate(
                (parent.context as Activity).layoutInflater,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.data = dataList[position]
    }

    override fun getItemCount() = dataList.size

    inner class ViewHolder(val binding: ItemOnboardingBinding) :
        RecyclerView.ViewHolder(binding.root)

}