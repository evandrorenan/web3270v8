package br.com.evandrorenan.web3270v8.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.annotation.NonNull
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import br.com.evandrorenan.web3270v8.R
import br.com.evandrorenan.web3270v8.databinding.FragmentConsultarSysoutBinding

const val MIME_TEXT_PLAIN = "text/plain"

class ConsultarSysoutFragment : Fragment() {

    private lateinit var binding: FragmentConsultarSysoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentConsultarSysoutBinding>(
            inflater,
            R.layout.fragment_consultar_sysout,
            container,
            false
        )
        val args = ConsultarSysoutFragmentArgs.fromBundle(requireArguments())
        binding.consultarSysoutText.text = "Consultar sysout com id ${args.sysoutId}"
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_compartilhar_sysout, menu)

        //Esconde o menu de compartilhamento somente se existir activity compativel
        //O packageManager conhece todas as atividades de todos os apps registrados
        //Seria uma opcao deixar de inflar o menu tambem, mas novos itens que nao teem essa
        //dependencia podem ser adicionados no futuro
        if (null == getIntentCompartilharHardWay().resolveActivity(requireActivity().packageManager)) {
            menu?.findItem(R.id.menu_compartilhar_sysout)?.setVisible(false)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.i("Evandro", "TODO: compartilhar sysout")
        when (item.itemId) {
            R.id.menu_compartilhar_sysout -> compartilharSysout()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun compartilharSysout() {
        // Isso iria travar se nao encontrasse nenhuma activoty compativel com o Intent
        this.startActivity(getIntentCompartilharHardWay())
    }

    private fun getIntentCompartilharEasyWay() : Intent {
        return ShareCompat.IntentBuilder
            .from(requireActivity())
            .setText(binding.consultarSysoutText.text.toString())
            .setType(MIME_TEXT_PLAIN)
            .intent
    }

    private fun getIntentCompartilharHardWay() : Intent {
        var shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType(MIME_TEXT_PLAIN) // https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Basics_of_HTTP/MIME_types
                   .putExtra(Intent.EXTRA_TEXT, binding.consultarSysoutText.text.toString())
        return shareIntent
    }
}