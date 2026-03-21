package com.example.ejercicio_1

fun main() {
    val programas = listOf("Notion 2026", "Facebook 2024", "Spotify 2025")

    val compu = Computadora(
        ram = 16,
        almacenamiento = 256,
        sistemaOperativo = "Windows",
        programasInstalados = programas
    )

    compu.encenderComputadora()

    println("--- Datos iniciales ---")
    println("RAM: ${compu.ram} GB")
    println("Almacenamiento: ${compu.almacenamiento} GB")
    println("Sistema Operativo: ${compu.sistemaOperativo}")
    println("Programas del 2026: ${compu.obtenerProgramas()}")

    compu.actualizar(nuevaRam = 32, nuevoAlma = 512, nuevoSo = "Ubuntu")

    println("--- Después de actualizar ---")
    println("Nueva RAM: ${compu.ram} GB")
    println("Nuevo Almacenamiento: ${compu.almacenamiento} GB")
    println("Nuevo SO: ${compu.sistemaOperativo}")

    compu.apagarComputadora()
}