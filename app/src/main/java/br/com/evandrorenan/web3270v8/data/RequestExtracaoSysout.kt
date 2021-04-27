package br.com.evandrorenan.web3270v8.data
data class RequestExtracaoSysout(
    var evt: String = "",
    var usuario: String = "",
    var senha: String = "",
    var opcao: String = "",
    var jobId: String = ""
)
