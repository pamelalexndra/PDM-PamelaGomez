package com.example.ejercicio_1

class Computadora(
    var ram: Int,
    var almacenamiento: Int,
    var sistemaOperativo: String,
    var programasInstalados: List<String>
) {

    fun encenderComputadora() {
        println("Computadora encendida")
    }

    fun apagarComputadora() {
        println("Computadora apagada")
    }

    fun obtenerProgramas() : List<String> {
        return programasInstalados.filter { it.contains("2026") }
    }

    fun actualizar(nuevaRam: Int, nuevoAlma: Int, nuevoSo: String) {
        ram = nuevaRam
        almacenamiento = nuevoAlma
        sistemaOperativo = nuevoSo
        println("Computadora actualizada")
    }
}