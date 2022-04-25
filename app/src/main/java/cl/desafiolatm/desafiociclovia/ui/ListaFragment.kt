package cl.desafiolatm.desafiociclovia.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatm.desafiociclovia.adapter.CicloViaAdapter
import cl.desafiolatm.desafiociclovia.databinding.FragmentListaBinding
import cl.desafiolatm.desafiociclovia.modelo.CicloVia


private val RecyclerView.text: Any
    get() {return "Las Condes"}

class ListaFragment : Fragment() {

    lateinit var binding: FragmentListaBinding
    lateinit var lista: ArrayList<CicloVia>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListaBinding.inflate(inflater,container,false)
        llenarLista()

        with(binding){
            val adapter = CicloViaAdapter(lista)
            val manager = LinearLayoutManager(context)

            btnLista.setOnClickListener{
                rvLista.adapter = adapter
                rvLista.layoutManager = manager
                CicloViaAdapter(lista)
            }

            btnFiltro.setOnClickListener {
                rvLista.adapter = adapter
                rvLista.layoutManager = manager
                val filtro = rvLista.text.toString()
                val lista_filtrada = lista.filter { s -> s.comuna.contains(filtro) }
                adapter.filtrar(lista_filtrada)
            }
        }

        return binding.root
    }

    private fun llenarLista(){
        lista = ArrayList()
        lista.add(CicloVia("Ciclovía 1","Las Condes"))
        lista.add(CicloVia("Ciclovía 2","La Reina"))
        lista.add(CicloVia("Ciclovía 3","Ñuñoa"))
        lista.add(CicloVia("Ciclovía 4","Macul"))
        lista.add(CicloVia("Ciclovía 5","Providencia"))
        lista.add(CicloVia("Ciclovía 6","Las Condes"))
        lista.add(CicloVia("Ciclovía 7","La Reina"))
        lista.add(CicloVia("Ciclovía 8","Ñuñoa"))
        lista.add(CicloVia("Ciclovía 9","Macul"))
        lista.add(CicloVia("Ciclovía 10","Providencia"))
    }
}