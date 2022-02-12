package com.example.fakeapplication_snapchat.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fakeapplication_snapchat.DescubirAdapter
import com.example.fakeapplication_snapchat.R
import com.example.fakeapplication_snapchat.data.BVideos
import com.example.fakeapplication_snapchat.ui.MainActivity
import kotlinx.android.synthetic.main.item_container_video.*


/**
 * A simple [Fragment] subclass.
 */
class Descubrir : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<DescubirAdapter.DescubirViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.item_descubir, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
    }
}