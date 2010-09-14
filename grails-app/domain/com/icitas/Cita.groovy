package com.icitas

class Cita {
	
	Date fechaDeComienzo
	Date fechaDeFinalizacion

    static constraints = {
    }
	
	static belongsTo = [agenda:Agenda, paciente:Paciente]
	
	
}
