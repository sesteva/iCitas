package com.icitas

class Registro {

    static constraints = {
    }
	
	static belongsTo = [paciente:Paciente]
	
	String toString(){
		"${this.paciente.nombre}"
	}
}
