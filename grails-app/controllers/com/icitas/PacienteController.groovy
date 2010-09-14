package com.icitas

class PacienteController {

	def pacienteService
	
	static scaffold = true
	
	def alta = {
		def paciente = new Paciente()
		paciente.properties = params
		[paciente: paciente]
	
	}
	
	def crear = {
		if(params){
			def user = Paciente.findByNombreAndApellido(params.nombre, params.apellido)
			if(user){
				def paciente = new Paciente(params)
				paciente.errors.rejectValue "nombre", "El paciente ya existe"
				render(view: "alta", model: [paciente: paciente])
			}else{
			    
				def paciente1 = new Paciente(params)
				println "el paciente ${paciente1.nombre}"
				def paciente2 = pacienteService.crearPaciente(paciente1)
				println "paso"
				println "${paciente2}"
				if(paciente.save(flush:true)){
					flash.message = "created"
					redirect(action: "show", id: paciente.id)
				}else{
					render(view: "alta", model: [paciente: paciente])
				}
			}
		}
	}
	
	


}
