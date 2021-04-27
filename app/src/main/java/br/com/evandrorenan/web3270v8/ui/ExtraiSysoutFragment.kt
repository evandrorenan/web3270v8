package br.com.evandrorenan.web3270v8.ui

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import br.com.evandrorenan.web3270v8.R
import br.com.evandrorenan.web3270v8.databinding.FragmentExtraiSysoutBinding
import br.com.evandrorenan.web3270v8.data.RequestExtracaoSysout

class ExtraiSysoutFragment : Fragment() {

    private val TAG1 = "Evandro Extrai"

    private lateinit var binding: FragmentExtraiSysoutBinding
    private var solicitacao = RequestExtracaoSysout()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dataBinding = DataBindingUtil.inflate<FragmentExtraiSysoutBinding>(
            inflater,
            R.layout.fragment_extrai_sysout,
            container,
            false
        )
        this.setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_extrai_sysout, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu_principal, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        this.findNavController().navigateUp()

        /* Se fosse navegar para outra tela:
        Nesse caso, o id do item deve ser exatamente identico ao id do Fragment de destino.
        Caso o item nao seja valido, onNavDestinationSelected vai retornar falso e o
        metodo super.onOptionsItemSelected serah acionado
         */

        return NavigationUI.onNavDestinationSelected(item!!,
            requireView().findNavController())
        || super.onOptionsItemSelected(item)
    }
}