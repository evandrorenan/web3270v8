package br.com.evandrorenan.web3270v8.data

data class Sysout(
    var id: Int,
    var evt: String,
    var opcao: String,
    var jobId: String,
    var content: String,
)