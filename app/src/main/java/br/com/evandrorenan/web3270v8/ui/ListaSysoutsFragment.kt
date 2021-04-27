package br.com.evandrorenan.web3270v8.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import br.com.evandrorenan.web3270v8.R
import br.com.evandrorenan.web3270v8.databinding.FragmentListaSysoutsBinding

class ListaSysoutsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentListaSysoutsBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_lista_sysouts,
            container,
            false)

        binding.listaSysoutFabConsultar.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                ListaSysoutsFragmentDirections.actionListaSysoutToConsultarSysout(0))
        )

        binding.listaSysoutFabExtrairNova.setOnClickListener (
            Navigation.createNavigateOnClickListener(
                ListaSysoutsFragmentDirections.actionListaSysoutToSolicitaExtracaoSysout())
//            A linha acima eh uma forma mais facil de fazer isso:
//            { view ->
//                val navController = view.findNavController()
//                navController.navigate(R.id.action_listaSysout_to_solicitaExtracaoSysout)
//            }
        )
        return binding.root
    }
}