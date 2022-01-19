package com.example.coffeshopfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeshopfragment.card.CafeCard
import com.example.coffeshopfragment.card.CafeCardAdapter
import com.example.coffeshopfragment.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = ArrayList<CafeCard>()
        items.add(CafeCard(R.drawable.images,"Antico Caffe Greco","St. Italy, Rome"))
        items.add(CafeCard(R.drawable.images1,"Coffe Room","St. Germany Berlin"))
        items.add(CafeCard(R.drawable.images2,"Coffe Ibiza","St. Colon, Madrid"))
        items.add(CafeCard(R.drawable.images3,"Pudding Coffe Shop","St. Diagonal, Barcelona"))
        items.add(CafeCard(R.drawable.images4,"L' Express","St. Picadilly Circus, London"))
        items.add(CafeCard(R.drawable.images5,"Coffe Corner","St. Angel Guimera, Valencia"))
        items.add(CafeCard(R.drawable.images6,"Sweet Cup","St. St.Kinkerstraat, Amsterdam"))


        val recView = view.findViewById<RecyclerView>(R.id.recyclerView)

        recView.setHasFixedSize(true)

        val adaptador = CafeCardAdapter(items)
        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        adaptador.onClick = {
            val i = items[recView.getChildAdapterPosition(it)]
            val bundle = bundleOf("name" to i.nameCoffe)
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment,bundle)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}