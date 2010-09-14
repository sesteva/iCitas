package com.icitas

class PacienteService {

    static transactional = true
	def usuarioService

    def serviceMethod() {

    }
	
	def crearPaciente (Paciente paciente1){
		println "aca"
		println "primer servicio ${paciente1.nombre}"
		def pacienteCreado = usuarioService.crearUsuario(paciente1)
		println "${pacienteCreado}"
		println "${pacienteCreado.class}"
		
		Paciente paciente = new Paciente(pacienteCreado.properties)
		println "${paciente.properties}"
		return pacienteCreado
	}
}	
