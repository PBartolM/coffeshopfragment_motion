package com.example.coffeshopfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeshopfragment.comment.CommentCard
import com.example.coffeshopfragment.comment.CommentCardAdapter
import com.example.coffeshopfragment.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = binding.textviewSecond
        title.text = arguments?.getString("name")

        val items = ArrayList<CommentCard>()
        items.add(CommentCard("Rapido y sencillo"))
        items.add(CommentCard("Servicio algo flojo"))
        items.add(CommentCard("Para repetir... extensas carta de cafes"))
        items.add(CommentCard("Buenos precios"))
        items.add(CommentCard("Acogedor. Muy buen ambiente"))


        val recView = view.findViewById<RecyclerView>(R.id.recyclerView2)

        recView.setHasFixedSize(true)

        val adaptador = CommentCardAdapter(items)
        recView.adapter = adaptador

        recView.layoutManager = GridLayoutManager(context, 2)

        adaptador.onClick = {

        }




    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}